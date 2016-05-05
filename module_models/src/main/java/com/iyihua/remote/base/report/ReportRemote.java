package com.iyihua.remote.base.report;

import java.util.List;

import com.iyihua.model.base.report.CategoryReport;
import com.iyihua.model.base.report.CategoryTimeReport;

public interface ReportRemote {

	public List<CategoryReport> reportCategory();
	
	public List<CategoryTimeReport> reportCategoryTime();
}
