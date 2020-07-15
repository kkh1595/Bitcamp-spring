package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserInsertService implements UserService{
	private UserDTO userDTO;
	private UserDAO userDAO;
	
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String name = scanner.next();
		System.out.print("아이디 입력: ");
		String id = scanner.next();
		System.out.print("비밀번호 입력: ");
		String pwd = scanner.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		userDAO.write(userDTO);
		System.out.println(name + "의 정보 get");
	}

}
