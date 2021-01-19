package com.imti.dao;
/**@�ļ���: RoleInfoDao.java
 * @�๦��˵��:  ��ɫ��Ȩ�־ò�ӿ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��7������6:58:18
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��7������6:58:18</li> 
 *	 <li>����: </li>
 * </pre>
 */

import java.util.List;
import java.util.Map;

import com.imti.model.RoleInfo;



public interface RoleInfoDao {
	/**
	 * @������: findAllRoleInfoToUser
	 * @����˵��: ��ѯ���н�ɫ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������7:01:19
	 * @param map
	 * @return: List<RoleInfo>
	 */
	public List<RoleInfo> findAllRoleInfoToUser();
	
	/**
	 * @������: findUserOwerRolesByUid
	 * @����˵��: ͨ���û�id�����û���Ȩ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��8������2:39:32
	 * @param user_id
	 * @return: List<Integer>
	 */
	public List<Integer> findUserOwerRolesByUid(int user_id);
	/**
	 * @������: findAllRoleInfoCount
	 * @����˵��: ��ѯ���н�ɫ��Ϣ��ҳ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������7:01:59
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount(Map<String, Object> map);
	
	
	
	
//-------------------------------------------------��ɫ�б�---------------------------------------------
	/**
	 * @������: findAllRoleInfo
	 * @����˵��: ��ѯ����
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��9������10:38:25
	 * @param map
	 * @return
	 * @return: List<UserInfo>
	 */
	public List<RoleInfo> findAllRoleInfo(Map<String, Object> map);
	
	/**
	 * @������: findAllRoleInfoCount
	 * @����˵��: ��ѯ�����ҳ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��10������10:58:38
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount1(Map<String, Object> map);
	
	/**
	 * @������: findRoleNameIsExist
	 * @����˵��: ������ɫ��Ϣʱ�ж��û��Ƿ����
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��10������11:20:22
	 * @param userName
	 * @return: int
	 */
	public int findRoleNameIsExist(String roleName);
	
	/**
	 * @������: addRoleInfo
	 * @����˵��: ������ɫ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��10������7:01:59
	 * @param userInfo
	 * @return: int
	 */
	public int addRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @������: updateRoleInfo
	 * @����˵��: �޸Ľ�ɫ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��11������10:26:27
	 * @param roleInfo
	 * @return: int
	 */
	public int updateRoleInfo(RoleInfo roleInfo);
	/**
	 * @������: deleteRoleInfo
	 * @����˵��: ɾ����ɫ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��11������10:26:44
	 * @param role_id
	 * @return: int
	 */
	public int deleteRoleInfo(int role_id);
}
