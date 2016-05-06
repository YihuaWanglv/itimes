package com.iyihua.remote.base.report;

import java.util.List;

import com.iyihua.model.base.report.CategoryReport;
import com.iyihua.model.base.report.CategoryTimeReport;
import com.iyihua.model.base.report.ReportData;
import com.iyihua.model.base.report.ReportQuery;

public interface ReportRemote {

	public List<CategoryReport> reportCategory();
	
	public List<CategoryTimeReport> reportCategoryTime();

	/**
	 * ����GroupType���򵥵�����ʱ��ͳ��
	 * 	type=0,��ʾ����categoryͳ��
	 *  type=1,��ʾ����projectͳ��
	 *  type=2,��ʾ����locationͳ��
	 * @param query
	 * @return
	 */
	public List<ReportData> reportSimple(ReportQuery query);
	
	/**
	 * ����GroupType����ʱ����������ʱ��ͳ��
	 * 	type=0,��ʾ����categoryͳ��
	 *  type=1,��ʾ����projectͳ��
	 *  type=2,��ʾ����locationͳ��
	 * Ĭ�ϵ�ʱ�����ά��Ϊmonth
	 * @param query
	 * @return
	 */
	public List<ReportData> reportWithTime(ReportQuery query);
}
