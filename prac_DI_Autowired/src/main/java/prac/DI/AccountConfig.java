package prac.DI;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "prac.DI")
public class AccountConfig {
	
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
}
