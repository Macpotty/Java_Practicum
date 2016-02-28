package servlet;

import bean.CtlSql;
import bean.Userbean;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String userPasswd = request.getParameter("Password");
		String userEmail = request.getParameter("E-mail");
		Userbean user = new Userbean();
		request.setAttribute("Register", user);
		boolean isChar = true;
		for(int i = 0;i < userName.length();i++){
			char c = userName.charAt(i);
			if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')))
				isChar = false;
		}
		boolean legal = userName.length() > 0 && userPasswd.length() > 0 && isChar;
		String showInfo = "";
		String forward;
		
		try{
			CtlSql db = new CtlSql();
			if(legal){
				String sql = "INSERT INTO user(user_name,password,user_Email) VALUES('"+userName+"','"+userPasswd+"','"+userEmail+"')";
				db.update(sql);
				forward = "index.jsp";
				user.setUserName(userName);
				user.setUserPassword(userPasswd);
				user.setUserEmail(userEmail);
			}
			else{
				showInfo = "注册失败！";
				forward = "failed.jsp";
				user.setShowInfo(showInfo);
			}
			db.con().close();
		} catch(SQLException e) {
			showInfo = "此用户名已被使用，请更改。";
			forward = "failed";
			user.setShowInfo(showInfo);
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
