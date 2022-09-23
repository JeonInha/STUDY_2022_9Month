package prac.DI;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DBConfig.class)
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "prac.DI")
public class AccountConfig {
	
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
}
