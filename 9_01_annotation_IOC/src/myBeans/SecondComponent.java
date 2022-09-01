package myBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
	
	@Autowired
	private FirstComponent need;
	
	public SecondComponent(FirstComponent need) {
		super();
		this.need = need;
	}

	public void setNeed(FirstComponent need) {
		this.need = need;
	}
	
	public void myServiceMethod() {
		System.out.println("의존성이 필요함");
		need.hello();
	}
}
