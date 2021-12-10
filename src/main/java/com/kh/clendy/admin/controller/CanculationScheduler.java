package com.kh.clendy.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.kh.clendy.admin.model.service.CalculationService;

@SpringBootApplication
@EnableScheduling
public class CanculationScheduler {
	
	private CalculationService calculationService;
	
	@Autowired
	public CanculationScheduler(CalculationService calculationService) {
		this.calculationService = calculationService;
	}
	
	/* 정산 스케쥴러
	  (cron = "초(0-59) 분(0-59) 시간(0-23) 일(1-31) 월(1-12) 요일(0-7)") 
	  요일 : 0,7은 일요일, 1=월요일 6=토요일 */
	@Scheduled(cron = "0 36 10 10 * *")
	public void makeCalculation() {
		calculationService.makeCalculation();
	}
}
