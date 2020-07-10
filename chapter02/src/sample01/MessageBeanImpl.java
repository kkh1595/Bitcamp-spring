package sample01;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
	@NonNull private String fruit;
	private int cost, qty;
	
	
//	public MessageBeanImpl(String fruit) {
//		this.fruit = fruit;
//	}

	@Override
	public void sayHello() {
		System.out.println(fruit+"\t"+"cost"+"\t"+qty);
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit+"\t"+"cost"+"\t"+qty);
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit+"\t"+"cost"+"\t"+qty);
	}

}
