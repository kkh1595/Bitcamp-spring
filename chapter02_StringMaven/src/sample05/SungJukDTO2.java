package sample05;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class SungJukDTO2 {
	private String name; // 이름은 중복 불가 
	private int kor; 
	private int eng; 
	private int math; 
	private int tot; 
	private double avg;
	
	public String toString() {
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f",avg);
	}
}
