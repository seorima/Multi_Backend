package chap12;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.ArrayList;

public class JdbcTestDAO {

	private DataSource ds = null;
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	public JdbcTestDAO() {
		
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp:env/jdbc/oracleXE");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	public int insertJdbcTest(JdbcTestDO testDO) { //jdbcdo 객체가 하나의 행정보를 의미하는데 그거를 이용ㅇ해서 db에있는 행정보를..나타내기위해?
		
		int rowCount = 0;
		
		this.sql = "insert into jdbc_test values(?,?)";
		
		try{
			conn= ds.getConnection(); //커넥션풀로부터 빌려오는것.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,testDO.getUsername());
			pstmt.setString(2,testDO.getEmail());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(!pstmt.isClosed()){
					pstmt.close();
				}
				
				if(!conn.isClosed()) {
					conn.close();
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return rowCount;
	}

	
	public ArrayList<JdbcTestDO> selectAllJdbcTest(){ //jdbctest테이블에있는 모든정보를 다 읽어온다
		
		ArrayList<JdbcTestDO> list = new ArrayList<JdbcTestDO>();
		JdbcTestDO testDO = null;
		
		sql = "select * from jdbc_test";
		
		try{
			conn= ds.getConnection(); //커넥션풀로부터 빌려오는것.
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				testDO = new JdbcTestDO();  //행의 수만큼 testDo 만들어짐
				testDO.setUsername(rs.getString("username"));
				testDO.setUsername(rs.getString("email"));
				
				list.add(testDO);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(!stmt.isClosed()){
					stmt.close();
				}
				if(!conn.isClosed()) {
					conn.close();
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
		
		return list;
	}

	

}
