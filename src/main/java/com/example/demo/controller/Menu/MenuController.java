package com.example.demo.controller.Menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController{
	
	//topページ画面遷移
	@GetMapping("/top")
	public String getTop(Model model) {
		return "top";
	}
}