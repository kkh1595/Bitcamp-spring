package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;

@Controller
public class SungJukController {
	
	@RequestMapping(value="/input.so",method=RequestMethod.GET)
	public String input() {
		return "/sungJuk/input.jsp";
	}
	
	@RequestMapping(value="/result.so",method=RequestMethod.POST)
	public String result(@ModelAttribute SungJukDTO dto, Model model) {
		dto.setTot(dto.getKor()+dto.getEng()+dto.getMath());
		dto.setAvg(dto.getTot()/3.0);
		System.out.println(dto.getName());
		model.addAttribute("dto", dto);
		return "/sungJuk/result.jsp";
	}
}
