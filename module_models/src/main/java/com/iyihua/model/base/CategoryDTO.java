package com.iyihua.model.base;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 7515327812218240002L;
	private Long categoryId;
	private Long userId;
	private String categoryName;
	private Integer categoryType;
	private Long parentId;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Long categoryId, Long userId, String categoryName, Integer categoryType, Long parentId) {
		super();
		this.categoryId = categoryId;
		this.userId = userId;
		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", userId=" + userId + ", categoryName=" + categoryName
				+ ", categoryType=" + categoryType + ", parentId=" + parentId + "]";
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
