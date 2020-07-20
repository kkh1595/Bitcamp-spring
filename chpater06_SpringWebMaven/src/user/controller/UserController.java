package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/index/writeForm/")
	public String input() {
		return "/user/writeForm.jsp";
	}
	@RequestMapping(value="/index/deleteForm/")
	public String deleteForm() {
		return "/user/deleteForm.jsp";
	}

	@RequestMapping(value="/user/write",method=RequestMethod.POST)
	public @ResponseBody void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	@RequestMapping(value="/user/checkId",produces="application/String;charset=UTF-8",method=RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam String id) {
		String result = userService.checkId(id);
		
		return result;
	}
	
	@RequestMapping(value="/user/delete",method=RequestMethod.POST)
	public @ResponseBody void delete(@RequestParam String id) {
		userService.delete(id);
	}
}
	
