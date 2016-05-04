package com.iyihua.itimes.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.itimes.component.security.LoginSessionManager;
import com.iyihua.model.base.report.CategoryReport;
import com.iyihua.remote.base.report.ReportRemote;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired private ReportRemote reportService;
	
	@Autowired private LoginSessionManager loginSessionManager;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<CategoryReport> showCategoryReport() {
//		Long userId = loginSessionManager.getSessionUserId();
		List<CategoryReport> result = reportService.reportCategory();
		return result;
	}

	
	
}
