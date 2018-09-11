package com.software.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.software.domain.Users;
import com.software.service.UsersService;
import com.software.utils.MD5Util;
import com.software.utils.MyTools;

public class UsersServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UsersService usersService = new UsersService();

	/**
	 * Constructor of the object.
	 */
	public UsersServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		if (action == null) {
			action = "";
		}
		if (action.equals("login_user")) {
			login_user(request, response);
		}
		if (action.equals("validate")) {
			validate(request, response);
		}
		if (action.equals("register")) {
			register(request, response);
		}

	}

	public void login_user(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String userName = request.getParameter("username").trim();
		String pwd = request.getParameter("password").trim();
		pwd = MD5Util.string2MD5(pwd);
		if (MyTools.string_check(userName, pwd)) {
			if (usersService.login(userName, pwd, "user")) {
				session.setAttribute("userName", userName);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			} else {
				response.sendRedirect(path + "/users/login.jsp");
				session.setAttribute("error", "yes");
			}
		} else {
			response.sendRedirect(path + "/users/login.jsp");
			session.setAttribute("error", "yes");
		}

	}

	protected void validate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username").trim();
		if (usersService.registerCheck(userName)) {
			out.write("用户名已存在");
		}
	}

	public void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String userName = request.getParameter("username").trim();
		String pwd = request.getParameter("password").trim();
		pwd = MD5Util.string2MD5(pwd);
		if (MyTools.string_check(userName, pwd)) {
			Users user = new Users();
			user.setUserId(userName);
			user.setPassword(pwd);
			user.setUserName(null);
			user.setPhone(null);
			user.setMail(null);
			user.setFlag("user");
			if (usersService.register(user)) {
				out.print("<script language='javascript'>alert('注册成功!');window.location.href='"
						+ request.getContextPath() + "/index.jsp';</script>");
			} else {
				response.sendRedirect(path + "/users/register.jsp");
				session.setAttribute("error", "yes");
			}
		} else {
			response.sendRedirect(path + "/users/register.jsp");
			session.setAttribute("error", "yes");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
