package com.imti.dao;
/**@文件名: UserInfoDao.java
 * @类功能说明: 用户持久层Dao接口
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月4日下午3:45:40
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月4日下午3:45:40</li> 
 *	 <li>内容: </li>
 * </pre>
 */

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

public interface UserInfoDao {
	/**
	 * @方法名: login
	 * @方法说明: 用户持久层登录接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月4日下午4:07:32
	 * @param UserInfo
	 * @return: UserInfo
	 */
	public UserInfo login(UserInfo userInfo);
	/**
	 * @方法名: getCurrentUserOwerMenus
	 * @方法说明: 用户登录显示菜单权限
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月6日上午10:49:25
	 * @param user_id
	 * @return
	 * @return: List<String>
	 */
	public List<String> getCurrentUserOwerMenus(int user_id);
	
	/**
	 * @方法名: findAllUserInfo
	 * @方法说明: 用户查询所有
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月6日上午10:48:48
	 * @param map
	 * @return: List<UserInfo>
	 */
	public List<UserInfo> findAllUserInfo(Map<String, Object> map);
	
	/**
	 * @方法名: findAllUserInfoCount
	 * @方法说明: 查询结果分页
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月6日下午1:13:11
	 * @param map
	 * @return: int
	 */
	public int findAllUserInfoCount(Map<String, Object> map);
	
	/**
	 * @方法名: findUserNameIsExist
	 * @方法说明: 新增用户信息时判断用户是否存在
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月6日下午6:55:33
	 * @return
	 * @return: int
	 */
	public int findUserNameIsExist(String userName);
	
	
	/**
	 * @方法名: addUserInfo
	 * @方法说明: 新增用户信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月6日下午7:30:25
	 * @param userInfo
	 * @return: int
	 */
	public int addUserInfo(UserInfo userInfo);
	
	/**
	 * @方法名: findPasswordByUserId
	 * @方法说明: 修改之前先通过用户id找到用户密码
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午12:06:49
	 * @param user_id
	 * @return: String
	 */
	public String findPasswordByUserId(int user_id);
	
	/**
	 * @方法名: updateUserInfo
	 * @方法说明: 修改用户信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午12:08:11
	 * @param userInfo
	 * @return: int
	 */
	public int updateUserInfo(UserInfo userInfo);
	
	/**
	 * @方法名: deleteUserInfo
	 * @方法说明: 删除用户信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午12:58:00
	 * @param user_id
	 * @return: int
	 */
	public int deleteUserInfo(int user_id);
	/**
	 * @方法名: insertUserAndRole
	 * @方法说明: 吧角色授权给用户
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午10:37:03
	 * @param map
	 * @return: int
	 */
	public int insertUserAndRole(Map<String, Object> map);
	
	/**
	 * @方法名: deleteUserOwerRoleByUid
	 * @方法说明: 直接删除用户所拥有的角色
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月8日下午3:27:06
	 * @param user_id
	 * @return: int
	 */
	public int deleteUserOwerRoleByUid(int user_id);
	
}


