package sample01;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
	@NonNull private String fruit;
	private int cost;
	private int qty;
	
//	public MessageBeanImpl(String fruit,int cost) {
//		this.fruit = fruit;
//		this.cost= cost;
//	}

	@Override
	public void sayHello() {
		System.out.println(fruit+"\t"+cost+"\t"+qty);
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit+"\t"+cost+"\t"+qty);
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit+"\t"+cost+"\t"+qty);
	}

}
