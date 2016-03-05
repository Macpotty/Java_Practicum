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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by michael on 16-3-5.
 */
@WebServlet(name = "ModifyPasswdServlet")
public class ModifyPasswdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String forward;
        String showInfo = "";
        HttpSession session = request.getSession(true);
        Userbean user = (Userbean)session.getAttribute("user");
        int userID = user.getUserID();
        ResultSet rs=null;
        CtlSql db=new CtlSql();
        boolean valid = false;
        String sql = "select * from user where password='"+oldPassword+"'";
        db.con();
        rs = db.qurey(sql);
        try {
            if(rs.next()) {
                valid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (valid) {
                sql = "UPDATE user SET password='" + newPassword + "' WHERE user_id='" + userID + "'";
                db.update(sql);
                user.setUserPassword(newPassword);
                showInfo = "密码修改成功！";
                forward = "index-after.jsp";
                user.setShowInfo(showInfo);
                user.setLoginState(true);
            } else {
                showInfo = "旧密码错误，请确认后重新修改。";
                forward = "modifyPasswd.jsp";
                user.setShowInfo(showInfo);
                user.setLoginState(false);

            }
        } catch(SQLException e) {
            showInfo = "密码修改失败！";
            forward = "modifyPasswd.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
