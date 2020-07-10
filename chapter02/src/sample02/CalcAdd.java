package sample02;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalcAdd implements Calc {
	private @Value("22")int x;
	private int y;

	@Override
	public void calculate() {
		System.out.println(x+"+"+y+" = "+(x+y));
	}
}
