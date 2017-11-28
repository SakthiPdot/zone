package com.zone.enter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageController {
		
		@Autowired
		private PageDao pageDao;
	
		@RequestMapping( value = "/enter", method = RequestMethod.GET)
			public ModelAndView enter(HttpServletRequest request){
			ModelAndView model = new ModelAndView();
			model.setViewName("enter/1");
			return model;				
		}
		
		@RequestMapping(value = "/student_creation", method=RequestMethod.POST)
		public ModelAndView studentCreation(@RequestBody PageModel page, HttpServletRequest request){
			DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
			Date date = new Date();
			ModelAndView model = new ModelAndView();
			page.setCreated_date(dateFormat.format(date).toString());
			page.setUpdated_date(dateFormat.format(date).toString());
			page.setActive("Y");
			page.setObsolete("N");			
			pageDao.saveOrUpdate(page);
			model.setViewName("enter/1");
			return model;			
		}
}
