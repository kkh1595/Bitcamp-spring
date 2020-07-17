package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.conf.SpringConfiguration;
import user.service.UserService;

@Component
public class HelloSpring {
	public void menu(ApplicationContext context) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		UserService service;
		while(true) {
			System.out.println();
			System.out.println("--------------");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.끝");
			System.out.println("--------------");
			System.out.print("번호입력: ");
			choice = scanner.nextInt();
			if(choice==5) break;
			if(choice==1) {
				service = context.getBean("userInsertService",UserService.class);
			}else if(choice==2) {
				service = context.getBean("userSelectService",UserService.class);
			}else if(choice==3) {
				service = context.getBean("userUpdateService",UserService.class);
			}else if(choice==4) {
				service = context.getBean("userDeleteService",UserService.class);
			}else {
				System.out.println("1~5까지만.");
				continue;
			}
			service.execute();
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		HelloSpring helloSpring = context.getBean("helloSpring",HelloSpring.class);
		helloSpring.menu(context);
	
	}
}
