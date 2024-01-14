package com.springboot.CRMProject.v1.filter;

import com.springboot.CRMProject.v1.repository.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Objects;

public class CustomLoginFilter implements Filter {

	@Autowired
	private UserRepository userRepo;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession session = request.getSession();

		String path = request.getServletPath();
		System.out.println("Check Auth filter: -> "+path);

		// Check login thanh cong
		if (Objects.nonNull(session) && Objects.nonNull(session.getAttribute("email"))){

			response.sendRedirect("http://localhost:8080");
		}else{

			// Cho vao page login
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}
}
