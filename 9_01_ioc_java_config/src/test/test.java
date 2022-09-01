package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.greenart.MyDataRepository;

public class test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("component-scan.xml");
		MyDataRepository repo = context.getBean(MyDataRepository.class);
		
		System.out.println(repo.getMyNumbers());

	}

}
