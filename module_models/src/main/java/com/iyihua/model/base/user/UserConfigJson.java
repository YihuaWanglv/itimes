package com.iyihua.model.base.user;

import java.io.Serializable;

public class UserConfigJson implements Serializable {

	private static final long serialVersionUID = 1507401697090937031L;
	
	private int isreportCategory = 1;
	private int isreportCategoryTime = 1;
	private int isreportProject = 0;
	private int isreportProjectTime = 0;
	private int isreportLocation = 0;
	private int isreportLocationTime = 0;
	
	public int getIsreportCategory() {
		return isreportCategory;
	}
	public void setIsreportCategory(int isreportCategory) {
		this.isreportCategory = isreportCategory;
	}
	public int getIsreportCategoryTime() {
		return isreportCategoryTime;
	}
	public void setIsreportCategoryTime(int isreportCategoryTime) {
		this.isreportCategoryTime = isreportCategoryTime;
	}
	public int getIsreportProject() {
		return isreportProject;
	}
	public void setIsreportProject(int isreportProject) {
		this.isreportProject = isreportProject;
	}
	public int getIsreportProjectTime() {
		return isreportProjectTime;
	}
	public void setIsreportProjectTime(int isreportProjectTime) {
		this.isreportProjectTime = isreportProjectTime;
	}
	public int getIsreportLocation() {
		return isreportLocation;
	}
	public void setIsreportLocation(int isreportLocation) {
		this.isreportLocation = isreportLocation;
	}
	public int getIsreportLocationTime() {
		return isreportLocationTime;
	}
	public void setIsreportLocationTime(int isreportLocationTime) {
		this.isreportLocationTime = isreportLocationTime;
	}
	
}
