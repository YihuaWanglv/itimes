package com.iyihua.model.component.message;

import java.io.Serializable;
import java.util.Map;

public class EmailMessage implements Serializable {

	private static final long serialVersionUID = 5774992021320625396L;
	private final String to;
	private final String title;
	private final Map<String, Object> params;
	public EmailMessage(final String to, final String title, final Map<String, Object> params) {
		super();
		this.to = to;
		this.title = title;
		this.params = params;
	}
	public String getTo() {
		return to;
	}
	public String getTitle() {
		return title;
	}
	public Map<String, Object> getParams() {
		return params;
	}

}
