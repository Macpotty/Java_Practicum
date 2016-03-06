package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CtlSql;
import bean.PlanInfoBean;
import bean.Userbean;

/**
 * Servlet implementation class ModifyPlanServlet
 */
@WebServlet("/ModifyPlanServlet")
public class ModifyPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPlanServlet() {
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
		request.setCharacterEncoding("utf-8");
		String bookName = request.getParameter("bookName");
		String startTime = request.getParameter("startTime");
		String status = request.getParameter("status");
		String thoughts = request.getParameter("thoughts");
		HttpSession session = request.getSession(true);		//创建session对象
		PlanInfoBean plan = new PlanInfoBean();
		Userbean user = (Userbean)session.getAttribute("user");
		int userID = user.getUserID();
		String showInfo = "";
		String forward;
		
		try{
			CtlSql db = new CtlSql();
			String sql = "INSERT INTO plan(book_name,plan_time,status,user_id,thoughts) VALUES('"+bookName+"','"+startTime+"','"+status+"','"+userID+"','"+thoughts+"')";
			db.update(sql);
			showInfo = "添加成功！";
			forward = "MyPlan";
			plan.setShowInfo(showInfo);
			plan.setBookName(bookName);
			plan.setStartTime(startTime);
			plan.setStatus(status);
			plan.setUserID(userID);
			plan.setThoughts(thoughts);
			db.con().close();
		} catch(SQLException e) {
			showInfo = "添加失败:(";
			forward = "modifyPlan.jsp";
			user.setShowInfo(showInfo);
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
