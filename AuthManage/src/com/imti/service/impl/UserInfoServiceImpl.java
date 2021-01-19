package com.imti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imti.dao.UserInfoDao;
import com.imti.model.UserInfo;
import com.imti.service.UserInfoService;
import com.imti.util.Md5;
import com.imti.util.UUIDUtil;

/**@�ļ���: UserInfoServiceImpl.java
 * @�๦��˵��: �û������ʵ����
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��4������4:10:01
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��4������4:10:01</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoDao UserInfoDao;     //��Dao�ӿ�����Serviceʵ����
	/**
	 * �û�������¼�ӿڵ�ʵ��
	 */
	@Override
	public UserInfo login(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return UserInfoDao.login(userInfo);
	}
	
	/**
	 * �û���ѯ���д����ӿ�ʵ��
	 */
	@Override
	public List<UserInfo> findAllUserInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return UserInfoDao.findAllUserInfo(map);
	}
	
	/**
	 * ��ҳ
	 */
	@Override
	public int findAllUserInfoCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return UserInfoDao.findAllUserInfoCount(map);
	}

	/**
	 * �����û���Ϣʱ�ж��û��Ƿ����
	 */
	@Override
	public int findUserNameIsExist(String userName) {
		// TODO Auto-generated method stub
		return UserInfoDao.findUserNameIsExist(userName);
	}
	/**
	 * �����û���Ϣ
	 */
	@Override
	public int addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfo.setUser_code(UUIDUtil.getUUID());
		return UserInfoDao.addUserInfo(userInfo);
	}
	
	
	/**
	 * �޸�ʱ�ҵ��û�����
	 */
	/*@Override
	public String findPasswordByUserId(int user_id) {
		// TODO Auto-generated method stub
		return UserInfoDao.findPasswordByUserId(user_id);
	}*/
	
	
	
	/**
	 * �޸��û���Ϣ
	 */
	@Override
	public int updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String user_pwd=UserInfoDao.findPasswordByUserId(userInfo.getUser_id());
		if(user_pwd.equals(userInfo.getUser_pwd())) {
			userInfo.setUser_pwd(Md5.MD5(userInfo.getUser_pwd())+userInfo.getUser_name());
		}
		return UserInfoDao.updateUserInfo(userInfo);
	}
	
	
	/**
	 * ɾ���û���Ϣ
	*/
	@Override
	public int deleteUserInfo(String userIds) {
		// TODO Auto-generated method stub
		String strs[]=userIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			result+=UserInfoDao.deleteUserInfo(Integer.parseInt(strs[i]));
		}
		return result;
	}
	
	/**
	 * �ѽ�ɫ��Ȩ���û�
	 */
	@Override
	public int insertUserAndRole(int user_id, String roleIds) {
		UserInfoDao.deleteUserOwerRoleByUid(user_id);
		String strs[]=roleIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("user_id", user_id);
			map.put("role_id", Integer.parseInt(strs[i]));
			result+=UserInfoDao.insertUserAndRole(map);
		}
		return result;
	}

	/**
	 * ����Ȩ��
	 */
	@Override
	public int deleteUserOwerRoleByUid(int user_id,String roleIds) {
		
		//UserInfoDao.deleteUserOwerRoleByUid(user_id);
		String strs[]=roleIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("user_id", user_id);
			map.put("role_id", Integer.parseInt(strs[i]));
			result+=UserInfoDao.deleteUserOwerRoleByUid(user_id);
		}
		return result;
	}

	

	

}
