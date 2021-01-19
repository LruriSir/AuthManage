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

/**@文件名: MenuInfoController.java
 * @类功能说明: 菜单管理控制层
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月5日下午1:09:33
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月5日下午1:09:33</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("menuInfo")
public class MenuInfoController {

	@Autowired
	private MenuInfoService menuInfoService;   //引入MenuInfoService接口
	
	/**
	 * @方法名: findMenuInfoByParentId
	 * @方法说明: 菜单管理控制层登录实现
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月5日下午1:18:16
	 * @return
	 * @return: JSONArray
	 */
	@RequestMapping("findMenuInfoByParentId")
	@ResponseBody                  //不进入视图解析层
	public JSONArray findMenuInfoByParentId(HttpServletRequest request) {
		int parentId=-1;
		HttpSession session=request.getSession();
		UserInfo userInfoSession=(UserInfo) session.getAttribute("currentUserInfo");
		//再次从Session中获取currentUserInfo的全部信息，再获取User_id()
		List<String> menuIds=menuInfoService.getCurrentUserOwerMenus(userInfoSession.getUser_id());
		
		//向Controller层传入俩个参数
		return menuInfoService.findMenuInfoByParentId(parentId,menuIds);
	}
	
	/**
	 * @方法名: findAllMenuInfoByRoleId
	 * @方法说明: 菜单管理查询所有
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午10:06:03
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
	 * @方法名: saveRoleAndMenu
	 * @方法说明: 授权
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月12日上午10:06:33
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
	
	
	
	/*--------------------------------------------菜单管理列表--------------------------------------------------------*/
	
	
	
	
	/**
	 * @方法名: findAllMenuInfo
	 * @方法说明: 菜单树形显示Controller
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日上午9:36:26
	 * @return: List<MenuInfo>
	 */
	@RequestMapping("/findAllMenuInfo")
	@ResponseBody
	public JSONArray findAllMenuInfo(){
		int parentId=-1;
		return menuInfoService.findAllMenuInfo(parentId);
	}
	
	
	/**
	 * @方法名: addMenuInfo
	 * @方法说明: 添加菜单信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日上午10:25:05
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
	 * @方法名: updateMenuInfo
	 * @方法说明: 修改菜单信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日下午5:15:18
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
	 * @方法名: deleteUserInfo
	 * @方法说明: 删除菜单信息
	 * @作者: BaiYunZhong
	 * @邮箱：2537975653@qq.com
	 * @日期: 2021年1月13日下午8:46:09
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
