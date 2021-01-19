package com.imti.dao;
/**@�ļ���: MenuInfoDao.java
 * @�๦��˵��: �˵�����־ò�Dao�ӿ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��5������12:26:01
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��5������12:26:01</li> 
 *	 <li>����: </li>
 * </pre>
 */

import java.util.List;
import java.util.Map;

import com.imti.model.MenuInfo;

public interface MenuInfoDao {
	/**
	 * @������: findMenuInfoByParentId
	 * @����˵��: �˵�����־ò�Ŀ¼Dao�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��5������12:29:03
	 * @param parentId
	 * @return
	 * @return: JSONArray
	 */
	public List<MenuInfo> findMenuInfoByParentId(Map<String, Object> map);
	
/**
 * @������: getCurrentUserOwerMenus
 * @����˵��: �����û�ID��ѯ�û���ӵ�е�Ȩ��ID�־ò�Dao�ӿ�
 * @����: BaiYunZhong
 * @���䣺2537975653@qq.com
 * @����: 2021��1��12������9:43:56
 * @param user_id
 * @return: List<String>
 */
	public List<String> getCurrentUserOwerMenus(int user_id);
	
	
	/**
	 * @������: findAllMenuInfoByRoleId
	 * @����˵��: ͨ��role_id������г־ò�Dao�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������9:44:09
	 * @param map
	 * @return: List<MenuInfo>
	 */
    public List<MenuInfo> findAllMenuInfoByRoleId(Map<String,Object> map);
	/**
	 * @������: findRoleOwnerMenuByRoleId
	 * @����˵��: ���Գ־ò�Dao�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������10:00:41
	 * @param role_id
	 * @return: List<Integer>
	 */
	public List<Integer> findRoleOwnerMenuByRoleId(int role_id);
	
	/**
	 * @������: deleteRoleOldMenuByRoleId
	 * @����˵��: ɾ��Ȩ�޳־ò�Dao�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������10:00:48
	 * @param role_id
	 * @return: int
	 */
	public int deleteRoleOldMenuByRoleId(int role_id);
	/**
	 * @������: addRoleAndMenu
	 * @����˵��: ��Ȩ�־ò�Dao�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������10:01:04
	 * @param map
	 * @return: int
	 */
	public int addRoleAndMenu(Map<String,Object> map);
	/**
	 * @������: findAllMenuInfo
	 * @����˵��: �˵�������ʾ�־ò�Dao�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������9:24:58
	 * @param parentId
	 * @return: List<MenuInfo>
	 */
	public List<MenuInfo> findAllMenuInfo(int parentId);
	
	/**
	 * @������: addMenuInfo
	 * @����˵��: ���Ӳ˵���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������10:22:07
	 * @param menuInfo
	 * @return: int
	 */
	public int addMenuInfo(MenuInfo menuInfo);
	/**
	 * @������: updateMenuInfo
	 * @����˵��: �޸Ĳ˵���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������5:12:15
	 * @param menuInfo
	 * @return: int
	 */
	public int updateMenuInfo(MenuInfo menuInfo);
	/**
	 * @������: deleteMenuInfo
	 * @����˵��: ɾ���˵���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������8:51:34
	 * @param menu_id
	 * @return: int
	 */
	public int deleteMenuInfo(int menu_id);
}
