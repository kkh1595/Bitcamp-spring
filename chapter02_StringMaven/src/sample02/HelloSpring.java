package sample02;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationConText.xml");
		Calc calc;
		calc = (Calc)context.getBean("calcAdd"); 
		calc.calculate();
		
		calc = (Calc)context.getBean("calcMul"); 
		calc.calculate();
		
		((AbstractApplicationContext) context).close();
		
	}

}

            
