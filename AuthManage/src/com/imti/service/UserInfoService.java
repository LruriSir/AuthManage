package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@�ļ���: UserInfoService.java
 * @�๦��˵��: �û������Service�ӿ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��4������4:04:03
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��4������4:04:03</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface UserInfoService {
	/**
	 * @������: login
	 * @����˵��: �û�������¼�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��4������4:09:01
	 * @param UserInfo
	 * @return: UserInfo
	 */
	public UserInfo login(UserInfo userInfo);
	/**
	 * @������: findAllUserInfo
	 * @����˵��: �û���ѯ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��6������10:52:15
	 * @return: List<UserInfo>
	 */
	public List<UserInfo> findAllUserInfo(Map<String, Object> map);
	/**
	 * @������: findAllUserInfoCount
	 * @����˵��: ��ѯ�����ҳ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��6������12:59:55
	 * @param map
	 * @return: int
	 */
	public int findAllUserInfoCount(Map<String, Object> map);
	
	/**
	 * @������: findUserNameIsExist
	 * @����˵��: �����û���Ϣʱ�ж��û��Ƿ����
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��6������6:52:37
	 * @param user_name
	 * @return: int
	 */
	public int findUserNameIsExist(String userName);
	/**
	 * @������: addUserInfo
	 * @����˵��: �����û���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��6������7:31:24
	 * @param userInfo
	 * @return: int
	 */
	public int addUserInfo(UserInfo userInfo);
	
	
	/**
	 * @������: findPasswordByUserId
	 * @����˵��: �޸�ʱ�ҵ��û�����
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������12:44:39
	 * @param user_id
	 * @return: String
	 */
	//public String findPasswordByUserId(int user_id);
	
	/**
	 * @������: updateUserInfo
	 * @����˵��: �޸��û���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������12:00:01
	 * @param userInfo
	 * @return: int
	 */
	public int updateUserInfo(UserInfo userInfo);
	/**
	 * @������: deleteUserInfo
	 * @����˵��: ɾ���û���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������1:04:36
	 * @param user_id
	 * @return: int
	 */
	public int deleteUserInfo(String userIds);
	
	
	/**
	 * @������: insertUserAndRole
	 * @����˵��: �ɽ�ɫ��Ȩ���û�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������10:28:56
	 * @param userId
	 * @param roleIds
	 * @return: int
	 */
	public int insertUserAndRole(int userId,String roleIds);
	
	/**
	 * @������: deleteUserOwerRoleByUid
	 * @����˵��: ����Ȩ��
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������12:07:05
	 * @param userId
	 * @param roleIds
	 * @return: int
	 */
	public int deleteUserOwerRoleByUid(int userId,String roleIds);
	
}
