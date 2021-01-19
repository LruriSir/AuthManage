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

/**@文件名: RoleInfoController.java
 * @类功能说明: 角色管理控制层
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月7日下午7:22:04
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月7日下午7:22:04</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("roleInfo")
public class RoleInfoController {

	@Autowired
	private RoleInfoService roleInfoService;  //引入service接口
	
	/**
	 * @方法名: findAllRoleInfoToUser
	 * @方法说明: 查询角色信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月8日下午2:01:00
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
	
	
	
	
	
	
	/*--------------------------------------------角色管理列表--------------------------------------------------------*/
	
	@RequestMapping("/findAllRoleInfo")
	@ResponseBody
	public Map<String, Object> findAllRoleInfo(int page,int rows,String s_roleName) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("s_roleName", s_roleName);
		
		PageBean pageBean=new PageBean(page, rows);//顺序不能改变
		map.put("pageBean", pageBean);
		List<RoleInfo> roleList=roleInfoService.findAllRoleInfo(map);
		int total=roleInfoService.findAllRoleInfoCount(map);//total不能改
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", roleList);
		
		return resultMap;
	}
	
	/*新增角色信息时判断角色是否存在*/
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
	
	
	/*新增角色信息*/
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
	
	/*修改角色信息*/
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
	
	/*删除角色信息*/
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
