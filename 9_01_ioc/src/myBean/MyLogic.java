package myBean;

public class MyLogic {

	private MyBean mybean;
	
	public MyLogic(MyBean mybean) {
		this.mybean = mybean;
	}
	
	public void someMethod() {
		System.out.println("다음작업을 수행하려면 객체의존성이 필요합니당");
		mybean.hello();
	}

}
