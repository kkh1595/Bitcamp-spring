package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcMul implements Calc {
	private int x;
	private int y;
	
	@Autowired //자동주입
	public void setX(@Value("8")int x) {
		this.x = x;
	}
	
	@Autowired
	public void setY(@Value("5")int y) {
		this.y = y;
	}

	@Override
	public void calculate() {
		System.out.println(x+"*"+y+" = "+x*y);		
	}
}
