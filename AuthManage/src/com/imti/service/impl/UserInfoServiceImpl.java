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

/**@文件名: UserInfoServiceImpl.java
 * @类功能说明: 用户处理层实现类
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月4日下午4:10:01
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月4日下午4:10:01</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoDao UserInfoDao;     //将Dao接口引入Service实现类
	/**
	 * 用户处理层登录接口的实现
	 */
	@Override
	public UserInfo login(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return UserInfoDao.login(userInfo);
	}
	
	/**
	 * 用户查询所有处理层接口实现
	 */
	@Override
	public List<UserInfo> findAllUserInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return UserInfoDao.findAllUserInfo(map);
	}
	
	/**
	 * 分页
	 */
	@Override
	public int findAllUserInfoCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return UserInfoDao.findAllUserInfoCount(map);
	}

	/**
	 * 新增用户信息时判断用户是否存在
	 */
	@Override
	public int findUserNameIsExist(String userName) {
		// TODO Auto-generated method stub
		return UserInfoDao.findUserNameIsExist(userName);
	}
	/**
	 * 新增用户信息
	 */
	@Override
	public int addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfo.setUser_code(UUIDUtil.getUUID());
		return UserInfoDao.addUserInfo(userInfo);
	}
	
	
	/**
	 * 修改时找到用户密码
	 */
	/*@Override
	public String findPasswordByUserId(int user_id) {
		// TODO Auto-generated method stub
		return UserInfoDao.findPasswordByUserId(user_id);
	}*/
	
	
	
	/**
	 * 修改用户信息
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
	 * 删除用户信息
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
	 * 把角色授权给用户
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
	 * 回收权限
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
