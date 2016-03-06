package servlet;

import bean.CtlSql;
import bean.ListInfoBean;
import bean.ShowListBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by michael on 16-3-6.
 */
@WebServlet(name = "ModifyListItemServlet")
public class ModifyListItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookClass = request.getParameter("bookClass");
        String status = request.getParameter("status");
        ListInfoBean list = new ListInfoBean();
        int bookID = Integer.parseInt(request.getParameter("ID"));
        String showInfo = "";
        String forward;

        try{
            CtlSql db = new CtlSql();
            String sql = "UPDATE list SET book_name='"+bookName+"',book_author='"+bookAuthor+"',book_class='"+bookClass+"',status='"+status+"' WHERE book_id='"+bookID+"'";
            db.update(sql);
            showInfo = "添加成功！";
            forward = "MyList";
            list.setShowInfo(showInfo);
            list.setBookName(bookName);
            list.setBookAuthor(bookAuthor);
            list.setBookType(bookClass);
            list.setStatus(status);
            db.con().close();
        } catch(SQLException e) {
            showInfo = "添加失败:(";
            forward = "MyList";
            list.setShowInfo(showInfo);
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
