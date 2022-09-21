package prac.DI;

public class Account {
	private String id;
	private String pw;
	
	public Account(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public boolean equals(Object arg0) {
		Account inputacc = (Account) arg0;
		if (inputacc.getId().equals(this.getId())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", pw=" + pw + "]";
	}
	
}
