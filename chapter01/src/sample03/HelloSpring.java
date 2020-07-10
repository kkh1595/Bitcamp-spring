package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean bean = (MessageBean)context.getBean("messageBean"); 
												//applicationContext.xml 의 id값
		MessageBean bean2=  context.getBean("messageBean",MessageBean.class); 
		MessageBean bean3 = (MessageBean)context.getBean("messageBean");
		MessageBean bean4 = (MessageBean)context.getBean("messageBean");
		
		bean.sayHello("스프링");
		bean2.sayHello("슈프림");
		bean3.sayHello("빈3");
		bean4.sayHello("빈4상태");
		
	}
}
