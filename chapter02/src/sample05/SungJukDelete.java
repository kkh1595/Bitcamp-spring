package sample05;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukDelete implements SungJuk {
private List<SungJukDTO2> list;
	@Override
	public void execute() {
		int sw=0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름 입력: ");
		String name = scanner.next();
		Iterator<SungJukDTO2> it = list.iterator();
		while(it.hasNext()) {
			if(it.next().getName().equals(name)) {
				it.remove();
				sw=1;
				System.out.println(name + "님의 데이터를 삭제하였습니다.");
			}
		}//while
		if(sw==0) {
			System.out.println("찾는 이름이 없습니다");
		}
	}

}
