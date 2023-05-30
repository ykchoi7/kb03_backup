package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.productdto;

public class productdao {
	public int insert(productdto dto) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBManager.getConnection();
			String sql="INSERT INTO PRODUCT(pid,pname,firm,price,jego,pdate)";
			sql+="VALUES(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPid());
			pstmt.setString(2,dto.getPname());
			pstmt.setString(3, dto.getFirm());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setInt(5, dto.getJego());
			pstmt.setString(6, dto.getPdate());
			return pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt,con); //★무조건 실행하게 해야함.
			
		}
		
	}
	
	public int update(productdto dto) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBManager.getConnection();
			String sql="UPDATE PRODUCT SET PNAME=?,FIRM=?,PRICE=?,JEGO=?,PDATE=? )";
			sql+="WHERE PID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getFirm());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setInt(4, dto.getJego());
			pstmt.setString(5, dto.getPdate());
			pstmt.setInt(6, dto.getPid());
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
			String sql="DELETE FROM PRODUCT ";
			sql+="WHERE PID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt,con); //★무조건 실행하게 해야함.
			
		}
	}
	
	
	
	
	public productdto selectOne(int id) throws Exception {
		productdto dto=null;
	
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBManager.getConnection();
			String sql="SELECT * from PRODUCT WHERE pid=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new productdto();
				dto.setPid(rs.getInt("pid"));
				dto.setPname(rs.getString("pname"));
				dto.setFirm(rs.getString("firm"));
				dto.setPrice(rs.getInt("price"));
				dto.setJego(rs.getInt("jego"));
				dto.setPdate(rs.getString("pdate"));
				
			}
		} finally {
			DBManager.releaseConnection(pstmt,con); //★무조건 실행하게 해야함.
			
		}
		return dto;
		
	}
	
	public List<productdto> selectAll() throws Exception {
		List<productdto> list=new ArrayList<>();
	
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBManager.getConnection();
			String sql="SELECT * from PRODUCT";
			pstmt=con.prepareStatement(sql);
		
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				productdto dto=new productdto();
				dto.setPid(rs.getInt("pid"));
				dto.setPname(rs.getString("pname"));
				dto.setFirm(rs.getString("firm"));
				dto.setPrice(rs.getInt("price"));
				dto.setJego(rs.getInt("jego"));
				dto.setPdate(rs.getString("pdate"));
				list.add(dto);
			}
		} finally {
			DBManager.releaseConnection(pstmt,con); //★무조건 실행하게 해야함.
			
		}
		return list;
		
	}
}
