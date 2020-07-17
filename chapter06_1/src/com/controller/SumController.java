package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {
	
	@RequestMapping(value="/input.do",method=RequestMethod.GET) 
	public ModelAndView input() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/view/input.jsp"); 
		return mav;
	}
	 
	//---------------------------------------------
/*	@RequestMapping(value="/result.do",method=RequestMethod.POST) 
	//리턴타입이 String이면 단순 문자열이 아니라 뷰의 이름으로 사용된다.
	//뷰의 이름이 아니라 실제 문자열로 리턴하려면 @ResponseBody 를 사용하면 된다.
	public String result(@RequestParam(required=false, defaultValue="0") Map<String,Integer> map, ModelMap modelMap){
		//결과값
		modelMap.put("x",map.get("x"));
		modelMap.put("y",map.get("y"));
		return "/view/result.jsp"; 
	}*/
	
	@RequestMapping(value="/result.do", method=RequestMethod.POST)
	public String result(@ModelAttribute SumDTO dto, Model model){
		model.addAttribute("dto",dto);
		return "/view/result.jsp";
	}
	
}
