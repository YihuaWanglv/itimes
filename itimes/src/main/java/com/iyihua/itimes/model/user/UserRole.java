package com.iyihua.itimes.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Entity
public class UserRole implements Serializable {

	private static final long serialVersionUID = 3382941398779185745L;
//	@Column(nullable = false)
	private Long userId;
//	@Column(nullable = false)
	private Integer roleId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
