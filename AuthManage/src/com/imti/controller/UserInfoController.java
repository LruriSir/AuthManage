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

import com.alibaba.fastjson.JSONObject;
import com.imti.model.PageBean;
import com.imti.model.UserInfo;
import com.imti.service.UserInfoService;

/**@文件名: UserInfoController.java
 * @类功能说明: 用户管理控制层
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月4日下午4:16:53
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月4日下午4:16:53</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;   //引入service接口
	/**
	 * @方法名: login
	 * @方法说明: 用户管理控制层登录实现
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月4日下午4:23:26
	 * @param userInfo
	 * @param request
	 * @return: String
	 */
	@RequestMapping(value="/login")
	public String login(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String rands=request.getParameter("yzm");
		String sessionRands=(String) session.getAttribute("sRand");
		UserInfo sessionUserInfo=(UserInfo) session.getAttribute("currentUserInfo");
		if(sessionUserInfo!=null) {   //备注：如果前端传入session的参数不为空，则直接进入main界面
			return "main";
		}else {      //备注：如果前端传入session的参数为空，则执行下面语句
			if(sessionRands==null) {     //备注：如果前端传入验证码为空，则执行下面return语句（重定向到登录界面）
				return "redirect:../login.jsp";
			}else {     //备注：如果前端传入验证码不为空，则执行下面语句
				if(sessionRands.equals(rands)) {   //备注：判断前端传入的验证码和session里生成的验证码是否相同
					UserInfo resultUserInfo=userInfoService.login(userInfo);
					if(resultUserInfo!=null) {   //前端传入的参数不为空，进入main界面
						session.setAttribute("currentUserInfo", resultUserInfo);
						return "main";
					}else {   //在路径上显示返回给前端的参数
						return "redirect:../login.jsp?error=1&user_name="+userInfo.getUser_name()+"&user_pwd="+userInfo.getUser_pwd()+"&yzm="+rands;
					}
				}else {
					return "redirect:../login.jsp?error=2&user_name="+userInfo.getUser_name()+"&user_pwd="+userInfo.getUser_pwd()+"&yzm="+rands;
				}
			}
			
		}
		
	}
	/**
	 * @方法名: logout
	 * @方法说明: 登录之后退出
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日下午10:08:09
	 * @param request
	 * @return: String
	 */
	//登录之后退出
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUserInfo");
		return "redirect:../login.jsp";
	}
	
	//页面后退清理session
	@RequestMapping("/clearSession")
	@ResponseBody
	public void clearSession(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUserInfo");
	}
	
	
	//mysql分页及查询
	@RequestMapping("/findAllUserInfo")
	@ResponseBody
	public Map<String, Object> findAllUserInfo(int page,int rows,String s_userName) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("s_userName", s_userName);
		
		PageBean pageBean=new PageBean(page, rows);//顺序不能改变
		map.put("pageBean", pageBean);
		List<UserInfo> userList=userInfoService.findAllUserInfo(map);
		int total=userInfoService.findAllUserInfoCount(map);//total不能改
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", userList);
		
		return resultMap;
	}
	
	
	/*新增用户信息时判断用户是否存在*/
	@RequestMapping("/findUserNameIsExist")
	@ResponseBody
	public JSONObject findUserNameIsExist(String userName){
		JSONObject jsonObject=new JSONObject();
		int count=userInfoService.findUserNameIsExist(userName);
		if(count>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	
	/*新增用户信息*/
	@RequestMapping("/addUserInfo")
	@ResponseBody
	public JSONObject addUserInfo(UserInfo userInfo,HttpServletRequest request){
		HttpSession session=request.getSession();
		UserInfo sessionUserInfo=(UserInfo) session.getAttribute("currentUserInfo");
		userInfo.setOpt_id(sessionUserInfo.getUser_id());
		JSONObject jsonObject=new JSONObject();
		int count=userInfoService.addUserInfo(userInfo);
		if(count>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	
	
	
	/*修改用户信息*/
	@RequestMapping("/updateUserInfo")
	@ResponseBody
	public JSONObject updateUserInfo(UserInfo userInfo,HttpServletRequest request){
		JSONObject jsonObject=new JSONObject();
		int count=userInfoService.updateUserInfo(userInfo);
		if(count>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	/*删除用户信息*/
	@RequestMapping("/deleteUserInfo")
	@ResponseBody
	public JSONObject deleteUserInfo(String userIds,HttpServletRequest request){
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.deleteUserInfo(userIds);
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	
	/*增加用户所有的角色*/
	@RequestMapping("/insertUserAndRole")
	@ResponseBody
	public JSONObject insertUserAndRole(int userId,String roleIds) {
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.insertUserAndRole(userId,roleIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	
	
	
	/**
	 * @方法名: deleteUserOwerRoleByUid
	 * @方法说明:回收权限 
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日下午12:08:05
	 * @param userId
	 * @param roleIds
	 * @return: JSONObject
	 */
	
	@RequestMapping("/deleteUserOwerRoleByUid")
	@ResponseBody
	public JSONObject deleteUserOwerRoleByUid(int userId,String roleIds){
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.deleteUserOwerRoleByUid(userId,roleIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}

	
	
	
}
