package chap08.model;

import java.util.*;
import java.sql.*;
import javax.sql.*;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDaoSpring extends MemberDao {

	private JdbcTemplate jdbcTemplate;
	private String sql;
	
	public MemberDaoSpring(DataSource ds) {	
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	/* RowMapper 인터페이스를 익명 클래스로 구현하는 방법
	@Override
	public Member selectByEmail(String email) {
		this.sql = "select * from member where email = ?";
		
		List<Member> results = jdbcTemplate.query(this.sql,
				new RowMapper<Member>() { //익명의 클ㄹ래스만드는걱고..추상메소드를 구현해야한다. ................ 익명클래스통해서 rowmapper구현
			@Override
			public Member mapRow(ResultSet rs, int rowNum ) throws SQLException{
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegisterDateTime(rs.getTimestamp("regdate").toLocalDateTime());
				
				return member;
				
			}
		},email);
		
		return results.isEmpty() ? null : results.get(0);
		
	}
	*/
	
	/*
	//2. RowMapper 인터페이스를 람다 표현식 (lamdaExpressiont)으로 구현하는 방법.재사용불가
	@Override
	public Member selectByEmail(String email) {
		this.sql = "select * from member where email = ?";
		
		List<Member> results = jdbcTemplate.query(this.sql,
				(ResultSet rs,int rowNum)->{
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegisterDateTime(rs.getTimestamp("regdate").toLocalDateTime());
				
				return member;
				
			
		},email);
		
		return results.isEmpty() ? null : results.get(0);
		
	}
	*/
	
	//3. RowMapper 인터페이스를 직접 구현하는 MemberRowMapper 클래스를 생성하여 구현하는 방법
	
	@Override
	public Member selectByEmail(String email) {
		this.sql = "select * from member where email = ?";
		
		List<Member> results = jdbcTemplate.query(this.sql,new MemberRowMapper(),email);
		
		return results.isEmpty() ? null : results.get(0);
		
	}
	
	@Override
	public void insert(Member member) {
		this.sql = "insert into member (id, email, password, name) values (member_id_seq.nextval, ?, ?, ?)";
		
		
	}
	
	@Override
	public void update(Member member) {
		this.sql = "update member set password = ? where email = ?";
		
		
	}
	
	@Override
	public Collection<Member> selectAll() {
		ArrayList<Member> list = new ArrayList<Member>();
		Member member = null;
		this.sql = "select * from member order by id";
		
		
		return list;
	}
}

















