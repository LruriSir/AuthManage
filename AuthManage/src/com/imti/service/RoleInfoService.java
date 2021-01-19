package com.imti.service;

import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSONArray;
import com.imti.model.RoleInfo;

/**@文件名: RoleInfoService.java
 * @类功能说明: 角色处理层Service接口
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月7日下午7:15:12
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月7日下午7:15:12</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface RoleInfoService {
	/**
	 * @方法名: findAllRoleInfoToUser
	 * @方法说明: 查询所有角色信息Service接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午7:16:06
	 * @param user_id
	 * @return: JSONArray
	 */
	public JSONArray findAllRoleInfoToUser(int user_id);
	
	/**
	 * @方法名: findUserOwerRolesByUid
	 * @方法说明: 通过用户id查找用户授权信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月8日下午3:23:49
	 * @param user_id
	 * @return: List<Integer>
	 */
	//public List<Integer> findUserOwerRolesByUid(int user_id);
	/**
	 * @方法名: findAllRoleInfoCount
	 * @方法说明: 查询所有角色信息分页Service接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月7日下午7:16:13
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount(Map<String, Object> map);
	
	//public int deleteUserOwerRoleByUid(String roleIds);
	/*--------------------------------------------------------------------------------------*/
	/**
	 * @方法名: findAllRoleInfo
	 * @方法说明: 查询所有角色信息Service接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月9日上午10:50:17
	 * @param map
	 * @return
	 * @return: List<UserInfo>
	 */
	public List<RoleInfo> findAllRoleInfo(Map<String, Object> map);
	/**
	 * @方法名: findRoleNameIsExist
	 * @方法说明: 新增角色信息时判断用户是否存在
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月10日下午6:12:29
	 * @param userName
	 * @return: int
	 */
	public int findRoleNameIsExist(String roleName);
	/**
	 * @方法名: addRoleInfo
	 * @方法说明: 新增角色信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月10日下午6:22:25
	 * @param userInfo
	 * @return: int
	 */
	public int addRoleInfo(RoleInfo roleInfo);
	/**
	 * @方法名: updateRoleInfo
	 * @方法说明: 修改角色信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月11日上午10:24:47
	 * @param roleInfo
	 * @return: int
	 */
	public int updateRoleInfo(RoleInfo roleInfo);
	/**
	 * @方法名: deleteRoleInfo
	 * @方法说明: 删除角色信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月11日上午10:25:04
	 * @param roleIds
	 * @return: int
	 */
	public int deleteRoleInfo(String roleIds);
}
