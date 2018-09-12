package com.software.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.software.domain.Message;
import com.software.utils.JDBCUtils;

public class MessageDao {
	private Connection conn = null;
	private PreparedStatement prestmt = null;
	private ResultSet rs = null;
	int rss;
	/**
	 * 查询所有用户的第一条留言
	 * @param userId
	 * @return
	 */
	public ArrayList<Message> firstMessage() {
		try {
			conn = JDBCUtils.getConn();
			String sql = "select * from message where parentNode=0";
			prestmt = conn.prepareStatement(sql);
			rs = prestmt.executeQuery();
			ArrayList<Message> arrayList = new ArrayList<Message>();
			while (rs.next()) {
				Message mes = new Message();
				mes.setMesId(rs.getInt("mesId"));
				mes.setHandlers(rs.getString("handlers"));
				mes.setParentNode(rs.getInt("parentNode"));
				mes.setTime(rs.getTimestamp("time"));
				mes.setContents(rs.getString("contents"));
				mes.setFlag(rs.getString("flag"));
				arrayList.add(mes);
			}
			return arrayList;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, prestmt, conn);
		}
		return null;
	}

	
	/**
	 * 查询所有留言用户
	 * @return
	 */
	public ArrayList<String> listHandlers() {
		try {
			conn = JDBCUtils.getConn();
			String sql = "select distinct handlers from message,users where flag='user' and message.handlers=users.userId";
			prestmt = conn.prepareStatement(sql);
			rs = prestmt.executeQuery();
			ArrayList<String> arrayList = new ArrayList<String>();
			while (rs.next()) {
				arrayList.add(rs.getString("handlers"));
			}
			return arrayList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, prestmt, conn);
		}
		return null;
	}
	
	
	/**
	 * 查找用户的第一条留言id.
	 * 
	 * @param userId
	 * @return
	 */
	public int firstMessageId(String userId) {
		try {
			conn = JDBCUtils.getConn();
			String sql = "select mesId from message where handlers=? and parentNode=0";
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, userId);
			rs = prestmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("mesId");
			} else {
				return 0; // 该用户无留言记录。
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, prestmt, conn);
		}
		return -1;
	}

	/**
	 * 根据用户的第一条留言id,查找属于该用户的留言及回复.
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<Message> listChats(int mesId) {
		try {
			conn = JDBCUtils.getConn();
			String sql = "select mesId,handlers,parentNode,time,contents,flag from message,users where FIND_IN_SET(mesId, getChildList(?)) and message.handlers=users.userId";
			prestmt = conn.prepareStatement(sql);
			prestmt.setInt(1, mesId);
			rs = prestmt.executeQuery();
			ArrayList<Message> arrayList = new ArrayList<Message>();
			while (rs.next()) {
				Message mes = new Message();
				mes.setMesId(rs.getInt("mesId"));
				mes.setHandlers(rs.getString("handlers"));
				mes.setParentNode(rs.getInt("parentNode"));
				mes.setTime(rs.getTimestamp("time"));
				mes.setContents(rs.getString("contents"));
				mes.setFlag(rs.getString("flag"));
				arrayList.add(mes);
			}
			return arrayList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, prestmt, conn);
		}
		return null;
	}

	/**
	 * 添加一条留言记录
	 * 
	 * @param mes
	 * @return
	 */
	public boolean add(Message mes) {
		try {
			conn = JDBCUtils.getConn();
			String sql = "insert into message(handlers,parentNode,time,contents) values(?,?,?,?)";
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, mes.getHandlers());
			prestmt.setInt(2, mes.getParentNode());
			prestmt.setTimestamp(3, mes.getTime());
			prestmt.setString(4, mes.getContents());
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

	/**
	 * 
	 * @param mesId
	 *            被删除记录的mesId，该mesId为下一记录的parentNode。
	 * @param parentNode
	 *            被删除记录的parentNode，该parentNode为下一记录新的parentNode。
	 * @return
	 */
	public boolean updateMessage(int mesId, int parentNode) {
		try {
			conn = JDBCUtils.getConn();
			String sql = "update message set parentNode=? where parentNode=?";
			prestmt = conn.prepareStatement(sql);
			prestmt.setInt(1, parentNode);
			prestmt.setInt(2, mesId);
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

	/**
	 * 根据mesId删除一条留言记录
	 * 
	 * @param mesId
	 * @return
	 */
	public boolean deleteMessage(int mesId) {
		try {
			conn = JDBCUtils.getConn();
			String sql = "delete from message where mesId=?";
			prestmt = conn.prepareStatement(sql);
			prestmt.setInt(1, mesId);
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

	/**
	 * 查询用户有几条留言记录
	 * 
	 * @param mesId
	 * @return
	 */
	public int recordCount(int mesId) {
		try {
			conn = JDBCUtils.getConn();
			String sql = "select mesId,handlers,parentNode,time,contents,flag from message,users where FIND_IN_SET(mesId, getChildList(?)) and users.flag='user' and message.handlers=users.userId";
			prestmt = conn.prepareStatement(sql);
			prestmt.setInt(1, mesId);
			rs = prestmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				i++;
			}
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, prestmt, conn);
		}
		return -1;
	}
}
