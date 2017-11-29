package com.zone.student;

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
public class StudentController {
		
		@Autowired
		private StudentDao pageDao;
	
		@RequestMapping( value = "/student", method = RequestMethod.GET)
			public ModelAndView enter(HttpServletRequest request){
			ModelAndView model = new ModelAndView();
			model.setViewName("student/student");
			return model;				
		}
		
		@RequestMapping(value = "/student_creation", method=RequestMethod.POST)
		public ModelAndView studentCreation(@RequestBody StudentModel page, HttpServletRequest request){
			DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
			Date date = new Date();
			ModelAndView model = new ModelAndView();
			page.setCreated_date(dateFormat.format(date).toString());
			page.setUpdated_date(dateFormat.format(date).toString());
			page.setActive("Y");
			page.setObsolete("N");			
			pageDao.saveOrUpdate(page);
			model.setViewName("student/student");
			return model;			
		}
}
