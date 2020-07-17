package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do",method=RequestMethod.GET) 
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result","Have a nice day");
		mav.setViewName("/view/hello"); //   /view/hello.jsp
		return mav;
		
	}

}
