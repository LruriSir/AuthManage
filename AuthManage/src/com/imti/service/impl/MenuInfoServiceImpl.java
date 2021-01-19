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

/**@�ļ���: MenuInfoServiceImpl.java
 * @�๦��˵��: �˵������ʵ����
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��5������12:39:17
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��5������12:39:17</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService{
	
	@Autowired
	private MenuInfoDao menuInfoDao;         //��MenuInfoDao�ӿ�����Serviceʵ����
	
	
	/**
	 * �ݹ�ʵ�ֲ˵�����˵�
	 */
	@Override
	public JSONArray findMenuInfoByParentId(int parentId,List<String> menuIds) {
		JSONArray jsonArray=this.getMenuInfoByParentId(parentId,menuIds);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("state"))) {
				continue;//������ǰѭ����������һ��ѭ��
			}else {
				//EasyUI��TREE����children���ӽڵ�����
				jsonObject.put("children", findMenuInfoByParentId(jsonObject.getIntValue("id"),menuIds));
			}
		}
		return jsonArray;
	}
	/**
	 * @������: getMenuInfoByParentId
	 * @����˵��: �ݹ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������10:03:30
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
		for(int i=0;i<menuList.size();i++) {        //���ݿ��ֶ���ת��ΪEasyUI��TREE�����ֶ�
			MenuInfo menuInfo=menuList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", menuInfo.getMenu_id());
			jsonObject.put("text", menuInfo.getMenu_name());
			jsonObject.put("state", menuInfo.getMenu_state());
			jsonObject.put("iconCls", menuInfo.getMenu_icon());
			
			//JSONǶ��  ��Ϊattributes�Ǵ�ŵļ�������
			JSONObject jsonObject1=new JSONObject();
			jsonObject1.put("url", menuInfo.getMenu_url());
			jsonObject.put("attributes", jsonObject1);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	
	
	
	/**
	 * ��ѯ�û����е�Ȩ��
	 */
	@Override
	public List<String> getCurrentUserOwerMenus(int user_id) {
		// TODO Auto-generated method stub
		return menuInfoDao.getCurrentUserOwerMenus(user_id);
	}

	/**
	 * ��ѯ���в˵�
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
	 * @������: getAllMenuInfoByRoleId
	 * @����˵��: �ݹ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������10:04:22
	 * @param parentId
	 * @param role_id
	 * @return: JSONArray
	 */
	public JSONArray getAllMenuInfoByRoleId(int parentId,int role_id) {
		//���ҵ�ǰ��ɫӵ�е�Ȩ��
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
	 * ��Ȩ
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
	 * �˵�������ʾServiceʵ����
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
	 * @������: getAllMenuInfo
	 * @����˵��: �ݹ�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������9:40:32
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
	 * ��Ӳ˵���Ϣ
	 */
	@Override
	public int addMenuInfo(MenuInfo menuInfo) {
		// TODO Auto-generated method stub
		menuInfo.setMenu_state("open");
		return menuInfoDao.addMenuInfo(menuInfo);
	}
	

	/**
	 * �޸Ĳ˵���Ϣ
	 */
	@Override
	public int updateMenuInfo(MenuInfo menuInfo) {
		// TODO Auto-generated method stub
		return menuInfoDao.updateMenuInfo(menuInfo);
	}
	/**
	 * ɾ���˵���Ϣ
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
