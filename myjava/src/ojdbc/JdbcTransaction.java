package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class JdbcTransaction {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public JdbcTransaction() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver); // 아 이런이름의 테이블은 만든다 이건가..
			this.conn = DriverManager.getConnection(jdbc_url, user, pwd);
			conn.setAutoCommit(false); //생성자에서 false 해놨기때문에 트랜잭션 내가 직접 제어하겠다!! 라는 의미 , ㄱ느데 close하면 자동 커밋됨
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int dynamicInsert(String username, String email) { //우선 그 insertTest3에 있는거 복붙해옴
		int rowCount = 0;
		this.sql = "insert into jdbc_test values(?, ?)";
		
		try {
			this.pstmt = this.conn.prepareStatement(this.sql);
			this.pstmt.setString(1, username);
			this.pstmt.setString(2, email);
			
			rowCount = this.pstmt.executeUpdate();
			
		/*	if(rowCount==1) { //정상적으로 입력이 되었다면
				this.conn.commit();
			}*/
		}
		catch (SQLException e) { 
			e.printStackTrace();
		}
		finally {
			try {
				if(!this.pstmt.isClosed()) {
					this.pstmt.close();
				} 
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rowCount;
	}
	
	public void closeConnection() {
		try {
			if(!this.conn.isClosed()) {
				this.conn.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) { //우선 그 insertTest3에 있는거 복붙해옴,,,, 그리고 수업중 메인코드와 다름 savepoint가 안돼ㅠ
		JdbcTransaction jt = new JdbcTransaction();
		int rowCount = 0;
		Savepoint s3 = null;
		
		rowCount = jt.dynamicInsert("김연경", "kim_yk@naver.com");
		System.out.println(rowCount + "개의 행이 입력되었습니다.");
		
	/*try {
			SavePoint s3 = jt.conn.setSavePoint("s3");
		}
		*/
		jt.closeConnection();
	}
}
