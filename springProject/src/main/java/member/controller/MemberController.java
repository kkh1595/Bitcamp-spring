package member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
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
		session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
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
	@RequestMapping(value="/member/getMemberInfo",method=RequestMethod.GET)
	public String modify(Model model,HttpSession session) {
		String id = (String)session.getAttribute("memId");
		MemberDTO memberDTO = memberService.getMemberInfo(id);
		session.setAttribute("memberDTO", memberDTO);
		model.addAttribute("display","/member/modifyForm.jsp");
		return "/main/index.jsp";
	}
	@RequestMapping(value="/member/checkPost",method=RequestMethod.GET)
	public String checkPost() {
		return "/member/checkPost.jsp";
	}
	@RequestMapping(value="/member/writeForm",method=RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("display","/member/writeForm.jsp");
		return "/main/index.jsp";
	}
	@RequestMapping(value="/member/checkId",produces="application/String;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String checkId(@RequestParam String id) {
		MemberDTO memberDTO = memberService.getMemberInfo(id);
		String result="";
		if(memberDTO==null) {
			System.out.println("없다없어");
			result="사용가능";
		}else {
			System.out.println(memberDTO.getName());
			result="사용불가능";
		}
		return result;
	}
	@RequestMapping(value="/member/addrList",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView addrList(@ModelAttribute ZipcodeDTO zipcodeDTO, HttpSession session, ModelAndView mav){
		List<ZipcodeDTO> list = memberService.addrList(zipcodeDTO);
		mav.addObject("list",list);
		mav.setViewName("jsonView");
		//session.setAttribute("list", list);
		return mav;
	}
	
}
