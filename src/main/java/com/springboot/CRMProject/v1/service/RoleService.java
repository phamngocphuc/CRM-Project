package com.springboot.CRMProject.v1.service;

import com.springboot.CRMProject.v1.entity.Role;
import com.springboot.CRMProject.v1.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getAll(){
		return roleRepository.findAll();
	}

	public boolean saveRole(String name, String description){
		Boolean isSuccess = false;
		Role role = new Role();

		if(name.length() > 0){
			role.setName(name);
			role.setDescription(description);

			Integer roleId = roleRepository.save(role).getId();
			if(roleId != null){
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}else{
			isSuccess = false;
		}

		return isSuccess;
	}
}
