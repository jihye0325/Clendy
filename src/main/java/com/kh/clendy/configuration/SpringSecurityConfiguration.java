package com.kh.clendy.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kh.clendy.member.model.service.MemberService;

/* 스프링 시큐리티 설정 활성화 + bean 등록 가능 */
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter implements AuthenticationFailureHandler{
   
   private MemberService memberService;
     
   @Autowired 
   public SpringSecurityConfiguration(MemberService memberService) {
      this.memberService = memberService;
   }
      
   /* 암호화에 사용 */
   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }
   
   /* 정적 리소스는 권한 없이도 접근 가능하게끔 무시할 경로 작성 */
   @Override
   public void configure(WebSecurity web) {
      web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
   }
   
   /* HTTP 요청에 대한 설정 */
   @Override 
   protected void configure(HttpSecurity http) throws Exception {
      http
         // .csrf().disable()   /* 일단 비활성화 -> 이후에 변경 */
         .headers().frameOptions().disable()
         .and()
         .authorizeRequests()   /* 요청에 대한 권한 체크 */ 
            .antMatchers("/mypage/**").authenticated()   // "/mypage/**" 요청은 인증되어야함
            .antMatchers("/seller/**").authenticated()   // "/mypage/**" 요청은 인증되어야함
            .antMatchers("/member/new_Pwd").authenticated()
            /* 상품 정보 인증 관련*/
            //.antMatchers("/product/**").authenticated()
            // .antMatchers("/product/list/**").anonymous()
            .antMatchers("/product/view").anonymous()
            .antMatchers("/product/cart/**").authenticated()
            /* 1:1 문의 인증 */
            .antMatchers("/CScenter/personalQ/**").authenticated()
            /* 관리자페이지 - 관리자 인증 */
            .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
            /* 공지사항 - 관리자 인증 */
            .antMatchers("/CScenter/board/insert").hasAuthority("ROLE_ADMIN")
            .antMatchers("/CScenter/board/delete").hasAuthority("ROLE_ADMIN")
            .antMatchers("/CScenter/board/modify").hasAuthority("ROLE_ADMIN")
            /* FAQ - 관리자 인증 */
            .antMatchers("/CScenter/FAQ/modify").hasAuthority("ROLE_ADMIN")
            .antMatchers("/CScenter/FAQ/delete").hasAuthority("ROLE_ADMIN")
            .antMatchers("/CScenter/insertFAQ").hasAuthority("ROLE_ADMIN")
            .antMatchers("/CScenter/FAQ/insert").hasAuthority("ROLE_ADMIN")
            /* 1:1 문의 - 관리자 인증 */
            .antMatchers("/CScenter/personalQ").hasAuthority("ROLE_ADMIN")
            .antMatchers("/CScenter/personalQ/delete").hasAuthority("ROLE_ADMIN")
            .antMatchers("/CScenter/personalQ/insertAnswer").hasAuthority("ROLE_ADMIN")
            .antMatchers("/CScenter/personalQ/modify").hasAuthority("ROLE_ADMIN")
            /* 입점 신청 권한 */
            .antMatchers("/common/joinStore").authenticated()
            .anyRequest().permitAll()   /* 그 외의 요청들은 모두 허가함 - 게스트 사용자 접근 가능 */
         .and()
            .formLogin()   /* 로그인 설정 */
            .loginPage("/member/login")   /* 로그인 페이지 설정 */
            .successForwardUrl("/")    /* 로그인 성공 시 랜딩 페이지 설정 */
            .failureHandler(this)	/* 실패시 제어 */
         .and() 
            .logout()   /* 로그아웃 설정 */
            .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")) /* 로그아웃 요청 주소 */
            .deleteCookies("JSESSIONID")   /* JSESSIONID 쿠키 삭제 */
            .invalidateHttpSession(true)   /* 세션 만료 */
            .logoutSuccessUrl("/")      /* 로그아웃 성공 시 랜딩 페이지 */  
         .and()
            .exceptionHandling()
            .accessDeniedPage("/common/denied");
   }
   
   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      /* 로그인, 로그아웃 MemberController 작성x, 스프링 시큐리티 모듈로 처리 */
      /* 유저 인증을 위해 사용할 MemberService 등록, 사용하는 패스워드 인코딩 방식 설정 */
      auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
   }
   
   @Override
   public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response
		   , AuthenticationException exception) throws ServletException, IOException {
			   
	   request.setAttribute("msg", "fail");
	   request.getRequestDispatcher("/member/loginfail").forward(request, response);
	   
   }
   
}