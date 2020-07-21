package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping(value="/index/modifyForm",method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm.jsp";
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
	@RequestMapping(value="/index/list",method=RequestMethod.GET)
	public String userList() {
		return "/user/list.jsp";
	}

	
//	@RequestMapping(value="/user/getUserList",method=RequestMethod.POST)
//	public @ResponseBody JSONObject getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		JSONObject json = new JSONObject();
//		if(list!=null) {
//			JSONArray  array = new JSONArray();
//			for (int i = 0; i < list.size(); i++) {
//				UserDTO userDTO = list.get(i);
//				
//				JSONObject temp = new JSONObject();
//				temp.put("name", userDTO.getName());
//				temp.put("id", userDTO.getId());
//				temp.put("pwd", userDTO.getPwd());
//				
//				array.add(i,temp);
//			}
//			json.put("list", array);
//		}
//		return json;
//	}
	
//	@RequestMapping(value="/user/getUserList",method=RequestMethod.POST)
//	public @ResponseBody Map<String, Object>  getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		JSONArray array = JSONArray.fromObject(list);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("list", array);
//		
//		return map;
//	}
	
	@RequestMapping(value="/user/getUserList",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getUserList() {
		List<UserDTO> list = userService.getUserList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/user/modify",method=RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}
	
}
	
