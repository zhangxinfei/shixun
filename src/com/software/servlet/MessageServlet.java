package com.software.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.software.domain.Message;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.software.service.MessageService;
import com.software.utils.MD5Util;
import com.software.utils.MyTools;

public class MessageServlet extends HttpServlet {

	MessageService messageService = new MessageService();
	/**
	 * Constructor of the object.
	 */
	public MessageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		if (action == null) {
			action = "";
		}
		if (action.equals("firstMes")) {
			firstMes(request, response);
		}
	}
	

	/**
	 * 显示所有用户的第一条留言
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void firstMes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		ArrayList<Message> firstMesRecord=messageService.listFirstMes();
		session.setAttribute("firstMesRecord", firstMesRecord);
		response.sendRedirect(path + "/users/login.jsp");
	}
	
	
	public void chatDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		ArrayList<Message> firstMesRecord=messageService.listFirstMes();
		session.setAttribute("firstMesRecord", firstMesRecord);
		response.sendRedirect(path + "/users/login.jsp");
			
		
	}

	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
