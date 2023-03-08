package mvc.twitter;

import java.sql.*;
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
			conn = DriverManager.getConnection(jdbc_url, user, pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
 	
	public TwitterLoginDO checkLogin(TwitterLoginDO loginDO) {
		TwitterLoginDO result = null;
		this.sql = "select * from twitter_login where id = ? and passwd= ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,loginDO.getId()); //loginDo에 있는걸 필요할때 빼서 쓰는..
			pstmt.setString(2,loginDO.getPasswd()); //loginDo에 있는걸 필요할때 빼서 쓰는..
			rs = pstmt.executeQuery(); // 결과를 받아오는 문장
			
			if(rs.next()) { // 로그인이 성공했을때. 즉 rs가 받아오는 값이 있을때
				result = new TwitterLoginDO();
				result.setId(rs.getString("id"));
				result.setPasswd(rs.getString("passwd"));
				result.setName(rs.getString("name"));
			}
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	

	public ArrayList<TwitterDO> getAllTwitter() { //로그인하고 들어갔을때 다양한 사용자들의 트윗을 보기위해 
		ArrayList<TwitterDO> list = new ArrayList<TwitterDO>();
		TwitterDO twitterDO = null;
		sql = "select twitter.id || '@' || name as id_name, message, " +
					"to_char(create_date, 'YYYY/MM/DD HH24:MI:SS') as cdatetime " +
					"from twitter inner join twitter_login " +
					"on twitter.id = twitter_login.id order by no";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				twitterDO = new TwitterDO();
				twitterDO.setId(rs.getString("id_name")); //쿼리로부터 받아오는 값들...id... 각각의 행마다 새로운 twitterdo객체를 만들고 .. 컬럼지정
				twitterDO.setMessage(rs.getString("message"));
				twitterDO.setCreateDate(rs.getString("cdatetime"));
				list.add(twitterDO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int insertTwitter(TwitterDO twitterDO) {
		int rowCount = 0;
		sql = "insert into twitter (no, id, message) values (twitter_seq.nextval, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, twitterDO.getId());
			pstmt.setString(2, twitterDO.getMessage());
			rowCount = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			}
			catch(Exception e) {
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
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
