package com.imti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.imti.dao.MenuInfoDao;
import com.imti.model.MenuInfo;
import com.imti.service.MenuInfoService;

/**@文件名: MenuInfoServiceImpl.java
 * @类功能说明: 菜单管理层实现类
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月5日下午12:39:17
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月5日下午12:39:17</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService{
	
	@Autowired
	private MenuInfoDao menuInfoDao;         //将MenuInfoDao接口引入Service实现类
	
	
	/**
	 * 递归实现菜单管理菜单
	 */
	@Override
	public JSONArray findMenuInfoByParentId(int parentId,List<String> menuIds) {
		JSONArray jsonArray=this.getMenuInfoByParentId(parentId,menuIds);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("state"))) {
				continue;//结束当前循环，进行下一个循环
			}else {
				//EasyUI的TREE树的children是子节点数组
				jsonObject.put("children", findMenuInfoByParentId(jsonObject.getIntValue("id"),menuIds));
			}
		}
		return jsonArray;
	}
	/**
	 * @方法名: getMenuInfoByParentId
	 * @方法说明: 递归
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午10:03:30
	 * @param parentId
	 * @param menuIds
	 * @return: JSONArray
	 */
	public JSONArray getMenuInfoByParentId(int parentId,List<String> menuIds) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("parentId",parentId);
		map.put("menuIds",menuIds);
		List<MenuInfo> menuList=menuInfoDao.findMenuInfoByParentId(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<menuList.size();i++) {        //数据库字段名转换为EasyUI的TREE树的字段
			MenuInfo menuInfo=menuList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", menuInfo.getMenu_id());
			jsonObject.put("text", menuInfo.getMenu_name());
			jsonObject.put("state", menuInfo.getMenu_state());
			jsonObject.put("iconCls", menuInfo.getMenu_icon());
			
			//JSON嵌套  因为attributes是存放的集合属性
			JSONObject jsonObject1=new JSONObject();
			jsonObject1.put("url", menuInfo.getMenu_url());
			jsonObject.put("attributes", jsonObject1);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	
	
	
	/**
	 * 查询用户所有的权限
	 */
	@Override
	public List<String> getCurrentUserOwerMenus(int user_id) {
		// TODO Auto-generated method stub
		return menuInfoDao.getCurrentUserOwerMenus(user_id);
	}

	/**
	 * 查询所有菜单
	 */
	@Override
	public JSONArray findAllMenuInfoByRoleId(int parentId, int role_id) {
		// TODO Auto-generated method stub
		JSONArray jsonArray=this.getAllMenuInfoByRoleId(parentId,role_id);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("state"))) {
				continue;
			}else {
				jsonObject.put("children", findAllMenuInfoByRoleId(jsonObject.getInteger("id"),role_id));
			}
		}
		return jsonArray;
	}
	/**
	 * @方法名: getAllMenuInfoByRoleId
	 * @方法说明: 递归
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午10:04:22
	 * @param parentId
	 * @param role_id
	 * @return: JSONArray
	 */
	public JSONArray getAllMenuInfoByRoleId(int parentId,int role_id) {
		//查找当前角色拥有的权限
		List<Integer> role_menuIds=menuInfoDao.findRoleOwnerMenuByRoleId(role_id);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("parentId", parentId);
		List<MenuInfo> menuList=menuInfoDao.findAllMenuInfoByRoleId(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<menuList.size();i++) {
			MenuInfo menuInfo=menuList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", menuInfo.getMenu_id());
			if(role_menuIds.contains(jsonObject.getInteger("id"))){
				jsonObject.put("checked", true);
			}
			jsonObject.put("text", menuInfo.getMenu_name());
			jsonObject.put("state", menuInfo.getMenu_state());
			jsonObject.put("iconCls", menuInfo.getMenu_icon());
			JSONObject jsonObject1=new JSONObject();
			jsonObject1.put("url", menuInfo.getMenu_url());
			jsonObject.put("attributes", jsonObject1);
			jsonArray.add(jsonObject);	
		}
		return jsonArray;
	}

	/**
	 * 授权
	 */
	@Override
	public int saveRoleAndMenu(int role_id, String menuIds) {
		// TODO Auto-generated method stub
		menuInfoDao.deleteRoleOldMenuByRoleId(role_id);
		String strs[]=menuIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("role_id", role_id);
			map.put("menu_id", strs[i]);
			
			result+=menuInfoDao.addRoleAndMenu(map);
		}
		return result;
	}
	
	
	/**
	 * 菜单树形显示Service实现类
	 */
	@Override
	public JSONArray findAllMenuInfo(int parentId) {
		JSONArray jsonArray=this.getAllMenuInfo(parentId);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
		
			if("open".equals(jsonObject.getString("menu_state"))) {
				continue;
			}else {
				jsonObject.put("children",findAllMenuInfo(jsonObject.getInteger("menu_id")));
			}
		}
		return jsonArray;
	}
	
	/**
	 * @方法名: getAllMenuInfo
	 * @方法说明: 递归
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日上午9:40:32
	 * @param parentId
	 * @return: JSONArray
	 */
	public JSONArray getAllMenuInfo(int parentId){
		List<MenuInfo> menuList=menuInfoDao.findAllMenuInfo(parentId);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<menuList.size();i++) {
			MenuInfo menuInfo=menuList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("menu_id", menuInfo.getMenu_id());
			jsonObject.put("parentId", menuInfo.getParentId());
			jsonObject.put("menu_name", menuInfo.getMenu_name());
			jsonObject.put("menu_state", menuInfo.getMenu_state());
			jsonObject.put("menu_url", menuInfo.getMenu_url());
			jsonObject.put("menu_icon", menuInfo.getMenu_icon());
			jsonObject.put("createTime", menuInfo.getCreateTime());
			jsonObject.put("menu_remark", menuInfo.getMenu_remark());
			jsonArray.add(jsonObject);	
		}
		return jsonArray;
}
	
	/**
	 * 添加菜单信息
	 */
	@Override
	public int addMenuInfo(MenuInfo menuInfo) {
		// TODO Auto-generated method stub
		menuInfo.setMenu_state("open");
		return menuInfoDao.addMenuInfo(menuInfo);
	}
	

	/**
	 * 修改菜单信息
	 */
	@Override
	public int updateMenuInfo(MenuInfo menuInfo) {
		// TODO Auto-generated method stub
		return menuInfoDao.updateMenuInfo(menuInfo);
	}
	/**
	 * 删除菜单信息
	 */
	@Override
	public int deleteMenuInfo(String menuId) {
		// TODO Auto-generated method stub
		String strs[]=menuId.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			result+=menuInfoDao.deleteMenuInfo(Integer.parseInt(strs[i]));
		}
		return result;
	}
}
