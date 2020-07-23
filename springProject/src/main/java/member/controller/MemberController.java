package member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/login",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@RequestBody Map<String,Object> map, ModelAndView model, HttpSession session) {
		MemberDTO memberDTO = memberService.login(map);
		if(memberDTO==null) {
			String result = "fail";
			model.addObject("result",result);
			model.setViewName("jsonView");
			return model;
		}
		session.setAttribute("memId", map.get("id"));
		session.setAttribute("memName", memberDTO.getName());
		model.addObject("memberDTO", memberDTO);
		model.setViewName("jsonView");
		
		return model;
	}
	@RequestMapping(value="/member/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session,Model model) {
		session.invalidate();
		//model.addAttribute("display","/template/body.jsp");
		return new ModelAndView("redirect:/main/index");
	}
	
}
