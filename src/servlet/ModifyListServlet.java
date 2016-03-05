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
import bean.ListInfoBean;
import bean.Userbean;

/**
 * Servlet implementation class ModifyListServlet
 */
@WebServlet("/ModifyListServlet")
public class ModifyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyListServlet() {
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
		String bookAuthor = request.getParameter("bookAuthor");
		String bookClass = request.getParameter("bookClass");
		String status = request.getParameter("status");
		HttpSession session = request.getSession(true);		//创建session对象
		ListInfoBean list = new ListInfoBean();
		Userbean user = (Userbean)session.getAttribute("user");
		int userID = user.getUserID();
		String showInfo = "";
		String forward;
		
		try{
			CtlSql db = new CtlSql();
			String sql = "INSERT INTO list(book_name,book_author,book_class,status,user_id) VALUES('"+bookName+"','"+bookAuthor+"','"+bookClass+"','"+status+"','"+userID+"')";
			db.update(sql);
			showInfo = "添加成功！";
			forward = "MyList";
			list.setShowInfo(showInfo);
			list.setBookName(bookName);
			list.setBookAuthor(bookAuthor);
			list.setBookType(bookClass);
			list.setStatus(status);
			list.setUserID(userID);
			db.con().close();
		} catch(SQLException e) {
			showInfo = "添加失败:(";
			forward = "modifyList.jsp";
			list.setShowInfo(showInfo);
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
