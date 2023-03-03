package mvc.twitter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TwitterDAO {

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	public TwitterDAO() {
		
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
	
	public TwitterLoginDO getLoginDO(TwitterLoginDO loginDO) { //boolean을 반환하는것이 아니라 로그인실패하면 result = null, 성공하면 null이아닌 어떠한 값.
		TwitterLoginDO result = null;
		sql = "select * from twitter_login where id = ? and passwd = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginDO.getId()); // 위에 물음표에 id값이 들어갑니다. 
			pstmt.setString(2, loginDO.getPasswd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginDO = new TwitterLoginDO();
				result.setId(rs.getString("id"));
				result.setPasswd(rs.getString("passwd"));
				result.setname(rs.getString("name")); 
				
			}
			
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<TwitterDO> getAllTwitter(){
		ArrayList<TwitterDO> list = new ArrayList<TwitterDO>();
		TwitterDO twitterDO = null;
		
		sql = "select twitter.id || '@' || name as id_name, message," ;
		sql +="to_char(create_date, 'YYYY/MM/DD HH24:MI:SS') as cdatetime";
		sql +="from twitter inner join twitter_login";
		sql +="	on twitter.id = twitter_login.id ";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				twitterDO = new TwitterDO();
				twitterDO.setId(rs.getString("id_name"));
				twitterDO.setMessage(rs.getString("message"));
				twitterDO.setDate(rs.getString("cdatetime"));
				list.add(twitterDO);
				
			}
		}catch(Exception e) {
		      e.printStackTrace();
		   }
		
		finally {
			try {
			      if(stmt.isClosed()) {
			    	 stmt.close();
			      }
			   }
			   catch (Exception e) {
			      e.printStackTrace();
			   }
		}
		
		return list;
				
	}

	public int insertTwitter(TwitterDO twitterDO) {
		int rowCount = 0;
		
		sql = "insert into twitter(no, id, message) values (twitter_seq.nextval,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, twitterDO.getId()); // 위에 물음표에 id값이 들어갑니다. 
			pstmt.setString(2, twitterDO.getMessage());
			rowCount = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
		      e.printStackTrace();
		   }
		
		finally {
			try {
			      if(!pstmt.isClosed()) {
			    	  pstmt.close();
			      }
			   }
			   catch (Exception e) {
			      e.printStackTrace();
			   }
		}
		
		
		return rowCount;
		
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
