package com.imti.dao;
/**@�ļ���: UserInfoDao.java
 * @�๦��˵��: �û��־ò�Dao�ӿ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��4������3:45:40
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��4������3:45:40</li> 
 *	 <li>����: </li>
 * </pre>
 */

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

public interface UserInfoDao {
	/**
	 * @������: login
	 * @����˵��: �û��־ò��¼�ӿ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��4������4:07:32
	 * @param UserInfo
	 * @return: UserInfo
	 */
	public UserInfo login(UserInfo userInfo);
	/**
	 * @������: getCurrentUserOwerMenus
	 * @����˵��: �û���¼��ʾ�˵�Ȩ��
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��6������10:49:25
	 * @param user_id
	 * @return
	 * @return: List<String>
	 */
	public List<String> getCurrentUserOwerMenus(int user_id);
	
	/**
	 * @������: findAllUserInfo
	 * @����˵��: �û���ѯ����
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��6������10:48:48
	 * @param map
	 * @return: List<UserInfo>
	 */
	public List<UserInfo> findAllUserInfo(Map<String, Object> map);
	
	/**
	 * @������: findAllUserInfoCount
	 * @����˵��: ��ѯ�����ҳ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��6������1:13:11
	 * @param map
	 * @return: int
	 */
	public int findAllUserInfoCount(Map<String, Object> map);
	
	/**
	 * @������: findUserNameIsExist
	 * @����˵��: �����û���Ϣʱ�ж��û��Ƿ����
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��6������6:55:33
	 * @return
	 * @return: int
	 */
	public int findUserNameIsExist(String userName);
	
	
	/**
	 * @������: addUserInfo
	 * @����˵��: �����û���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��6������7:30:25
	 * @param userInfo
	 * @return: int
	 */
	public int addUserInfo(UserInfo userInfo);
	
	/**
	 * @������: findPasswordByUserId
	 * @����˵��: �޸�֮ǰ��ͨ���û�id�ҵ��û�����
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������12:06:49
	 * @param user_id
	 * @return: String
	 */
	public String findPasswordByUserId(int user_id);
	
	/**
	 * @������: updateUserInfo
	 * @����˵��: �޸��û���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������12:08:11
	 * @param userInfo
	 * @return: int
	 */
	public int updateUserInfo(UserInfo userInfo);
	
	/**
	 * @������: deleteUserInfo
	 * @����˵��: ɾ���û���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������12:58:00
	 * @param user_id
	 * @return: int
	 */
	public int deleteUserInfo(int user_id);
	/**
	 * @������: insertUserAndRole
	 * @����˵��: �ɽ�ɫ��Ȩ���û�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��7������10:37:03
	 * @param map
	 * @return: int
	 */
	public int insertUserAndRole(Map<String, Object> map);
	
	/**
	 * @������: deleteUserOwerRoleByUid
	 * @����˵��: ֱ��ɾ���û���ӵ�еĽ�ɫ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��8������3:27:06
	 * @param user_id
	 * @return: int
	 */
	public int deleteUserOwerRoleByUid(int user_id);
	
}


