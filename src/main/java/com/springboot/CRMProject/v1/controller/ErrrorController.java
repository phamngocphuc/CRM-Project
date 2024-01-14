package com.springboot.CRMProject.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrrorController {

	@GetMapping("/notFound")
	public String pageNotFound(){
		return "404";
	}
}
