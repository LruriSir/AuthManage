package com.imti.model;
/**@文件名: UserInfo.java
 * @类功能说明: 用户实体
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月4日下午1:26:26
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月4日下午1:26:26</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class UserInfo {
	private Integer user_id;        //用户主键
	private String user_code;       //用户编码
	private String user_name;       //用户姓名
	private String user_nickName;   //用户昵称
	private String user_pwd;        //用户密码
	private int user_state;         //用户状态，0表示用户已启用，1表示用户禁用
	private int user_deflag;        //删除标记，0表示用户未删除，1表示用户已删除
	private int opt_id;             //操作人
	private String createTime;      //创建时间
	private String user_remark;     //备注
	
	public UserInfo() {}

	/**
	 * 登录操作（俩个参数）
	 * @param user_name
	 * @param user_pwd
	 */
	public UserInfo(String user_name, String user_pwd) {
		this.user_name = user_name;
		this.user_pwd = user_pwd;
	}
	/**
	 * CRUD的增加用户信息操作
	 * @param user_name
	 * @param user_nickName
	 * @param user_pwd
	 * @param user_remark
	 */
	public UserInfo(String user_name, String user_nickName, String user_pwd, String user_remark) {
		this.user_name = user_name;
		this.user_nickName = user_nickName;
		this.user_pwd = user_pwd;
		this.user_remark = user_remark;
	}

	/**
	 * CRUD的修改或删除用户信息操作
	 * @param user_id
	 * @param user_name
	 * @param user_nickName
	 * @param user_pwd
	 * @param user_remark
	 */
	public UserInfo(Integer user_id, String user_name, String user_nickName, String user_pwd, String user_remark) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_nickName = user_nickName;
		this.user_pwd = user_pwd;
		this.user_remark = user_remark;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nickName() {
		return user_nickName;
	}

	public void setUser_nickName(String user_nickName) {
		this.user_nickName = user_nickName;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public int getUser_state() {
		return user_state;
	}

	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}

	public int getUser_deflag() {
		return user_deflag;
	}

	public void setUser_deflag(int user_deflag) {
		this.user_deflag = user_deflag;
	}

	public int getOpt_id() {
		return opt_id;
	}

	public void setOpt_id(int opt_id) {
		this.opt_id = opt_id;
	}

	public String getCreatTime() {
		return createTime;
	}

	public void setCreatTime(String creatTime) {
		this.createTime = creatTime;
	}

	public String getUser_remark() {
		return user_remark;
	}

	public void setUser_remark(String user_remark) {
		this.user_remark = user_remark;
	}
}
