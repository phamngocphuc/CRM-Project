package com.springboot.CRMProject.v1.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

public class AuthenticationFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession session = request.getSession();

		String path = request.getServletPath();
		System.out.println("Check Auth filter: -> "+path);

		// Neu login thanh cong
		if (Objects.nonNull(session) && Objects.nonNull(session.getAttribute("email"))){

			/* Kiem tra role co phai ROLE_ADMIN hay khong */
			if("ROLE_ADMIN".equals(session.getAttribute("role"))){
				// Cho vao page role/add
				filterChain.doFilter(servletRequest, servletResponse);
			}else{
				response.sendRedirect("http://localhost:8080/error/notFound");
			}
		}else{

			// tra ve page login
			response.sendRedirect("http://localhost:8080/login");
		}
	}

	/**
	 * Khi người dùng gọi link /role/add nếu có quyền ADMIN thì mới cho vào
	 * còn không có quyền thì chuyền về page 404.html
	 *
	 * Lưu ý: Nếu đăng nhập thành công nếu không có quyền thì chuyển về 404.html ngược lại cho vào
	 *        Nếu đăng nhập không thành công thì chuyển về lại page /login
	 */

}
