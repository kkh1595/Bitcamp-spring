package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class SungJukModify implements SungJuk {
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
	@Override
	public void execute() {
		Scanner scanner= new Scanner(System.in);
		System.out.println("수정할 이름 입력: ");
		String name = scanner.next();
		int sw=0;
		for (SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				sw =1; 
				System.out.print("국어 점수 입력: ");
				sungJukDTO2.setKor(scanner.nextInt());
				System.out.print("영어 점수 입력: ");
				sungJukDTO2.setEng(scanner.nextInt());
				System.out.print("수학 점수 입력: ");
				sungJukDTO2.setMath(scanner.nextInt());
				sungJukDTO2.setTot(sungJukDTO2.getKor() + sungJukDTO2.getEng() + sungJukDTO2.getMath());
				sungJukDTO2.setAvg(sungJukDTO2.getTot() / 3.0);
				System.out.println("성적 정보가 수정되었습니다. ");
			}
		}
		if(sw == 0) {
			System.out.println("등록된 정보가 없습니다. ");
		}
	}
}
