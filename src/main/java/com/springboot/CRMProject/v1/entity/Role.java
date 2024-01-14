package com.springboot.CRMProject.v1.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "roleEnity")
	private List<User> users;
}

