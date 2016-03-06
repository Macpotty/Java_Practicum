package servlet;

import bean.CtlSql;
import bean.ShowListBean;
import bean.Userbean;
import com.sun.rowset.CachedRowSetImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/**
 * Created by michael on 16-3-4.
 */
public class ShowPlanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    int fieldCount;
    CachedRowSetImpl rowSet = null;

    public ShowPlanServlet() {
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StringBuffer presentPageResult = new StringBuffer();	//建立当前页字符串
        ShowListBean listBean = null;		//创建显示bean
        String showInfo;
        String forward;
        HttpSession session = request.getSession(true);		//创建session对象
        Userbean user = (Userbean)session.getAttribute("user");
        if(user == null){
            user = new Userbean();
            session.setAttribute("user", user);
            showInfo = "您还未登录，请先登录:)";
            user.setShowInfo(showInfo);
            forward = "login.jsp";
        }
        else {
            int userID = user.getUserID();
            String tableName = "plan";
            CtlSql db = new CtlSql();		//创建工具类实例
            Connection con;		//创建连接对象
            try {		//此块用于初始化生命周期为session的bean对象
                listBean = (ShowListBean)session.getAttribute(tableName);
                if(listBean == null) {
                    listBean = new ShowListBean();
                    session.setAttribute(tableName, listBean);
                }
            } catch(Exception e) {
                listBean = new ShowListBean();
                session.setAttribute(tableName, listBean);
            }
            String pageSizeGet = request.getParameter("pageSize");
            if (pageSizeGet != null) {
                try {
                    int size = Integer.parseInt(pageSizeGet);
                    listBean.setPageSize(size);
                } catch(NumberFormatException e) {
                    listBean.setPageSize(5);
                }
            }
            listBean.setPageSize(5);
            int showPage;
            if(request.getParameter("showPage") == null){
                showPage = 1;
            }
            else {
                showPage = Integer.parseInt(request.getParameter("showPage"));
                System.out.println(showPage);
                if(showPage > listBean.getPageAllCount()) {
                    showPage = listBean.getPageAllCount();
                }
                if(showPage <= 0) {
                    showPage = 1;
                }
            }
            listBean.setShowPage(showPage);
            int pageSize = listBean.getPageSize();
            boolean isLegal = tableName != null && tableName.length() > 0;
            if(isLegal) {
                listBean.setTableName(tableName);
            }
            try {
                con = db.con();
                fieldCount = 0;
                DatabaseMetaData metadata = con.getMetaData();
                ResultSet rs1 = metadata.getColumns(null, null, tableName, null);
                while(rs1.next())
                    fieldCount++;
                Statement sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

                ResultSet rs = sql.executeQuery("SELECT * FROM "+tableName+" WHERE user_id='"+userID+"'");
                if(rs.next()){
                    rs = sql.executeQuery("SELECT * FROM "+tableName+" WHERE user_id='"+userID+"'");
                    rowSet = new CachedRowSetImpl();
                    rowSet.populate(rs);
                    con.close();
                    listBean.setRowSet(rowSet);
                    rowSet.last();
                    int row = rowSet.getRow();
                    int pageAllCount = ((row % pageSize) == 0) ? (row / pageSize) : (row / pageSize + 1);
                    listBean.setPageAllCount(pageAllCount);
                    presentPageResult = show(showPage, pageSize, rowSet);
                }
                else {
                    presentPageResult = new StringBuffer("");
                }
                listBean.setPresentPageResult(presentPageResult);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            forward = "plan.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    public StringBuffer show(int page, int pageSize, CachedRowSetImpl rowSet) {
        StringBuffer str = new StringBuffer();
        try {
            rowSet.absolute((page - 1) * pageSize + 1);
            for(int i = 1; i <= pageSize; i++) {
                str.append("\n" +
                        "                    <div class=\"panel-group\" id=\"panel-1\">\n" +
                        "                        <form action=\"DeletePlanItem\" id=\"p"+i+"d\" onsubmit=\"get_pid('p"+i+"')\" class=\"form-inline\">\n" +
                        "                            <input form=\"p"+i+"d\" id=\"p"+i+"i\" type=\"hidden\" name=\"ID\" value=\"\">\n" +
                        "                        </form>\n" +
                        "                        <div class=\"panel panel-default\" id=\"p"+i+"\">\n" +
                        "                            <div class=\"panel-heading\">\n" +
                        "                                <a class=\"panel-title\" data-toggle=\"collapse\" data-parent=\"#panel-1\" href=\"#panel-element-"+i+"\">"+rowSet.getString(2)+"</a>\n" +
                        "                                <a class=\"btn-right\" onclick=\"modifyplan('p"+i+"')\">修改</a>\n" +
                        "                                <input form=\"p"+i+"d\" type=\"submit\" value=\"删除\" class=\"btn btn-link\"></td></tr>\n" +
                        "                            </div>\n" +
                        "                            <div id=\"panel-element-"+i+"\" class=\"panel-collapse collapse in\">\n" +
                        "                                <div class=\"panel-body\">\n" +
                        "                                    <dl class=\"dl-horizontal\">");
                str.append("                                     <dt>"+"书名"+"</dt>");
                str.append("                                     <dd>"+rowSet.getString(3)+"</dd>");
                str.append("                                     <dt>"+"进度"+"</dt>");
                str.append("                                     <dd>"+rowSet.getString(4)+"</dd>");
                str.append("                                     <dt>"+"感想"+"</dt>");
                str.append("                                     <dd>"+rowSet.getString(6)+"</dd>");
                str.append("                                     <dt style=\"display:none;\">ID</dt><dd style=\"display:none;\">"+rowSet.getString(1)+"</dd>\n" +
                        "                                    </dl>\n" +
                        "                                </div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </div>");
                rowSet.next();
            }
        } catch(SQLException e) {
        }
        return str;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
