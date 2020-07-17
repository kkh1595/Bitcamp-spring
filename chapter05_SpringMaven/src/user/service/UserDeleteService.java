package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.dao.UserDAO;

@Service
public class UserDeleteService implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.print("삭제할 아이디 입력 : ");
		String id = scanner.next();
	
		int count = userDAO.getUserCount(id);
		if(count == 0) {
			System.out.println("찾고자 하는 아이디가 없습니다");
			return;
		}
			
		userDAO.delete(id);
		
		System.out.println(id + "님의 정보를 삭제 완료");

	}
}










