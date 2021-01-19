package com.imti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.imti.model.MenuInfo;
import com.imti.model.UserInfo;
import com.imti.service.MenuInfoService;

/**@�ļ���: MenuInfoController.java
 * @�๦��˵��: �˵�������Ʋ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��5������1:09:33
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��5������1:09:33</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Controller
@RequestMapping("menuInfo")
public class MenuInfoController {

	@Autowired
	private MenuInfoService menuInfoService;   //����MenuInfoService�ӿ�
	
	/**
	 * @������: findMenuInfoByParentId
	 * @����˵��: �˵�������Ʋ��¼ʵ��
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��5������1:18:16
	 * @return
	 * @return: JSONArray
	 */
	@RequestMapping("findMenuInfoByParentId")
	@ResponseBody                  //��������ͼ������
	public JSONArray findMenuInfoByParentId(HttpServletRequest request) {
		int parentId=-1;
		HttpSession session=request.getSession();
		UserInfo userInfoSession=(UserInfo) session.getAttribute("currentUserInfo");
		//�ٴδ�Session�л�ȡcurrentUserInfo��ȫ����Ϣ���ٻ�ȡUser_id()
		List<String> menuIds=menuInfoService.getCurrentUserOwerMenus(userInfoSession.getUser_id());
		
		//��Controller�㴫����������
		return menuInfoService.findMenuInfoByParentId(parentId,menuIds);
	}
	
	/**
	 * @������: findAllMenuInfoByRoleId
	 * @����˵��: �˵������ѯ����
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������10:06:03
	 * @param roleId
	 * @return: JSONArray
	 */
	@RequestMapping("/findAllMenuInfoByRoleId")
	@ResponseBody
	public JSONArray findAllMenuInfoByRoleId(int roleId) {
		int parentId=-1;
		return menuInfoService.findAllMenuInfoByRoleId(parentId,roleId);
		
	}
	
	/**
	 * @������: saveRoleAndMenu
	 * @����˵��: ��Ȩ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��12������10:06:33
	 * @param role_id
	 * @param menuIds
	 * @return: JSONObject
	 */
	@RequestMapping("/saveRoleAndMenu")
	@ResponseBody
	public JSONObject saveRoleAndMenu(int role_id,String menuIds) {
		JSONObject jsonObject=new JSONObject();
		int result=menuInfoService.saveRoleAndMenu(role_id,menuIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	
	
	/*--------------------------------------------�˵������б�--------------------------------------------------------*/
	
	
	
	
	/**
	 * @������: findAllMenuInfo
	 * @����˵��: �˵�������ʾController
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������9:36:26
	 * @return: List<MenuInfo>
	 */
	@RequestMapping("/findAllMenuInfo")
	@ResponseBody
	public JSONArray findAllMenuInfo(){
		int parentId=-1;
		return menuInfoService.findAllMenuInfo(parentId);
	}
	
	
	/**
	 * @������: addMenuInfo
	 * @����˵��: ��Ӳ˵���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������10:25:05
	 * @param menuInfo
	 * @param request
	 * @return
	 * @return: JSONObject
	 */
	@RequestMapping("/addMenuInfo")
	@ResponseBody
	public JSONObject addMenuInfo(MenuInfo menuInfo,HttpServletRequest request) {
		JSONObject jsonObject=new JSONObject();
		HttpSession session=request.getSession();
		UserInfo userInfo=(UserInfo) session.getAttribute("currentUserInfo");
		menuInfo.setOpt_id(userInfo.getUser_id());
		int result=menuInfoService.addMenuInfo(menuInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	/**
	 * @������: updateMenuInfo
	 * @����˵��: �޸Ĳ˵���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������5:15:18
	 * @param menuInfo
	 * @param request
	 * @return: JSONObject
	 */
	@RequestMapping("/updateMenuInfo")
	@ResponseBody
	public JSONObject updateMenuInfo(MenuInfo menuInfo,HttpServletRequest request){
		JSONObject jsonObject=new JSONObject();
		int result=menuInfoService.updateMenuInfo(menuInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	/**
	 * @������: deleteUserInfo
	 * @����˵��: ɾ���˵���Ϣ
	 * @����: BaiYunZhong
	 * @���䣺2537975653@qq.com
	 * @����: 2021��1��13������8:46:09
	 * @param userIds
	 * @param request
	 * @return: JSONObject
	 */
	@RequestMapping("/deleteMenuInfo")
	@ResponseBody
	public JSONObject deleteMenuInfo(String menuId,HttpServletRequest request){
		JSONObject jsonObject=new JSONObject();
		int result=menuInfoService.deleteMenuInfo(menuId);
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
}
