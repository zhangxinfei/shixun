package com.software.service;

import java.util.ArrayList;

import com.software.dao.MessageDao;
import com.software.domain.Message;

public class MessageService {
	MessageDao messageDao = new MessageDao();
	
	/**
	 * 根据用户的第一条留言id,查找属于该用户的留言及回复.
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<Message> listChats(int mesId) {
		return messageDao.listChats(mesId);
	}

	/**
	 * 查询所有用户的第一条留言
	 * @return
	 */
	public ArrayList<Message> listFirstMes(){
		return messageDao.firstMessage();
	}
	
	/**
	 * 确定parentNode，该用户的留言和回复记录的最后一条id即parentNode。
	 * 
	 * @param userId
	 * @return
	 */
	public int getParentNode(String userId) {
		int parentNode;
		int firstId = messageDao.firstMessageId(userId);
		if (firstId == 0) {
			return 0;
		}
		if (firstId != -1) {
			ArrayList<Message> arrayList = new ArrayList<Message>();
			arrayList = messageDao.listChats(firstId);
			if (arrayList != null) {
				parentNode = arrayList.get(arrayList.size() - 1).getMesId();
				return parentNode;
			}
		}
		return -1;
	}

	public boolean add(Message mes) {
		return messageDao.add(mes);
	}

	public void deleteMes(int mesId, int parentNode) {
		if (parentNode == 0) {
			if (messageDao.recordCount(mesId) == 1) {
				ArrayList<Message> arrayList = messageDao.listChats(mesId);
				if (arrayList != null) {
					for (int i = 0; i < arrayList.size(); i++) {
						messageDao.deleteMessage(arrayList.get(i).getMesId());
					}
				}
			} else {
				messageDao.deleteMessage(mesId);
				messageDao.updateMessage(mesId, parentNode);
			}
		} else {
			messageDao.deleteMessage(mesId);
			messageDao.updateMessage(mesId, parentNode);
		}
	}

}
