package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("이름입력 : ");
		String name = scan.next();
		System.out.print("국어입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학입력 : ");
		int math = scan.nextInt();
		
		SungJuk sungJuk = context.getBean("sungJukImpl",SungJuk.class);
		sungJuk.calc(name,kor,eng,math);
		
		
	}
}
