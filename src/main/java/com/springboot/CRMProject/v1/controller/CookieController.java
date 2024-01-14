package com.springboot.CRMProject.v1.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/cookie")
public class CookieController {

	@GetMapping
	public String createCookie(HttpServletResponse response, HttpServletRequest request){
		// Tao Cookie
//		Cookie cookie = new Cookie("hello", "emlacookiene!");
//		Cookie cookie1 = new Cookie("username", URLEncoder.encode("Phạm Ngọc Phúc", StandardCharsets.UTF_8));
//
//		response.addCookie(cookie);
//		response.addCookie(cookie1);

		/* Lay toan bo Cookie nguoi dung truyen len */
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();

			if("hello".equals(name)){
				System.out.println("Kiem tra name: "+name);
				System.out.println("Kiem tra value: "+value);
			}
		}
		return "login";
	}
}
