package com.imti.service.impl;




import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.imti.dao.RoleInfoDao;
import com.imti.model.RoleInfo;
import com.imti.service.RoleInfoService;
import com.imti.util.UUIDUtil;

/**@�ļ���: RoleInfoServiceImpl.java
 * @�๦��˵��: ��ɫ�����ʵ����
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��7������7:17:38
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��7������7:17:38</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService{
	
	@Autowired
	private RoleInfoDao roleInfoDao;     //��Dao�ӿ�����Serviceʵ����
	
	
	/**
	 * ��ɫ��ѯ���д����ӿ�ʵ��
	 */
	@Override
	public JSONArray findAllRoleInfoToUser(int user_id) {
		List<Integer> role_ids=roleInfoDao.findUserOwerRolesByUid(user_id);
		List<RoleInfo> roleList=roleInfoDao.findAllRoleInfoToUser();
		JSONArray jsonArray=new JSONArray();
		
		for(int i=0;i<roleList.size();i++) {
			RoleInfo roleInfo=roleList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("role_id", roleInfo.getRole_id());
			jsonObject.put("role_name", roleInfo.getRole_name());
			jsonObject.put("role_code", roleInfo.getRole_code());
			jsonObject.put("role_state", roleInfo.getRole_state());
			jsonObject.put("role_delflag", roleInfo.getRole_delflag());
			jsonObject.put("opt_id", roleInfo.getRole_id());
			jsonObject.put("createTime", roleInfo.getCreateTime());
			jsonObject.put("role_remark", roleInfo.getRole_remark());
			
			
			if(role_ids.contains(roleInfo.getRole_id())) {
				jsonObject.put("checked", true);
			}
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
	
	
	/**
	 * ��ɫ��ѯ���д����ӿ�ʵ�ַ�ҳ
	 */
	@Override
	public int findAllRoleInfoCount(Map<String, Object> map) {
		return roleInfoDao.findAllRoleInfoCount(map);
	}
	
	
	
	/*@Override
	public int deleteUserOwerRoleByUid(String roleIds) {
		String strs[]=roleIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			result+=roleInfoDao.deleteUserOwerRoleByUid(Integer.parseInt(strs[i]));
		}
		return result;
	}*/
/*----------------------------------------------------------------------------------------------*/
	/**
	 * ��ɫ�����ɫ��ѯ����
	 */
	@Override
	public List<RoleInfo> findAllRoleInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleInfoDao.findAllRoleInfo(map);
	}


	/**
	 * ��ɫ����������ɫ��Ϣʱ�жϽ�ɫ�Ƿ����
	 */
	@Override
	public int findRoleNameIsExist(String roleName) {
		// TODO Auto-generated method stub
		return roleInfoDao.findRoleNameIsExist(roleName);
	}


	/**
	 * ������ɫ��Ϣ
	 */
	@Override
	public int addRoleInfo(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		roleInfo.setRole_code(UUIDUtil.getUUID());
		return roleInfoDao.addRoleInfo(roleInfo);
	}

	/**
	 * �޸Ľ�ɫ��Ϣ
	 */

	@Override
	public int updateRoleInfo(RoleInfo roleInfo) {
		
		return roleInfoDao.updateRoleInfo(roleInfo);
	}


	/**
	 * ɾ����ɫ��Ϣ
	 */
	@Override
	public int deleteRoleInfo(String roleIds) {
		String strs[]=roleIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			result+=roleInfoDao.deleteRoleInfo(Integer.parseInt(strs[i]));
		}
		return result;
	}



	



	



	



	

}
