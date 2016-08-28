package com.jfn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jfn.entity.Calendar;
import com.jfn.service.AccountManager;
import com.jfn.service.CalendarService;
import com.jfn.service.FileService;
import com.jfn.service.NewsService;

@Controller
@RequestMapping("/")
public class DocController {

	@Autowired
	private FileService service;
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private FileService fileservice;
	@Autowired
	private NewsService newsservice;
	@Autowired
	private CalendarService calendarservice;
/**
 * 杰出青年
 * @param request
 * @param model
 * @return
 */
	@RequestMapping(value = "jcqnDoc01", method = RequestMethod.GET)
	public String jcqndoc01(HttpServletRequest request, Model model) {
		return "jcqnDoc/doc01";
	}
	
	@RequestMapping(value = "jcqnDoc02", method = RequestMethod.GET)
	public String jcqndoc02(HttpServletRequest request, Model model) {
		return "jcqnDoc/doc02";
	}
	@RequestMapping(value = "jcqnDoc03", method = RequestMethod.GET)
	public String jcqndoc03(HttpServletRequest request, Model model) {
		return "jcqnDoc/doc03";
	}
	@RequestMapping(value = "jcqnDoc04", method = RequestMethod.GET)
	public String jcqndoc04(HttpServletRequest request, Model model) {
		return "jcqnDoc/doc04";
	}
	@RequestMapping(value = "jcqnDoc05", method = RequestMethod.GET)
	public String jcqndoc05(HttpServletRequest request, Model model) {
		return "jcqnDoc/doc05";
	}
	@RequestMapping(value = "jcqnDoc06", method = RequestMethod.GET)
	public String jcqndoc06(HttpServletRequest request, Model model) {
		return "jcqnDoc/doc06";
	}
	@RequestMapping(value = "jcqnDoc07", method = RequestMethod.GET)
	public String jcqndoc07(HttpServletRequest request, Model model) {
		return "jcqnDoc/doc07";
	}
	/**
	 * 科技领军
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "kjljDoc01", method = RequestMethod.GET)
	public String kjljdoc01(HttpServletRequest request, Model model) {
		return "kjljDoc/doc01";
	}
	@RequestMapping(value = "kjljDoc02", method = RequestMethod.GET)
	public String kjljdoc02(HttpServletRequest request, Model model) {
		return "kjljDoc/doc02";
	}
	@RequestMapping(value = "kjljDoc03", method = RequestMethod.GET)
	public String kjljdoc03(HttpServletRequest request, Model model) {
		return "kjljDoc/doc03";
	}
	@RequestMapping(value = "kjljDoc04", method = RequestMethod.GET)
	public String kjljdoc04(HttpServletRequest request, Model model) {
		return "kjljDoc/doc04";
	}
	@RequestMapping(value = "kjljDoc05", method = RequestMethod.GET)
	public String kjljdoc05(HttpServletRequest request, Model model) {
		return "kjljDoc/doc05";
	}
	@RequestMapping(value = "kjljDoc06", method = RequestMethod.GET)
	public String kjljdoc06(HttpServletRequest request, Model model) {
		return "kjljDoc/doc06";
	}
	@RequestMapping(value = "kjljDoc07", method = RequestMethod.GET)
	public String kjljdoc07(HttpServletRequest request, Model model) {
		return "kjljDoc/doc07";
	}
/**
 * 创新团队
 * @param request
 * @param model
 * @return
 */
	@RequestMapping(value = "cxtdDoc01", method = RequestMethod.GET)
	public String cxtddoc01(HttpServletRequest request, Model model) {
		return "cxtdDoc/doc01";
	}
	@RequestMapping(value = "cxtdDoc02", method = RequestMethod.GET)
	public String cxtddoc02(HttpServletRequest request, Model model) {
		return "cxtdDoc/doc02";
	}
	@RequestMapping(value = "cxtdDoc03", method = RequestMethod.GET)
	public String cxtddoc03(HttpServletRequest request, Model model) {
		return "cxtdDoc/doc03";
	}
	@RequestMapping(value = "cxtdDoc04", method = RequestMethod.GET)
	public String cxtddoc04(HttpServletRequest request, Model model) {
		return "cxtdDoc/doc04";
	}
	@RequestMapping(value = "cxtdDoc05", method = RequestMethod.GET)
	public String cxtddoc05(HttpServletRequest request, Model model) {
		return "cxtdDoc/doc05";
	}
	@RequestMapping(value = "cxtdDoc06", method = RequestMethod.GET)
	public String cxtddoc06(HttpServletRequest request, Model model) {
		return "cxtdDoc/doc06";
	}
	@RequestMapping(value = "cxtdDoc07", method = RequestMethod.GET)
	public String cxtddoc07(HttpServletRequest request, Model model) {
		return "cxtdDoc/doc07";
	}
	
	@RequestMapping(value = "docMain", method = RequestMethod.GET)
	public String docMain(HttpServletRequest request, Model model) {
		Calendar calendar = calendarservice.getById("1");
		model.addAttribute("calendar", calendar);
		return "doc/docMain";
	}

	@RequestMapping(value = "docIndex", method = RequestMethod.GET)
	public String docIndex(HttpServletRequest request, Model model) {
		return "doc/docIndex";
	}

}
