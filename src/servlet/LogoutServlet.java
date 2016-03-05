package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import bean.Userbean;

/**
 * Created by michael on 16-3-5.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(true);
        String forward;
        String showInfo;
        Userbean user = (Userbean)session.getAttribute("user");
        boolean loginFlag = true;
        if(user == null) {
            showInfo = "您还未登录";
            loginFlag = false;
            forward = "login.jsp";
            user.setShowInfo(showInfo);
            user.setLoginState(false);
        }
        else {
            session.invalidate();
            forward = "index-before.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
