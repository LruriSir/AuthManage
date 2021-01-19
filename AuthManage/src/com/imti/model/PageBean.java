package com.imti.model;
/**@文件名: PageBean.java
 * @类功能说明: 
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月6日下午12:46:27
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月6日下午12:46:27</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class PageBean {

	private int page; //第几页
	private int rows;//每页条数
	@SuppressWarnings("unused")
	private int start;//起始页
	
	public PageBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStart() {
		return (page-1)*rows;
	}

	
	
	
}
