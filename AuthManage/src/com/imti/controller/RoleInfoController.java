package com.imti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.imti.model.PageBean;
import com.imti.model.RoleInfo;
import com.imti.model.UserInfo;
import com.imti.service.RoleInfoService;

/**@�ļ���: RoleInfoController.java
 * @�๦��˵��: ��ɫ������Ʋ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��7������7:22:04
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��7������7:22:04</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Controller
@RequestMapping("roleInfo")
public class RoleInfoController {

	@Autowired
	private RoleInfoService roleInfoService;  //����service�ӿ�
	
	/**
	 * @������: findAllRoleInfoToUser
	 * @����˵��: ��ѯ��ɫ��Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��8������2:01:00
	 * @param user_id
	 * @return: JSONObject
	 */
	@RequestMapping("/findAllRoleInfoToUser")
	@ResponseBody
	public JSONObject findAllRoleInfoToUser(int user_id) {
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=roleInfoService.findAllRoleInfoToUser(user_id);
		jsonObject.put("rows", jsonArray);
		return jsonObject;
	}
	
	
	
	
	
	
	/*--------------------------------------------��ɫ�����б�--------------------------------------------------------*/
	
	@RequestMapping("/findAllRoleInfo")
	@ResponseBody
	public Map<String, Object> findAllRoleInfo(int page,int rows,String s_roleName) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("s_roleName", s_roleName);
		
		PageBean pageBean=new PageBean(page, rows);//˳���ܸı�
		map.put("pageBean", pageBean);
		List<RoleInfo> roleList=roleInfoService.findAllRoleInfo(map);
		int total=roleInfoService.findAllRoleInfoCount(map);//total���ܸ�
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", roleList);
		
		return resultMap;
	}
	
	/*������ɫ��Ϣʱ�жϽ�ɫ�Ƿ����*/
	@RequestMapping("/findRoleNameIsExist")
	@ResponseBody
	public JSONObject findRoleNameIsExist(String roleName){
		JSONObject jsonObject=new JSONObject();
		int count=roleInfoService.findRoleNameIsExist(roleName);
		if(count>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	
	/*������ɫ��Ϣ*/
	@RequestMapping("/addRoleInfo")
	@ResponseBody
	public JSONObject addRoleInfo(RoleInfo roleInfo,HttpServletRequest request){
		HttpSession session=request.getSession();
		UserInfo sessionUserInfo=(UserInfo) session.getAttribute("currentUserInfo");
		roleInfo.setOpt_id(sessionUserInfo.getUser_id());
		JSONObject jsonObject=new JSONObject();
		int count=roleInfoService.addRoleInfo(roleInfo);
		if(count>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	/*�޸Ľ�ɫ��Ϣ*/
	@RequestMapping("/updateRoleInfo")
	@ResponseBody
	public JSONObject updateRoleInfo(RoleInfo roleInfo,HttpServletRequest request){
		JSONObject jsonObject=new JSONObject();
		int count=roleInfoService.updateRoleInfo(roleInfo);
		if(count>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	/*ɾ����ɫ��Ϣ*/
	@RequestMapping("/deleteRoleInfo")
	@ResponseBody
	public JSONObject deleteRoleInfo(String roleIds,HttpServletRequest request){
		JSONObject jsonObject=new JSONObject();
		int result=roleInfoService.deleteRoleInfo(roleIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
}
