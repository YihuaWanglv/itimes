package com.iyihua.itimes.mapper.report;

import java.util.List;

import org.springframework.stereotype.Component;

import com.iyihua.model.base.report.CategoryReport;
import com.iyihua.model.base.report.CategoryTimeReport;


@Component
public interface ReportMapper {

	public List<CategoryReport> reportCategory();
	
	public List<CategoryTimeReport> reportCategoryTime();
}
