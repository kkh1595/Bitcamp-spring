package sample05;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukInput implements SungJuk {
	List<SungJukDTO2> list;
	private SungJukDTO2 sungJukDTO2;
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String name = scanner.next();
		System.out.print("국어 입력: ");
		int kor = scanner.nextInt();
		System.out.print("영어 입력: ");
		int eng = scanner.nextInt();
		System.out.print("수학 입력: ");
		int math = scanner.nextInt();
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setTot(sungJukDTO2.getKor()+sungJukDTO2.getMath()+sungJukDTO2.getEng());
		sungJukDTO2.setAvg(sungJukDTO2.getTot()/3.0);
		
		list.add(sungJukDTO2);
		
		System.out.println(sungJukDTO2.getName() + "님 데이터 입력완료");
	}

}
