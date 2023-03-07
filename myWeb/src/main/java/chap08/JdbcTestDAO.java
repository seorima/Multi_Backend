package chap08;

import java.sql.*;
import java.util.ArrayList;

public class JdbcTestDAO {

	
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
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,user,pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	public int insertJdbcTest(JdbcTestDO testDO) { //jdbcdo 객체가 하나의 행정보를 의미하는데 그거를 이용ㅇ해서 db에있는 행정보를..나타내기위해?
		
		int rowCount = 0;
		
		sql = "insert into jdbc_test values(?,?)";
		
		try{
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
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
		
		return list;
	}

	public void closeConnection() {
		
		 try {
		      if(!conn.isClosed()) {
		         conn.close();
		      }
		   }
		   catch (Exception e) {
		      e.printStackTrace();
		   }
		 
	}


}
