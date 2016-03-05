package servlet;

import bean.CtlSql;
import bean.Userbean;

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
 * Created by michael on 16-3-5.
 */
@WebServlet(name = "ModifyAccountServlet")
public class ModifyAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ModifyAccountServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userEmail = request.getParameter("E-mail");
        String realName = request.getParameter("realName");
        String forward;
        String showInfo = "";
        HttpSession session = request.getSession(true);
        Userbean user = (Userbean)session.getAttribute("user");
        int userID = user.getUserID();

        try {
            CtlSql db = new CtlSql();
            String sql = "UPDATE user SET user_Email='"+userEmail+"',real_name='"+realName+"' WHERE user_id='"+userID+"'";
            db.update(sql);
            showInfo = "修改成功！";
            forward = "index-after.jsp";
            user.setShowInfo(showInfo);
            user.setRealName(realName);
            user.setUserEmail(userEmail);
            db.con().close();
        } catch (SQLException e) {
            showInfo = "修改失败:(";
            forward = "modifyAccount.jsp";
            user.setShowInfo(showInfo);
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
