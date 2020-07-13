package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("spring.conf")
public class SungJukImpl implements SungJuk {
	@Autowired 
	private SungJukDTO sungJukDTO;
	
//	public SungJukImpl(SungJukDTO sungJukDTO) {
//		this.sungJukDTO = sungJukDTO;
//	} //롬복으로 처리
	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor()
				+sungJukDTO.getEng()
				+sungJukDTO.getMath());
	}
	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);;
	}
	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungJukDTO);
	}
	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름입력: ");
		sungJukDTO.setName(scan.next());
		System.out.print("국어 점수 입력: ");
		sungJukDTO.setKor(scan.nextInt());
		System.out.print("영어 점수 입력: ");
		sungJukDTO.setEng(scan.nextInt());
		System.out.print("수학 점수 입력: ");
		sungJukDTO.setMath(scan.nextInt());
	}

}
