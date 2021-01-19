package com.imti.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.imti.model.MenuInfo;

/**@�ļ���: MenuInfoService.java
 * @�๦��˵��: �˵�����Service�ӿ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��5������12:37:34
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��5������12:37:34</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface MenuInfoService {
	/**
	 * @������: findMenuInfoByParentId
	 * @����˵��: �˵�����Service�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��5������12:48:57
	 * @param parentId
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray findMenuInfoByParentId(int parentId,List<String> menuIds);
	
	/**
	 * @������: getCurrentUserOwerMenus
	 * @����˵��: �����û�ID��ѯ�û���ӵ�е�Ȩ��ID
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������9:45:39
	 * @param user_id
	 * @return: List<String>
	 */
	public List<String> getCurrentUserOwerMenus(int user_id);
	/**
	 * @������: findAllMenuInfoByRoleId
	 * @����˵��: ��ѯȫ���˵�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������9:46:47
	 * @param parentId
	 * @param role_id
	 * @return: JSONArray
	 */
    public JSONArray findAllMenuInfoByRoleId(int parentId,int role_id);
	
    /**
     * @������: saveRoleAndMenu
     * @����˵��: ����
     * @����: BaiYunZhong
     * @���䣺2537975653@qq.com
     * @����: 2021��1��12������9:47:27
     * @param role_id
     * @param menuIds
     * @return: int
     */
	public int saveRoleAndMenu(int role_id,String menuIds); 
	
	/**
	 * @������: findAllMenuInfo
	 * @����˵��: �˵�������ʾService�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������9:30:37
	 * @param parentId
	 * @return: List<MenuInfo>
	 */
	public  JSONArray findAllMenuInfo(int parentId);
	/**
	 * @������: addMenuInfo
	 * @����˵��: ��Ӳ˵���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������10:22:46
	 * @param menuInfo
	 * @return: int
	 */
	public int addMenuInfo(MenuInfo menuInfo);
	/**
	 * @������: updateMenuInfo
	 * @����˵��: �޸Ĳ˵���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������5:11:29
	 * @param menuInfo
	 * @return: int
	 */
	public int updateMenuInfo(MenuInfo menuInfo);
	/**
	 * @������: deleteMenuInfo
	 * @����˵��: ɾ���˵���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������8:48:27
	 * @param menuId
	 * @return: int
	 */
	public int deleteMenuInfo(String menuId);
}
