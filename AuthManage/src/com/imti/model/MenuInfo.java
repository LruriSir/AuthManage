package com.imti.model;
/**@�ļ���: MenuInfo.java
 * @�๦��˵��:�˵�����ʵ�� 
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��5������11:57:28
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��5������11:57:28</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class MenuInfo {
	private Integer menu_id;                //�˵�����
	private int parentId;                   //���ڵ�
	private String menu_name;               //�˵�����
	private String menu_state;              //�˵��Ƿ����ӽڵ㣬Ĭ��closed�����ӽڵ㣬open��ʾû���ӽڵ�
	private String menu_url;                //�˵�·��
	private String menu_icon;               //�˵�ͼƬ·��
	private int state;                      //�˵�״̬��0��ʾ�û������ã�1��ʾ�û�����
	private int menu_delflag;               //ɾ����ǣ�0��ʾ�û�δɾ����1��ʾ�û���ɾ��
	private int opt_id;                     //������
	private String createTime;              //����ʱ��
	private String menu_remark;             //��ע
	
	
	
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
