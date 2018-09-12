package com.software.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	static Properties prop = null;

	private static ComboPooledDataSource source = null;
	static {
		source = new ComboPooledDataSource();
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConn() throws Exception {
		Connection conn = source.getConnection();
		return conn;
	}

	/**
	 * 关闭数据库资源
	 * 
	 * @param rs
	 * @param stm
	 * @param con
	 */
	public static void close(ResultSet rs, Statement stm, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stm = null;
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

}
