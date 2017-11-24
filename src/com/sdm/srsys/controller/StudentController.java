package com.sdm.srsys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdm.srsys.model.StudentInfo;
import com.sdm.srsys.service.StudentInfoService;
import com.sdm.srsys.util.JqGridResponse;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	private StudentInfoService studentInfoService;
	
	@Autowired
    MessageSource messageSource;
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET )
	public String main() {
		return "/common/landing";
	}
	
	@RequestMapping(value = { "stu-manage" }, method = RequestMethod.GET )
	public String empManage(ModelMap model) {
		StudentInfo stud = new StudentInfo();
        model.addAttribute("studentInfo", stud);
		return "/studentInfo/stuManage";
	}
	
	@RequestMapping(value = "loadStudentData", method = RequestMethod.POST)
	public @ResponseBody JqGridResponse loadEmployeeData(@ModelAttribute("studentInfo") StudentInfo studentInfo, @RequestParam("_search") Boolean search, @RequestParam(value = "filters", required = false) String filters,
			@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows, @RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "sord", required = false) String sord, @RequestParam(value = "enqData", required = false) String enqData) throws IOException {
		System.out.print("search:" + search);
		System.out.print("::filters:" + filters);
		System.out.print("::page:" + page);
		System.out.print("::rows:" + rows);
		System.out.print("::sidx:" + sidx);
		System.out.print("::sord:" + sord);
		System.out.print(":::enqData:" + enqData);

		int recPerPage = new Integer(rows);
		int curPage = new Integer(page);
		int intpage = curPage * recPerPage;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		
		List<StudentInfo> dataList = new ArrayList<StudentInfo>();
		StudentInfo o = new StudentInfo();
		if (enqData != null) {
			studentInfo = mapper.readValue(enqData, StudentInfo.class);
//			 o.setAuthor(StringUtils.isNotBlank(form.getAuthor()) ? form.getAuthor() : "");
//			 o.setBookid(StringUtils.isNotBlank(form.getBookid()) ? form.getBookid() : "");
//			 o.setBookname(StringUtils.isNotBlank(form.getBookname()) ? form.getBookname() : "");
//			 o.setCopies(StringUtils.isNotBlank(form.getCopies()) ? form.getCopies() : "");
//			 o.setPublication(StringUtils.isNotBlank(form.getPublication()) ? form.getPublication() : "");
//			 o.setSubject(StringUtils.isNotBlank(form.getSubject()) ? form.getSubject() : "");
			 
		}
		
//		dataList = getDataList();
		int firstResult = ((page - 1) * rows);
		Integer count = studentInfoService.countStudentInfo(o).intValue();
		dataList = studentInfoService.findStudentInfo(o, firstResult, recPerPage, sidx, sord);
		
		if (dataList != null) {
			System.out.println("Got dataList size::" + dataList.size());
			JqGridResponse jqGridResponse = new JqGridResponse();
			jqGridResponse.setPage(page + ""); // current page
			jqGridResponse.setRecords(count + ""); // total number of records
			int noPages = count.intValue() / rows;
			if (count.intValue() % rows > 0) {
				noPages = noPages + 1;
			}
			jqGridResponse.setTotal(noPages + ""); // total number of pages
			jqGridResponse.setRows(dataList);
			return jqGridResponse;
		} else {
			System.out.println("No dataList::" + dataList);
			return null;
		}
	}

}
