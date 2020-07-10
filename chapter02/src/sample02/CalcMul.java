package sample02;

import org.springframework.beans.factory.annotation.Value;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class CalcMul implements Calc {
	private int x;
	private int y;
	

	@Override
	public void calculate() {
		System.out.println(x+"*"+y+" = "+x*y);		
	}
}
