package bean;

import com.sun.rowset.CachedRowSetImpl;

public class ShowListBean {
	protected CachedRowSetImpl rowSet = null;
	protected int pageSize = 8;
	protected int pageAllCount = 0;
	protected int showPage = 1;
	protected StringBuffer presentPageResult;
	protected String databaseName = "booklist";
	protected String tableName = "";
	protected StringBuffer formTitle = null;
	
	public void setRowSet(CachedRowSetImpl set){
		rowSet = set;
	}
	public CachedRowSetImpl getRowSet(){
		return rowSet;
	}
	public void setPageSize(int size){
		pageSize = size;
	}
	public int getPageSize(){
		return pageSize;
	}
	public void setPageAllCount(int n){
		pageAllCount = n;
	}
	public int getPageAllCount(){
		return pageAllCount;
	}
	public void setShowPage(int n){
		showPage = n;
	}
	public int getShowPage(){
		return showPage;
	}
	public void setPresentPageResult(StringBuffer p){
		presentPageResult = p;
	}
	public StringBuffer getPresentPageResult(){
		return presentPageResult;
	}
	public void setDatabaseName(String name){
		databaseName = name;
	}
	public String getDatabaseName(){
		return databaseName;
	}
	public void setTableName(String name){
		tableName = name;
	}
	public String getTableName(){
		return tableName;
	}
	public void setFormTitle(StringBuffer title){
		formTitle = title;
	}
	public StringBuffer getFormTitle(){
		return formTitle;
	}
}
