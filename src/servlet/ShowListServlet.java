package servlet;

import bean.ShowListBean;
import bean.Userbean;
import bean.CtlSql;
import com.sun.rowset.CachedRowSetImpl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowListServlet
 */
@WebServlet("/ShowListServlet")
public class ShowListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int fieldCount;
	CachedRowSetImpl rowSet = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowListServlet() {
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
			String tableName = "list";
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
					listBean.setPageSize(8);
				}
			}
			listBean.setPageSize(8);;
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

					StringBuffer str = new StringBuffer();
					try {
						rowSet.absolute((showPage - 1) * pageSize + 1);
						for(int i = 1; i <= pageSize; i++) {
							str.append("<tr id=\"t"+i+"\">\n" +
									   "    <form action=\"DeleteListItem\" id=\"t"+i+"d\" onsubmit=\"get_lid('t"+i+"')\" class=\"form-inline\">\n" +
									   "        <input form=\"t"+i+"d\" id=\"t"+i+"i\" type=\"hidden\" name=\"ID\" value=\"\">\n" +
									   "    </form><td style=\"display:none;\">"+rowSet.getString(1)+"</td>");
							for(int j = 2; j <= fieldCount; j++){
								if(j == 5 || j == 6)continue;
								str.append("<td>"+rowSet.getString(j)+"</td>");
							}
							str.append("<td><a onclick=\"modify('t"+i+"')\">修改</a>\n" +
									   "    <input form=\"t"+i+"d\" type=\"submit\" value=\"删除\" class=\"btn btn-link\"></td></tr>");
							rowSet.next();
						}
					} catch(SQLException e) {
					}

					presentPageResult = str;
                }
                else {
                    presentPageResult = new StringBuffer("");
                }
                listBean.setPresentPageResult(presentPageResult);
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			String PageOperation = request.getParameter("PageOperation");
//			if(PageOperation == null || PageOperation.length() == 0){
//				showPage = 1;
//				listBean.setShowPage(showPage);
//				CachedRowSetImpl rowSet = listBean.getRowSet();
//				if(rowSet != null){
//					presentPageResult = show(showPage, pageSize, rowSet);
//					listBean.setPresentPageResult(presentPageResult);
//				}
//			}
//			else if(PageOperation.equals("下一页")) {
//				showPage++;
//				if(showPage > listBean.getPageAllCount())
//					showPage = listBean.getPageAllCount();
//				listBean.setShowPage(showPage);
//				CachedRowSetImpl rowSet = listBean.getRowSet();
//				if(rowSet != null){
//					presentPageResult = show(showPage, pageSize, rowSet);
//					listBean.setPresentPageResult(presentPageResult);
//				}
//			}
//			else if(PageOperation.equals("上一页")) {
//				showPage--;
//				if(showPage < listBean.getPageAllCount())
//					showPage = 1;
//				listBean.setShowPage(showPage);
//				CachedRowSetImpl rowSet = listBean.getRowSet();
//				if(rowSet != null){
//					presentPageResult = show(showPage, pageSize, rowSet);
//					listBean.setPresentPageResult(presentPageResult);
//				}
//			}
			forward = "list.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
//	public StringBuffer show(int page, int pageSize, CachedRowSetImpl rowSet) {
//		StringBuffer str = new StringBuffer();
//		try {
//			rowSet.absolute((page - 1) * pageSize + 1);
//			for(int i = 1; i <= pageSize; i++) {
//
//				str.append("<tr id=\"t"+i+"\">");
//				for(int j = 1; j <= fieldCount; j++){
//					if(j == 5 || j == 6)continue;
//					str.append("<td>"+rowSet.getString(j)+"</td>");
//				}
//				str.append("<td><a onclick=\"modify('t"+i+"')\">修改</a></td></tr>");
//				rowSet.next();
//			}
//		} catch(SQLException e) {
//		}
//		return str;
//	}


}
