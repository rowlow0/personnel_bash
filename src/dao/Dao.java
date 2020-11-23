package dao;

import java.sql.*;
import java.util.*;

import dto.Dto;

public class Dao {
	private Connection con;
	private ResultSet rs;
	private int result;
	private PreparedStatement pstmt;
	
	private static class LazyHolder {
	    public static final Dao INSTANCE = new Dao();
	}
	
	private Dao() {}

	public static Dao getInstance() {
	    return LazyHolder.INSTANCE;
	}
	//요즘 싱글톤으로 대체. 초기화 문제 > JVM으로.static은 로딩시점에 한번만 호출. final로 다시 값 할당 x.

	
	//DriverManager인 oracle.jdbc.OracleDriver을 연결하는문. 메소드마다 재사용.
	public Connection getConnect() {
		String url="jdbc:oracle:thin:@localhost:1521/orcl";
		//oracle이 xe버전이면 xe orcl버전이면 orcl. port는 CMD->LSNRCTL.EXE->STATUS 확인.
		String id="test1",pw="1234";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(url,id,pw);
		}catch(ClassNotFoundException e) {
			//try문시 필수. 간단형태 catch(e){}.
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
		// con은 DriverManager.getConnection(jdbc:oracle:thin:@localhost:1521/orcl,"test1","1234")와 동일.
	}

	//db연결 종료. 메소드마다 재사용.
	public void close(Connection con,PreparedStatement pstmt,ResultSet rs) {
		//void type -> return 없음. close()사용시 매개변수(con,pstmt,rs) 사용 강제. 값이 없으면 오류 발생 필수 입력 값에 null도 가능.
		//public Connection는 return이 Connection이고
		//public int는 return이 int이다.
		//
		if(rs!=null) {
			try {rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int insert(String id,String name,String dept,String position,String duty,String phone) {
		StringBuffer query=new StringBuffer();
		query.append("insert into personnel values(?,?,?,?,?,?)");
		try {
			con=getConnect();
			pstmt=con.prepareStatement(query.toString());
			pstmt.setString(1, id.trim());
			pstmt.setString(2, name);
			pstmt.setString(3,dept);
			pstmt.setString(4, position.trim());
			pstmt.setString(5, duty);
			pstmt.setString(6, phone);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}return result;
	}
	
	public List<Dto> getIdList(String id) {
		 List<Dto> list=new ArrayList<Dto>();
		StringBuffer query=new StringBuffer();
		query.append("select*from personnel where id=?");
		try {
			con=getConnect(); //db 연결부터 try;
			pstmt=con.prepareStatement(query.toString());
			//query is object do toString;
		pstmt.setString(1,id.trim());
		rs=pstmt.executeQuery();
		//select Query
		while(rs.next()) {
			Dto dto=new Dto();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setDept(rs.getString("dept"));
			dto.setPosition(rs.getString("position"));
			dto.setDuty(rs.getString("duty"));
			dto.setPhone(rs.getString("phone"));
			list.add(dto);
		}
		}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}return list;
		
		
	}
	
	public List<Dto> getDeptList(String dept) {
		 List<Dto> list=new ArrayList<Dto>();
		StringBuffer query=new StringBuffer();
		query.append("select*from personnel where dept=?");
		try {
			con=getConnect();
			pstmt=con.prepareStatement(query.toString());
		pstmt.setString(1,dept );
		rs=pstmt.executeQuery();
		while(rs.next()) {
			Dto dto=new Dto();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setDept(rs.getString("dept"));
			dto.setPosition(rs.getString("position"));
			dto.setDuty(rs.getString("duty"));
			dto.setPhone(rs.getString("phone"));
			list.add(dto);
		}
		}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}return list;
		
		
	}
	
	public int update(String id,String name,String dept,String position,String duty,String phone) {
		StringBuffer query=new StringBuffer();
		query.append("update personnel set name=?,dept=?,position=?,duty=?,phone=? where id=?");
		try {
			con=getConnect();
			pstmt=con.prepareStatement(query.toString());
			pstmt.setString(1,name );
			pstmt.setString(2,dept);
			pstmt.setString(3, position.trim());
			pstmt.setString(4,duty );
			pstmt.setString(5,phone );
			pstmt.setString(6,id.trim());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}return result;
	}
	
	public int del(String id,String name) {
		StringBuffer query=new StringBuffer();
		query.append("delete personnel where id=? and name=?");
		try {
			con=getConnect();
			pstmt=con.prepareStatement(query.toString());
			pstmt.setString(1, id.trim());
			pstmt.setString(2, name);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}return result;
	}
}
