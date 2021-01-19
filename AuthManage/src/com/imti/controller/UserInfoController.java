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

/**@�ļ���: UserInfoController.java
 * @�๦��˵��: �û�������Ʋ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��4������4:16:53
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��4������4:16:53</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;   //����service�ӿ�
	/**
	 * @������: login
	 * @����˵��: �û�������Ʋ��¼ʵ��
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��4������4:23:26
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
		if(sessionUserInfo!=null) {   //��ע�����ǰ�˴���session�Ĳ�����Ϊ�գ���ֱ�ӽ���main����
			return "main";
		}else {      //��ע�����ǰ�˴���session�Ĳ���Ϊ�գ���ִ���������
			if(sessionRands==null) {     //��ע�����ǰ�˴�����֤��Ϊ�գ���ִ������return��䣨�ض��򵽵�¼���棩
				return "redirect:../login.jsp";
			}else {     //��ע�����ǰ�˴�����֤�벻Ϊ�գ���ִ���������
				if(sessionRands.equals(rands)) {   //��ע���ж�ǰ�˴������֤���session�����ɵ���֤���Ƿ���ͬ
					UserInfo resultUserInfo=userInfoService.login(userInfo);
					if(resultUserInfo!=null) {   //ǰ�˴���Ĳ�����Ϊ�գ�����main����
						session.setAttribute("currentUserInfo", resultUserInfo);
						return "main";
					}else {   //��·������ʾ���ظ�ǰ�˵Ĳ���
						return "redirect:../login.jsp?error=1&user_name="+userInfo.getUser_name()+"&user_pwd="+userInfo.getUser_pwd()+"&yzm="+rands;
					}
				}else {
					return "redirect:../login.jsp?error=2&user_name="+userInfo.getUser_name()+"&user_pwd="+userInfo.getUser_pwd()+"&yzm="+rands;
				}
			}
			
		}
		
	}
	/**
	 * @������: logout
	 * @����˵��: ��¼֮���˳�
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������10:08:09
	 * @param request
	 * @return: String
	 */
	//��¼֮���˳�
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUserInfo");
		return "redirect:../login.jsp";
	}
	
	//ҳ���������session
	@RequestMapping("/clearSession")
	@ResponseBody
	public void clearSession(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUserInfo");
	}
	
	
	//mysql��ҳ����ѯ
	@RequestMapping("/findAllUserInfo")
	@ResponseBody
	public Map<String, Object> findAllUserInfo(int page,int rows,String s_userName) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("s_userName", s_userName);
		
		PageBean pageBean=new PageBean(page, rows);//˳���ܸı�
		map.put("pageBean", pageBean);
		List<UserInfo> userList=userInfoService.findAllUserInfo(map);
		int total=userInfoService.findAllUserInfoCount(map);//total���ܸ�
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", userList);
		
		return resultMap;
	}
	
	
	/*�����û���Ϣʱ�ж��û��Ƿ����*/
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
	
	
	/*�����û���Ϣ*/
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
	
	
	
	
	/*�޸��û���Ϣ*/
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
	
	/*ɾ���û���Ϣ*/
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
	
	
	/*�����û����еĽ�ɫ*/
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
	 * @������: deleteUserOwerRoleByUid
	 * @����˵��:����Ȩ�� 
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������12:08:05
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
