package com.iyihua.itimes.mapper.report;

import java.util.List;

import org.springframework.stereotype.Component;

import com.iyihua.model.base.report.CategoryReport;


@Component
public interface ReportMapper {

	public List<CategoryReport> reportCategory();
}
