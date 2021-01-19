package com.imti.model;
/**@文件名: MenuInfo.java
 * @类功能说明:菜单管理实体 
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月5日上午11:57:28
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月5日上午11:57:28</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class MenuInfo {
	private Integer menu_id;                //菜单主键
	private int parentId;                   //父节点
	private String menu_name;               //菜单名字
	private String menu_state;              //菜单是否有子节点，默认closed是有子节点，open表示没有子节点
	private String menu_url;                //菜单路径
	private String menu_icon;               //菜单图片路径
	private int state;                      //菜单状态，0表示用户已启用，1表示用户禁用
	private int menu_delflag;               //删除标记，0表示用户未删除，1表示用户已删除
	private int opt_id;                     //操作人
	private String createTime;              //创建时间
	private String menu_remark;             //备注
	
	
	
	public MenuInfo() {}
	
	
	public MenuInfo(Integer menu_id, String menu_name, String menu_url, String menu_icon, String menu_remark) {
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_url = menu_url;
		this.menu_icon = menu_icon;
		this.menu_remark = menu_remark;
	}
	
	


	public MenuInfo(Integer menu_id, int parentId, String menu_name, String menu_state, String menu_url,
			String menu_icon, int state, int menu_delflag, int opt_id, String createTime, String menu_remark) {
		this.menu_id = menu_id;
		this.parentId = parentId;
		this.menu_name = menu_name;
		this.menu_state = menu_state;
		this.menu_url = menu_url;
		this.menu_icon = menu_icon;
		this.state = state;
		this.menu_delflag = menu_delflag;
		this.opt_id = opt_id;
		this.createTime = createTime;
		this.menu_remark = menu_remark;
	}


	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_state() {
		return menu_state;
	}
	public void setMenu_state(String menu_state) {
		this.menu_state = menu_state;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public String getMenu_icon() {
		return menu_icon;
	}
	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getMenu_delflag() {
		return menu_delflag;
	}
	public void setMenu_delflag(int menu_delflag) {
		this.menu_delflag = menu_delflag;
	}
	public int getOpt_id() {
		return opt_id;
	}
	public void setOpt_id(int opt_id) {
		this.opt_id = opt_id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMenu_remark() {
		return menu_remark;
	}
	public void setMenu_remark(String menu_remark) {
		this.menu_remark = menu_remark;
	}
}
