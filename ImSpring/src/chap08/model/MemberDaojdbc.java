package chap08.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDaojdbc {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public MemberDaojdbc() {
	}
	
	@Override
	public Member selectByEmail(String email) {
		
		Member member = null;
		this.sql = "selec * from member where email = ? ";
				
				try {
					
					conn =  ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, email);
					rs = pstmt.executeQuery(sql);
					
					while(rs.next()) {
						member = new Member();
						member.setId(rs.getLong("id"));
						member.setEmail(rs.getString("email"));
						member.setPassword(rs.getString("password"));
						member.setName(rs.getString("name"));
						member.setRegisterDateTime(rs.getTimestamp("regdate").toLocalDateTime());
						
					}
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				finally {
					 try {
					      if(!conn.isClosed()) {
					         conn.close();
					      }
					   }
					   catch (Exception e) {
					      e.printStackTrace();
					   }

				}
				
		
		return member;
		
	}
	
	@Override
	public void insert(Member member) {
		this.sql = "insert into member(id,email,password,name) values (member_id_seq.nextval,?,?,?)";
		
		
		
		try {
			conn =  ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			rs = pstmt.executeQuery(sql);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
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
	
	@Override
	public void update(Member member) {
		this.sql = "update member set password = ? where email = ?";
		
		try {
			
			conn =  ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, member.getEmail());
			pstmt.setString(1, member.getPassword());
			rs = pstmt.executeQuery(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
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
	
	@Override
	public Collection<Member> selectAll() {
		ArrayList<Member> list = new ArrayList<Member>();
		Member member = null;
		this.sql = "select * from member order by id";
		
		try {
			
			conn =  ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				member = new Member();
				member.setId(rs.getLong("id"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegisterDateTime(rs.getTimestamp("regdate").toLocalDateTime());
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			 try {
			      if(!conn.isClosed()) {
			         conn.close();
			      }
			   }
			   catch (Exception e) {
			      e.printStackTrace();
			   }

		}
		
		return list;
		
	}
	
	
}
