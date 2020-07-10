package sample05;

import java.util.HashSet;
import java.util.Map;

public class SungJukImpl implements SungJuk {

	@Override
	public void calc(String name,int kor, int eng, int math) {
		int tot = kor+ eng+ math;
		int avg = (int)tot/3;
		display(name,kor,eng,math,tot,avg);
	}

	@Override
	public void display(String name,int kor, int eng, int math, int tot, int avg) {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t");
		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+avg);
		
	}
	
}
