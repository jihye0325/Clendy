package com.kh.clendy.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.kh.clendy", annotationClass = Mapper.class)
public class MyBatisConfiguration {

}
