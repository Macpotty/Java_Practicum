package servlet;

import bean.CtlSql;
import bean.PlanInfoBean;

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
@WebServlet(name = "ModifyPlanItemServlet")
public class ModifyPlanItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bookName = request.getParameter("bookName");
        String planTime = request.getParameter("planTime");
        String thoughts = request.getParameter("thoughts");
        String status = request.getParameter("status");
        PlanInfoBean plan = new PlanInfoBean();
        int planID = Integer.parseInt(request.getParameter("ID"));
        String showInfo = "";
        String forward;

        try{
            CtlSql db = new CtlSql();
            String sql = "UPDATE plan SET book_name='"+bookName+"',plan_time='"+planTime+"',thoughts='"+thoughts+"',status='"+status+"' WHERE plan_id='"+planID+"'";
            db.update(sql);
            showInfo = "添加成功！";
            forward = "MyPlan";
            plan.setShowInfo(showInfo);
            plan.setBookName(bookName);
            plan.setStartTime(planTime);
            plan.setThoughts(thoughts);
            plan.setStatus(status);
            db.con().close();
        } catch(SQLException e) {
            showInfo = "添加失败:(";
            forward = "MyPlan";
            plan.setShowInfo(showInfo);
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
