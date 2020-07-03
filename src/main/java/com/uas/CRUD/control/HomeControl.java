package com.uas.CRUD.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeControl {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

}
