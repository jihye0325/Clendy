package com.kh.clendy.CScenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CScenter")
public class CScenterController {
	
	@GetMapping("/FAQ")
	public void toFAQ() {}
	
	@GetMapping("/board")
	public void toBoard() {}
	
	@GetMapping("/personalQ")
	public void toPersonalQ() {}

}
