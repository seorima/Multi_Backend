package chap04;

public class LoginBean { //public 
	
	private String id;
	private String passwd; //private
	
	public LoginBean() {
		//매개변수가없는 생성자를 생성해주어야합니다.
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPasswd() {
		return this.passwd;
	}
	
	public boolean checkLogin() {
		final String ID =  "longlee";
		final String PASSWD = "6789";
		boolean result = false;
		
		if(this.id !=null && this.id.equals(ID) && this.passwd !=null && this.passwd.equals(PASSWD)) {
			result = true;
		}
		
		return result;
	}

}
