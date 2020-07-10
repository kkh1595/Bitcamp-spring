package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample03.MessageBean;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc;
		calc = (Calc)context.getBean("calcAdd"); 
		calc.calculate(10, 20);
		
		calc = (Calc)context.getBean("calcMul"); 
		calc.calculate(10, 20);
		
		((AbstractApplicationContext) context).close();
		
	}

}
