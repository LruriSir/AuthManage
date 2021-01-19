package com.imti.service;

import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSONArray;
import com.imti.model.RoleInfo;

/**@�ļ���: RoleInfoService.java
 * @�๦��˵��: ��ɫ�����Service�ӿ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��7������7:15:12
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��7������7:15:12</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface RoleInfoService {
	/**
	 * @������: findAllRoleInfoToUser
	 * @����˵��: ��ѯ���н�ɫ��ϢService�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������7:16:06
	 * @param user_id
	 * @return: JSONArray
	 */
	public JSONArray findAllRoleInfoToUser(int user_id);
	
	/**
	 * @������: findUserOwerRolesByUid
	 * @����˵��: ͨ���û�id�����û���Ȩ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��8������3:23:49
	 * @param user_id
	 * @return: List<Integer>
	 */
	//public List<Integer> findUserOwerRolesByUid(int user_id);
	/**
	 * @������: findAllRoleInfoCount
	 * @����˵��: ��ѯ���н�ɫ��Ϣ��ҳService�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������7:16:13
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount(Map<String, Object> map);
	
	//public int deleteUserOwerRoleByUid(String roleIds);
	/*--------------------------------------------------------------------------------------*/
	/**
	 * @������: findAllRoleInfo
	 * @����˵��: ��ѯ���н�ɫ��ϢService�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��9������10:50:17
	 * @param map
	 * @return
	 * @return: List<UserInfo>
	 */
	public List<RoleInfo> findAllRoleInfo(Map<String, Object> map);
	/**
	 * @������: findRoleNameIsExist
	 * @����˵��: ������ɫ��Ϣʱ�ж��û��Ƿ����
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��10������6:12:29
	 * @param userName
	 * @return: int
	 */
	public int findRoleNameIsExist(String roleName);
	/**
	 * @������: addRoleInfo
	 * @����˵��: ������ɫ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��10������6:22:25
	 * @param userInfo
	 * @return: int
	 */
	public int addRoleInfo(RoleInfo roleInfo);
	/**
	 * @������: updateRoleInfo
	 * @����˵��: �޸Ľ�ɫ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��11������10:24:47
	 * @param roleInfo
	 * @return: int
	 */
	public int updateRoleInfo(RoleInfo roleInfo);
	/**
	 * @������: deleteRoleInfo
	 * @����˵��: ɾ����ɫ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��11������10:25:04
	 * @param roleIds
	 * @return: int
	 */
	public int deleteRoleInfo(String roleIds);
}
