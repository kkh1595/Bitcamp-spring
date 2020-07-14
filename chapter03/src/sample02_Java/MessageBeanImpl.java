package sample02_Java;

//핵심코드
public class MessageBeanImpl implements MessageBean {

	@Override
	public void study() {
		System.out.println("수업시간에 공부한다");
	}

	@Override
	public String game() {
		System.out.println("수업시간에 몰래 게임하기");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "몰겜 성공";
	}

}
