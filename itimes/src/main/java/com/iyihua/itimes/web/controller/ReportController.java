package com.iyihua.itimes.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.itimes.component.security.LoginSessionManager;
import com.iyihua.model.base.report.CategoryReport;
import com.iyihua.model.base.report.CategoryTimeReport;
import com.iyihua.model.component.JsonObject;
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
	
	@RequestMapping(value = "/categoryTime", method = RequestMethod.GET)
	public JsonObject showCategoryTimeReport() {
		JsonObject json = new JsonObject();
		List<CategoryTimeReport> result = reportService.reportCategoryTime();
		Set<String> labels = new HashSet<String>();
		Map<String, Map<String, List<BigDecimal>>> report = new HashMap<String, Map<String, List<BigDecimal>>>();
		for (CategoryTimeReport ctr : result) {
			String date = ctr.getReportdate();
			String category = ctr.getCategoryName();
			BigDecimal durations = ctr.getDurations();
			labels.add(ctr.getReportdate());
			if (report.get(date) == null) {
				Map<String, List<BigDecimal>> cm = new HashMap<String, List<BigDecimal>>();
				List<BigDecimal> list = new ArrayList<BigDecimal>();
				list.add(durations);
				cm.put(category, list);
				report.put(date, cm);
			} else {
				Map<String, List<BigDecimal>> cm = report.get(date);
				if (cm.get(category) == null) {
					List<BigDecimal> list = new ArrayList<BigDecimal>();
					list.add(durations);
					cm.put(category, list);
					report.put(date, cm);
				} else {
					List<BigDecimal> list = cm.get(category);
					list.add(durations);
					cm.put(category, list);
					report.put(date, cm);
				}
			}
		}
		json.setData(report);
		return json;
	}

	
	
}
