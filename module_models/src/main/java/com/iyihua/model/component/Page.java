package com.iyihua.model.component;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = -8110767556267656062L;

	private int page = 1;
	private int total;
	private int size = 20;
	private int max;
	protected Integer start = 0;
	private List<T> items;

	public Page() {
		super();
	}

	public Page(int page, int total, int size, int max, Integer start, List<T> items) {
		super();
		this.page = page;
		this.total = total;
		this.size = size;
		this.max = max;
		this.start = start;
		this.items = items;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

}
