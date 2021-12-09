package com.kh.clendy.mainpage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.mainpage.model.service.MainpageService;
import com.kh.clendy.mainpage.model.vo.MainProduct;
import com.kh.clendy.member.model.vo.UserImpl;

@Controller
public class MainpageController {
	private MainpageService mainpageService;

	@Autowired
	public MainpageController(MainpageService mainpageService) {
		this.mainpageService = mainpageService;
	}

	@GetMapping(value = { "/", "/mainpage" })
	public String main(Model model) {
		List<MainProduct> mainProductList = mainpageService.selectMainProdudct();
		model.addAttribute("mainProductList", mainProductList);

		return "mainpage/mainpage";
	}

	@PostMapping(value = "/")
	public String redirectMain(RedirectAttributes redirectAttr) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user.getTemp_pwd_yn().equals("Y")) {
			redirectAttr.addFlashAttribute("msg", "임시비밀번호로 로그인하셨습니다.\\n비밀번호를 변경 후 이용해주세요.");
		}
		return "redirect:/";
	}
}
