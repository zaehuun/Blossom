package com.ex.spring9;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MyController {
	
	@RequestMapping("/onemap")
	public String onemap() {
		
		return "onemap";
	}
}
