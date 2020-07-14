package sample01;

//핵심관심사항
//Target
public class MessageBeanImpl implements MessageBean {
	private String str;

	public void setStr(String str) {
		this.str = str;
	}

	//JoinPoint들 (pointCut의 후보들)
	//Before,After를 pointCut으로 설정
	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메시지 = " + str);
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메시지 = " + str);
	}

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메시지 = " + str);
	}
	
	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter 메시지 = " + str);
	}
	
	@Override
	public void display() {
		System.out.println("display 메시지 = " + str);
	}

	@Override
	public String showPrint() {
		System.out.println("showPrint = "+str);
		return "리턴값";
	}
	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrint = " +str);
	}
	




}
