package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		SungJuk sj;
		sj = (SungJuk)context.getBean("sungJukImpl");
		sj.calcTot();
		sj.calcAvg();
		sj.display();
		
		System.out.println("\n수정");
		sj.modify();
		sj.calcTot();
		sj.calcAvg();
		sj.display();
	}
}
