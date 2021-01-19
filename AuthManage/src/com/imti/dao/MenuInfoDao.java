package com.imti.dao;
/**@文件名: MenuInfoDao.java
 * @类功能说明: 菜单管理持久层Dao接口
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月5日下午12:26:01
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月5日下午12:26:01</li> 
 *	 <li>内容: </li>
 * </pre>
 */

import java.util.List;
import java.util.Map;

import com.imti.model.MenuInfo;

public interface MenuInfoDao {
	/**
	 * @方法名: findMenuInfoByParentId
	 * @方法说明: 菜单管理持久层目录Dao接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月5日下午12:29:03
	 * @param parentId
	 * @return
	 * @return: JSONArray
	 */
	public List<MenuInfo> findMenuInfoByParentId(Map<String, Object> map);
	
/**
 * @方法名: getCurrentUserOwerMenus
 * @方法说明: 根据用户ID查询用户所拥有的权限ID持久层Dao接口
 * @作者: BaiYunZhong
 * @邮箱：2537975653@qq.com
 * @日期: 2021年1月12日上午9:43:56
 * @param user_id
 * @return: List<String>
 */
	public List<String> getCurrentUserOwerMenus(int user_id);
	
	
	/**
	 * @方法名: findAllMenuInfoByRoleId
	 * @方法说明: 通过role_id查出所有持久层Dao接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午9:44:09
	 * @param map
	 * @return: List<MenuInfo>
	 */
    public List<MenuInfo> findAllMenuInfoByRoleId(Map<String,Object> map);
	/**
	 * @方法名: findRoleOwnerMenuByRoleId
	 * @方法说明: 回显持久层Dao接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午10:00:41
	 * @param role_id
	 * @return: List<Integer>
	 */
	public List<Integer> findRoleOwnerMenuByRoleId(int role_id);
	
	/**
	 * @方法名: deleteRoleOldMenuByRoleId
	 * @方法说明: 删除权限持久层Dao接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午10:00:48
	 * @param role_id
	 * @return: int
	 */
	public int deleteRoleOldMenuByRoleId(int role_id);
	/**
	 * @方法名: addRoleAndMenu
	 * @方法说明: 授权持久层Dao接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午10:01:04
	 * @param map
	 * @return: int
	 */
	public int addRoleAndMenu(Map<String,Object> map);
	/**
	 * @方法名: findAllMenuInfo
	 * @方法说明: 菜单树形显示持久层Dao接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日上午9:24:58
	 * @param parentId
	 * @return: List<MenuInfo>
	 */
	public List<MenuInfo> findAllMenuInfo(int parentId);
	
	/**
	 * @方法名: addMenuInfo
	 * @方法说明: 增加菜单信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日上午10:22:07
	 * @param menuInfo
	 * @return: int
	 */
	public int addMenuInfo(MenuInfo menuInfo);
	/**
	 * @方法名: updateMenuInfo
	 * @方法说明: 修改菜单信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日下午5:12:15
	 * @param menuInfo
	 * @return: int
	 */
	public int updateMenuInfo(MenuInfo menuInfo);
	/**
	 * @方法名: deleteMenuInfo
	 * @方法说明: 删除菜单信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日下午8:51:34
	 * @param menu_id
	 * @return: int
	 */
	public int deleteMenuInfo(int menu_id);
}
