package servlet;

import bean.Userbean;
import bean.CheckUser;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("Password");
		String showInfo = "";
		String forward;
		Userbean user = null;
		HttpSession session = request.getSession(true);
		try {
			user = (Userbean)session.getAttribute("user");
			if(user == null) {
				user = new Userbean();
				session.setAttribute("user", user);
			}
		} catch(Exception e) {
			user = new Userbean();
			session.setAttribute("user", user);
		}
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		CheckUser chk = new CheckUser();
		boolean valid = chk.checkUser(user);
		if(valid) {
			showInfo = "登录成功！";
			forward = "main.jsp";
			user.setShowInfo(showInfo);
			user.setLoginState(true);
		}
		else {
			showInfo = "用户名或密码错误，请确认后重新登录。";
			forward = "login.jsp";
			user.setShowInfo(showInfo);
			user.setLoginState(false);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
