package com.software.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.software.domain.Users;
import com.software.utils.JDBCUtils;

public class UsersDao {
	
	private Connection conn = null;
	private PreparedStatement prestmt = null;
	private ResultSet rs = null;
	int rss;
	
	
	public boolean login(String userId,String password,String flag) {
		try {
			conn = JDBCUtils.getConn();
			String sql = "select * from users where binary userId=? and binary password=? and flag=?";
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, userId);
			prestmt.setString(2, password);
			prestmt.setString(3, flag);
			rs = prestmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, prestmt, conn);
		}
		return false;
	}
	
	
	public boolean register(Users user) {
		try {
			conn = JDBCUtils.getConn();
			String sql = "insert into users values(?,?,?,?,?,?)";
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1,user.getUserId());
			prestmt.setString(2,user.getPassword());
			prestmt.setString(3,user.getUserName());
			prestmt.setString(4,user.getPhone());
			prestmt.setString(5,user.getMail());
			prestmt.setString(6,user.getFlag());
			rss = prestmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, prestmt, conn);
		}
		return false;
	}
	
	public boolean registerCheck(String userId) {        
		try {
		
			conn = JDBCUtils.getConn();
			String sql="select * from users where binary userId=?";
			prestmt=conn.prepareStatement(sql);
			prestmt.setString(1,userId);
			rs=prestmt.executeQuery();
			if(rs.next()){
				return true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, prestmt, conn);
		}

		return false;
	}


}
