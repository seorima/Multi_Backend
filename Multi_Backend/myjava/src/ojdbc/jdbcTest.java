package ojdbc;

public class jdbcTest {

	private String username;
	private String email; //외부에서 접근할 수 없어요 , 생성자를 통해서 초기화 가능 하지만 초기화된 username과 emiail을 읽을수 잇는 방법은 없다
	
	public jdbcTest(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	public String getUsername() {
		return this.username; //username에 대한 getter 이거통해서 값을 읽는다
	}
	
	public String getEmail() {
		return this.email; //email에 대한 getter 이거통해서 값을 읽는다
		
		
	}
}//jdbc에서 받아들인 테이블 정보를 객체로 저장을하고 객체를 데이터 전달용으로 사용하겠다.
//데이터 오브젝트, 도메인 오브젝트 


//하나의 행 정보를 객체로,,
