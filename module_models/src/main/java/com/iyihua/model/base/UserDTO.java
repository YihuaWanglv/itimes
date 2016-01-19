
package com.iyihua.model.base;

import java.io.Serializable;

import com.iyihua.model.component.FieldExtend;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 127199294326731001L;

	private Long id;
	private String name;
	private String password;
	private Integer type;

	private FieldExtend fieldExtend = new FieldExtend();

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String name, Integer type) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public FieldExtend getFieldExtend() {
		return fieldExtend;
	}
	public void setFieldExtend(FieldExtend fieldExtend) {
		this.fieldExtend = fieldExtend;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return getId() + "," + getName() + "," + getType();
	}

}
