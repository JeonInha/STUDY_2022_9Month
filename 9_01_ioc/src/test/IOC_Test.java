package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myBean.MyBean;
import myBean.MyLogic;
import myBean.MyStatefulObj;

public class IOC_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		MyBean b = context.getBean(MyBean.class);
		
		b.hello();
		
		MyBean b2 = context.getBean("first", MyBean.class);
		System.out.println(b == b2); // result = true;
		
		MyLogic b3 = context.getBean(MyLogic.class);
		b3.someMethod();
		
		MyStatefulObj b4 = context.getBean(MyStatefulObj.class);
		System.out.println(b4.toString());
		b4.setName("으앙");
		b4.setNumber("300");
		
		MyStatefulObj onMoretime = context.getBean(MyStatefulObj.class);
		System.out.println(onMoretime.toString());
		// 하나의 객체이기때문에 이렇게 달라짐
		// 싱글턴 패턴
		
		// 근데 스코프가 프로토타입이면 맨날 새로 해서 줌 ! (대신 IOC 관리대상에선 제외됨)
		
		
		MyStatefulObj fourth = context.getBean(MyStatefulObj.class);
		System.out.println(fourth.toString());
		// bean 2개 있으면 이렇게 오류를 뱉어냄! 
	
		
		
		
		
	}
}
