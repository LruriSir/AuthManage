package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@文件名: UserInfoService.java
 * @类功能说明: 用户处理层Service接口
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月4日下午4:04:03
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月4日下午4:04:03</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface UserInfoService {
	/**
	 * @方法名: login
	 * @方法说明: 用户处理层登录接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月4日下午4:09:01
	 * @param UserInfo
	 * @return: UserInfo
	 */
	public UserInfo login(UserInfo userInfo);
	/**
	 * @方法名: findAllUserInfo
	 * @方法说明: 用户查询信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月6日上午10:52:15
	 * @return: List<UserInfo>
	 */
	public List<UserInfo> findAllUserInfo(Map<String, Object> map);
	/**
	 * @方法名: findAllUserInfoCount
	 * @方法说明: 查询结果分页
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月6日下午12:59:55
	 * @param map
	 * @return: int
	 */
	public int findAllUserInfoCount(Map<String, Object> map);
	
	/**
	 * @方法名: findUserNameIsExist
	 * @方法说明: 新增用户信息时判断用户是否存在
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月6日下午6:52:37
	 * @param user_name
	 * @return: int
	 */
	public int findUserNameIsExist(String userName);
	/**
	 * @方法名: addUserInfo
	 * @方法说明: 新增用户信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月6日下午7:31:24
	 * @param userInfo
	 * @return: int
	 */
	public int addUserInfo(UserInfo userInfo);
	
	
	/**
	 * @方法名: findPasswordByUserId
	 * @方法说明: 修改时找到用户密码
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午12:44:39
	 * @param user_id
	 * @return: String
	 */
	//public String findPasswordByUserId(int user_id);
	
	/**
	 * @方法名: updateUserInfo
	 * @方法说明: 修改用户信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午12:00:01
	 * @param userInfo
	 * @return: int
	 */
	public int updateUserInfo(UserInfo userInfo);
	/**
	 * @方法名: deleteUserInfo
	 * @方法说明: 删除用户信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午1:04:36
	 * @param user_id
	 * @return: int
	 */
	public int deleteUserInfo(String userIds);
	
	
	/**
	 * @方法名: insertUserAndRole
	 * @方法说明: 吧角色授权给用户
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午10:28:56
	 * @param userId
	 * @param roleIds
	 * @return: int
	 */
	public int insertUserAndRole(int userId,String roleIds);
	
	/**
	 * @方法名: deleteUserOwerRoleByUid
	 * @方法说明: 回收权限
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日下午12:07:05
	 * @param userId
	 * @param roleIds
	 * @return: int
	 */
	public int deleteUserOwerRoleByUid(int userId,String roleIds);
	
}
