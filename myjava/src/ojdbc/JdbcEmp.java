package ojdbc;

import java.sql.*;
import java.util.Calendar;

/*

update emp
set hiredate = to_date('1980/12/17 14:25:30', 'YYYY/MM/DD HH24:MI:SS')
where empno = 7369;

commit; //업데이트하고 커밋 필수

*/
public class JdbcEmp {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public JdbcEmp() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver);
			this.conn = DriverManager.getConnection(jdbc_url, user, pwd);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dynamicSelect() {
		/*
		this.sql = "select empno, ename, sal, to_char(hiredate, 'YYYY-MM-DD HH24:MI:SS') as hiredate " + 
						"from emp where empno = ?";
		*/
		
		this.sql = "select empno, ename, sal, hiredate from emp where empno = ?";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setInt(1, 7369);
			
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				/*
				System.out.println(this.rs.getInt("empno") + "\t" + this.rs.getString("ename") + "\t" + 
						this.rs.getDouble("sal") + "\t" + this.rs.getString("hiredate"));
				*/
				
				/*
				Date hiredate = this.rs.getDate("hiredate");
				String newHiredate = hiredate.getYear() + "/" + hiredate.getMonth() + "/" + hiredate.getDate()
						+ " " + hiredate.getHours(); // + ":" + hiredate.getMinutes() + ":" + hiredate.getSeconds(); // 0. 얘네 오류남 java.sql.Date은 날짜만 표현가능하고 시간은 표현이 가능하지 않기때문에
				*/
				
				// Timestamp timestamp = this.rs.getTimestamp("hiredate"); //위에 오류나서, timestamp객체는 날짜, 시간 모두 표현가능
				// java.util.Date uDate = timestamp; //java.util.Date 의 자식 클래스여서 가능
				
				java.util.Date uDate = this.rs.getTimestamp("hiredate"); // 두개 합쳐진 ㅇㅇ 자바에서 시간과 날짜 표현하는 표준클래스 java.util.Date
				
				// System.out.printf("입사일시: %1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초", uDate); // 1.서식문자로 처리하는 방법
				
				/*
				String newHiredate = uDate.getYear() + "/" + uDate.getMonth() + "/" + uDate.getDate()
					+ " " + uDate.getHours() + ":" + uDate.getMinutes() + ":" + uDate.getSeconds();   // 2.java.util.Date 통해서 각각 뽑아서 개별적으로 표현하느 방법
				*/
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(uDate);
				
				String newHiredate = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + 
						calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.HOUR) + ":" + 
						calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				System.out.println(this.rs.getInt("empno") + "\t" + this.rs.getString("ename") + "\t" + 
						this.rs.getDouble("sal") + "\t" + newHiredate);  //날짜와 시간값 처리 방법 , 날짜와 시간 각각 사용하게된다면 이런식으로.
			}
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
	
	public static void main(String[] args) {
		JdbcEmp je = new JdbcEmp();
		je.dynamicSelect();  //
		
		je.closeConnection();
	}
}












