package com.iyihua.model.query;

import java.io.Serializable;
import java.util.Date;

public class UserItemQueryDTO implements Serializable {

	private static final long serialVersionUID = 8815731290188501622L;

	private Long userId;
	private Long categoryId;
	private Long locationId;
	private Long projectId;
	private String tags;
	private Date dateStart;
	private Date dateEnd;
	private String dateStringStart;
	private String dateStringEnd;
	
}
