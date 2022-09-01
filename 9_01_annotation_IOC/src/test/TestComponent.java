package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myBeans.FirstComponent;
import myBeans.SecondComponent;
import myBeans.ThirdComponent;

public class TestComponent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		FirstComponent comp = context.getBean(FirstComponent.class);
		comp.hello();
		
		FirstComponent byName = context.getBean("id", FirstComponent.class);
		byName.hello();
		
		System.out.println(comp == byName);
		
		SecondComponent second = context.getBean(SecondComponent.class);
		System.out.println(second);
		second.myServiceMethod();
		
		ThirdComponent third = context.getBean(ThirdComponent.class);
		System.out.println(third);
	}
}
