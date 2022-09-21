package prac.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
				
		ApplicationContext context = new AnnotationConfigApplicationContext(prac.DI.AccountConfig.class);
		MainLogic main = context.getBean(MainLogic.class);

		main.mainLogic();
	}

}
