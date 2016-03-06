package servlet;

import bean.CtlSql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by michael on 16-3-6.
 */
@WebServlet(name = "DeleteListItemServlet")
public class DeleteListItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookID = Integer.parseInt(request.getParameter("ID"));
        String forward;
        try{
            CtlSql db = new CtlSql();
            String sql = "DELETE FROM `booklist`.`list` WHERE `book_id`='"+bookID+"'";
            db.update(sql);
            forward = "MyList";
            db.con().close();
        } catch(SQLException e) {
            forward = "MyList";
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
