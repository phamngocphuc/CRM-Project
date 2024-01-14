package com.springboot.CRMProject.v1.controller;

import com.springboot.CRMProject.v1.entity.Role;
import com.springboot.CRMProject.v1.repository.RoleRepository;
import com.springboot.CRMProject.v1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/get")
	public String findAll(Model model){

		List<Role> roleList = roleService.getAll();
		model.addAttribute("roleList", roleList);

		return "role-table";
	}

	@GetMapping("/add")
	public String addRole(){
		return "role-add";
	}

	@PostMapping("/add")
	public String processAddRole(@RequestParam String name, @RequestParam String description,
			Model model){

		boolean isSuccess = roleService.saveRole(name, description);

		model.addAttribute("isSuccess",  isSuccess);
		return "role-add";
	}

	/**
	 * Thuc hien chuc nang xoa role
	 * Thuc hienc chuc nang them moi thanh vien
	 */

}
