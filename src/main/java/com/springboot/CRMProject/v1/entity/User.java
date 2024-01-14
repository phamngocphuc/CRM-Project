package com.springboot.CRMProject.v1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "role_id")
	private Integer roleId;

	@ManyToOne
	@JoinColumn(name = "role_id", updatable = false, insertable = false)
	/* bo sung  'updatable = false, insertable = false' tranh loi duplicate column 'role_id' */
	private Role roleEnity;
}
