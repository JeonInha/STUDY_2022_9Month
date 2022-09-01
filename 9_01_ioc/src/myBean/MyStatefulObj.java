package myBean;

public class MyStatefulObj {
	private String name;
	private String number;
	
	
	

	public MyStatefulObj(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	
	public MyStatefulObj() {

	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "MyStatefulObj [name=" + name + ", number=" + number + "]";
	}
	
	
	
	
}
