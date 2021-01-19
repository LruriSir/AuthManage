package com.imti.dao;
/**@文件名: RoleInfoDao.java
 * @类功能说明:  角色授权持久层接口
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月7日下午6:58:18
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月7日下午6:58:18</li> 
 *	 <li>内容: </li>
 * </pre>
 */

import java.util.List;
import java.util.Map;

import com.imti.model.RoleInfo;



public interface RoleInfoDao {
	/**
	 * @方法名: findAllRoleInfoToUser
	 * @方法说明: 查询所有角色信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午7:01:19
	 * @param map
	 * @return: List<RoleInfo>
	 */
	public List<RoleInfo> findAllRoleInfoToUser();
	
	/**
	 * @方法名: findUserOwerRolesByUid
	 * @方法说明: 通过用户id查找用户授权信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月8日下午2:39:32
	 * @param user_id
	 * @return: List<Integer>
	 */
	public List<Integer> findUserOwerRolesByUid(int user_id);
	/**
	 * @方法名: findAllRoleInfoCount
	 * @方法说明: 查询所有角色信息分页
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午7:01:59
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount(Map<String, Object> map);
	
	
	
	
//-------------------------------------------------角色列表---------------------------------------------
	/**
	 * @方法名: findAllRoleInfo
	 * @方法说明: 查询所有
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月9日上午10:38:25
	 * @param map
	 * @return
	 * @return: List<UserInfo>
	 */
	public List<RoleInfo> findAllRoleInfo(Map<String, Object> map);
	
	/**
	 * @方法名: findAllRoleInfoCount
	 * @方法说明: 查询结果分页
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月10日上午10:58:38
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount1(Map<String, Object> map);
	
	/**
	 * @方法名: findRoleNameIsExist
	 * @方法说明: 新增角色信息时判断用户是否存在
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月10日上午11:20:22
	 * @param userName
	 * @return: int
	 */
	public int findRoleNameIsExist(String roleName);
	
	/**
	 * @方法名: addRoleInfo
	 * @方法说明: 新增角色信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月10日下午7:01:59
	 * @param userInfo
	 * @return: int
	 */
	public int addRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @方法名: updateRoleInfo
	 * @方法说明: 修改角色信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月11日上午10:26:27
	 * @param roleInfo
	 * @return: int
	 */
	public int updateRoleInfo(RoleInfo roleInfo);
	/**
	 * @方法名: deleteRoleInfo
	 * @方法说明: 删除角色信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月11日上午10:26:44
	 * @param role_id
	 * @return: int
	 */
	public int deleteRoleInfo(int role_id);
}
