package chap08;

public class JdbcTestDO {
//폼으로부터 들어오는 정보를 저장하고 (파라미터형식)/ 데이터베이스의 특정행 정보를 저장. 전달. (모델입니다)
	
		private String username;
		private String email;
		
		public JdbcTestDO() {
			
		}
		
		public void setUsername(String username) {
			this.username=username;
		}
		
		public String getUsername() {
			return this.username;
		}
		
		public void setEmail(String email) {
			this.email=email;
		}
		
		public String getEmail() {
			return this.email;
		}
		
		
	}


