package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;
import user.dao.UserDAOMybatis;

public class UserUpdateService implements UserService{
	@Setter
	private UserDAO userDAO;
	@Setter
	private UserDTO userDTO;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 아이디 입력: ");
		String id = scanner.nextLine();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO==null) {
			System.out.println("없는 아이디입니다");
			return;
		}
		System.out.println("이름\t비밀번호");
		System.out.println(userDTO.getName()+"\t"+userDTO.getPwd());
		System.out.println("===============================");
		
		System.out.print("이름 수정 : ");
		String name = scanner.nextLine();
		System.out.print("비밀번호 수정 : ");
		String pwd = scanner.nextLine();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name",name);
		map.put("pwd",pwd);
		map.put("id",id);
		System.out.println(map.get("name"));
		userDAO.modify(map);
		System.out.println("수정완료");
		
	}
}
