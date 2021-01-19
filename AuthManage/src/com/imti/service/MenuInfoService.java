package com.imti.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.imti.model.MenuInfo;

/**@文件名: MenuInfoService.java
 * @类功能说明: 菜单管理Service接口
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月5日下午12:37:34
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月5日下午12:37:34</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface MenuInfoService {
	/**
	 * @方法名: findMenuInfoByParentId
	 * @方法说明: 菜单管理Service接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月5日下午12:48:57
	 * @param parentId
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray findMenuInfoByParentId(int parentId,List<String> menuIds);
	
	/**
	 * @方法名: getCurrentUserOwerMenus
	 * @方法说明: 根据用户ID查询用户所拥有的权限ID
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午9:45:39
	 * @param user_id
	 * @return: List<String>
	 */
	public List<String> getCurrentUserOwerMenus(int user_id);
	/**
	 * @方法名: findAllMenuInfoByRoleId
	 * @方法说明: 查询全部菜单
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午9:46:47
	 * @param parentId
	 * @param role_id
	 * @return: JSONArray
	 */
    public JSONArray findAllMenuInfoByRoleId(int parentId,int role_id);
	
    /**
     * @方法名: saveRoleAndMenu
     * @方法说明: 回显
     * @作者: BaiYunZhong
     * @邮箱：2537975653@qq.com
     * @日期: 2021年1月12日上午9:47:27
     * @param role_id
     * @param menuIds
     * @return: int
     */
	public int saveRoleAndMenu(int role_id,String menuIds); 
	
	/**
	 * @方法名: findAllMenuInfo
	 * @方法说明: 菜单树形显示Service接口
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日上午9:30:37
	 * @param parentId
	 * @return: List<MenuInfo>
	 */
	public  JSONArray findAllMenuInfo(int parentId);
	/**
	 * @方法名: addMenuInfo
	 * @方法说明: 添加菜单信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日上午10:22:46
	 * @param menuInfo
	 * @return: int
	 */
	public int addMenuInfo(MenuInfo menuInfo);
	/**
	 * @方法名: updateMenuInfo
	 * @方法说明: 修改菜单信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日下午5:11:29
	 * @param menuInfo
	 * @return: int
	 */
	public int updateMenuInfo(MenuInfo menuInfo);
	/**
	 * @方法名: deleteMenuInfo
	 * @方法说明: 删除菜单信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日下午8:48:27
	 * @param menuId
	 * @return: int
	 */
	public int deleteMenuInfo(String menuId);
}
