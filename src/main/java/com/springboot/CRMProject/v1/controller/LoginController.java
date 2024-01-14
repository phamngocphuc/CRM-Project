package com.springboot.CRMProject.v1.controller;

import com.springboot.CRMProject.v1.entity.Role;
import com.springboot.CRMProject.v1.entity.User;
import com.springboot.CRMProject.v1.repository.RoleRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.CRMProject.v1.repository.UserRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepository;

	@GetMapping("")
	public String login(HttpServletRequest request, Model model){
		Cookie[] cookies = request.getCookies();
		String email = "";
		String password = "";

		if(cookies != null){
			for (Cookie cookie : cookies) {
				if ("email".equals(cookie.getName())){
					email = cookie.getValue();
				}
				if("password".equals(cookie.getName())){
					password = cookie.getValue();
				}
			}
		}

		model.addAttribute("email",email);
		model.addAttribute("password",password);
		return "login";
	}

	@PostMapping("")
	public String processLogin(@RequestParam String email,@RequestParam String password,
			@RequestParam(required = false, defaultValue = "false") boolean remember,
			Model model, HttpServletResponse response, HttpSession httpSession){

		Optional<User> userOptional = userRepo.findByEmailAndPassword(email,password);
		boolean isSuccess = false;

		if(userOptional.isPresent()){
			isSuccess = true;

			Optional<Role> optionalRole = roleRepository.findById(userOptional.get().getRoleId());

			if (optionalRole.isPresent()){
				httpSession.setAttribute("role", optionalRole.get().getName());
			}

//			 Su dung Session luu du lieu
			httpSession.setAttribute("email", email);
			httpSession.setMaxInactiveInterval(8 * 60 * 60);

		/*	if (remember){
				Cookie cookieEmail = new Cookie("email",email);
				Cookie cookiePassword = new Cookie("password",password);

				response.addCookie(cookieEmail);
				response.addCookie(cookiePassword);
			}
			else
			{
				Cookie cookieEmail = new Cookie("email", null);
				Cookie cookiePassword = new Cookie("password", null);

				cookieEmail.setMaxAge(0);
				cookiePassword.setMaxAge(0);

				response.addCookie(cookieEmail);
				response.addCookie(cookiePassword);
			}*/
		}

		model.addAttribute("isSuccess", isSuccess);
		model.addAttribute("isRemember", remember);

		return "redirect:/";
	}
}
