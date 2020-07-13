package sample03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Component
@Setter
@Getter
@ComponentScan("spring.conf")
public class SungJukDTO {
	private @Value("ss")String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;


	@Override
	public String toString() {
		return name+"\t"
			 +kor + "\t"
			 +eng + "\t"
			 +math +"\t"
			 +tot + "\t"
			 +String.format("%.2f", avg );
	}
}
