package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.customerdto;
import common.DBManager;

public class customerdao {

	public int insert(customerdto dto) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBManager.getConnection();
			String sql="INSERT INTO customer(userid,name,phone,pdate)";
			sql+="VALUES(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getUserid());
			pstmt.setString(2,dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getPdate());
			return pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt,con); //★무조건 실행하게 해야함.
			
		}
		
	}
	
	public int update(customerdto dto) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBManager.getConnection();
			String sql="UPDATE CUSTOMER SET NAME=?,PHONE=?,DATE=? )";
			sql+="WHERE USERID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getPdate());
			pstmt.setInt(4, dto.getUserid());
			return pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt,con); //★무조건 실행하게 해야함.
			
		}
	}

	public int delete(int id) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBManager.getConnection();
			String sql="DELETE FROM CUSTOMER ";
			sql+="WHERE USERID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt,con); //★무조건 실행하게 해야함.
			
		}
	}
	
	
	
	
	public customerdto selectOne(int id) throws Exception {
		customerdto dto=null;
	
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBManager.getConnection();
			String sql="SELECT * from CUSTOMER WHERE userid=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new customerdto();
				dto.setUserid(rs.getInt("userid"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setPdate(rs.getString("pdate"));
				
			}
		} finally {
			DBManager.releaseConnection(pstmt,con); //★무조건 실행하게 해야함.
			
		}
		return dto;
		
	}
	
	public List<customerdto> selectAll() throws Exception {
		List<customerdto> list=new ArrayList<>();
	
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBManager.getConnection();
			String sql="SELECT * from CUSTOMER";
			pstmt=con.prepareStatement(sql);
		
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				customerdto dto=new customerdto();
				
				dto.setUserid(rs.getInt("userid"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setPdate(rs.getString("pdate"));
				list.add(dto);
			}
		} finally {
			DBManager.releaseConnection(pstmt,con); //★무조건 실행하게 해야함.
			
		}
		return list;
		
	}

}
