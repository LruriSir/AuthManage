var addUrl="../../userInfo/addUserInfo.action";
var updateUrl="../../userInfo/updateUserInfo.action";
var currentUrl="";



/*模糊查询*/
function searchUserInfo(){
	var s_userName=$("#s_userName").val();
	$("#dgUserInfo").datagrid("load",{
		s_userName:s_userName
	});
}

/*点击添加按钮打开弹框*/
function openUserInfoAddDialog(){
	$("#user_name").removeAttr("disabled",true);//移除禁用
	$("#fmUserInfo").form("enableValidation");
	$("#dlgUserInfo").dialog("open").dialog("setTitle","新增用户信息");
	currentUrl=addUrl;
};

/*光标移过用户名 判断是否存在*/
$("#user_name").blur(function(){
		var userName=$("#user_name").val();
		$.ajax({
			url:"../../userInfo/findUserNameIsExist.action",
			data:{userName:userName},
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.msg){
					$.messager.alert("系统提示","该用户名<span style='color:red,font-size:200px'>"+userName+"</span>已存在");
					$("#user_name").val("");
				}
			}
		});
});

/*新增用户信息*/
function saveUserInfo(){
	
	$("#fmUserInfo").form("enableValidation");
	$("#fmUserInfo").form("submit",{
		url:currentUrl/*"../../userInfo/addUserInfo.action"*/,
		onSubmit:function(){
			var isValid=$(this).form('validate');
			return isValid;
		},
		success:function(result){
			var result=eval("("+result+")");
			if(result.msg){
				
				closeUserInfoDialog();      // 为了代码的复用性   调用关闭和清空表单方法
				/*$("#fmUserInfo").form("clear");
				$("#dlgUserInfo").dialog("close");*/
				$("#dgUserInfo").datagrid("load");
				$.messager.alert("系统提示","保存成功","info");
			}else{ 
				$.messager.alert("系统提示","保存失败","error");
			}
		},
		error:function(){
			$.messager.alert("系统提示","系统繁忙，清稍后操作","error");
		}
	});
	currentUrl="";
}


/*关闭清空表单方法*/
function closeUserInfoDialog(){
	$("#fmUserInfo").form("clear");
	$("#dlgUserInfo").dialog("close");
}

/*修改用户信息*/
function openUserInfoModifyDialog(){
	
	$("#user_name").removeAttr("disabled",true);//移除禁用
	var rows=$("#dgUserInfo").datagrid("getSelections");
	if(rows.length!=1){
		$.messager.alert("系统提示","请选择一行需要修改的数据","error");
		return false;
	}
	currentUrl=updateUrl;
	$("#fmUserInfo").form("disableValidation");
	$("#user_name").attr("disabled",true);
	$("#fmUserInfo").form("load",rows[0]);
	$("#dlgUserInfo").dialog("open").dialog("setTitle","修改用户信息");
}

/*删除用户信息*/
function deleteUserInfo(){
	var rows=$("#dgUserInfo").datagrid("getSelections");//选中多行需要删除的数据
	var roleRows=$("#dgRoleInfo").datagrid("getSelections"); 
	//if(roleRows.role_id==""){
		if(rows.length<1){
			$.messager.alert("系统提示","请至少选择一行需要删除的数据","error");
			return false;
		};
			$.messager.confirm("系统提示","您确认要删除"+rows.length+"数据吗？",function(r){
			if(r){
			var arrayIds=new Array();
			$.each(rows,function(index,row){
				arrayIds.push(row.user_id);//想controller传入row数组里的Id
			});
			var userIds=arrayIds.toString();
			$.ajax({
				url:"../../userInfo/deleteUserInfo.action",
			    type:"post",
			    data:{userIds:userIds},
			    dataType:"json",
			    success:function(result){
			    	
			    	if(result.msg){
			    		$("#dgUserInfo").datagrid("reload");
			    		$.messager.alert("系统提示","删除成功","info");
			    	}else{
			    		$.messager.alert("系统提示","删除失败","error");
			    	}
			    }
			});
			}
			});
	/*}else{
		$.messager.alert("系统提示","请先回收权限","error");
	}*/
	
	
}

/*分配角色*/
function userInfoRole(){
	var rows=$("#dgUserInfo").datagrid("getSelections"); 
	if(rows.length!=1){
		$.messager.alert("系统提示","请选择一行需要授权的用户","error");
		return false;
	}
	$.ajax({
		url:"../../roleInfo/findAllRoleInfoToUser.action",
	    type:"post",
	    data:{user_id:rows[0].user_id},
	    dataType:"json",
	    success:function(result){
	    	
	    		$("#dgRoleInfo").datagrid({
	    			onLoadSuccess:function(data){
	    				$.each(data.rows,function(index,row){
	    					if(row.checked){
	    						$("#dgRoleInfo").datagrid("selectRow",index);
	    					}
	    				});
	    			},
	    			data:result.rows
	    		});
	    }
	});
	$("#dlgRoleInfo").dialog("open").dialog("setTitle","用户授权");
}


function searchRoleInfo(){
	var s_roleName=$("#s_roleName").val();
	$("#dgRoleInfo").datagrid("load",{
		s_roleName:s_roleName
	});
}

   /*授权给用户*/
function saveUserAndRole(){
	var roleRows=$("#dgRoleInfo").datagrid("getSelections"); 
	if(roleRows.length<1){
		$.messager.alert("系统提示","请选择一个角色授权给用户","error");
		return false;
	}
	
	var userRow=$("#dgUserInfo").datagrid("getSelected");
	//var roleRows=$("#dgRoleInfo").datagrid("getSelections");
	var userId=userRow.user_id;
	var roleIdArrays=new Array();
	$.each(roleRows,function(index,row){
		roleIdArrays.push(row.role_id);
	});
	
	var roleIds=roleIdArrays.toString();
	
	$.ajax({
		url:"../../userInfo/insertUserAndRole.action",
	    type:"post",
	    data:{userId:userId,roleIds:roleIds},
	    dataType:"json",
	    success:function(result){
	    	if(result.msg){
	    		
	    		$("#dgUserInfo").datagrid("reload");//刷新数据
	    		$("#dlgRoleInfo").dialog("close");//关闭
	    		$.messager.alert("系统提示","授权成功","info");
	    	}else{
	    		$.messager.alert("系统提示","授权失败","error");
	    	}
	    },
	    error:function(){
			$.messager.alert("系统提示","系统繁忙，清稍后操作","error");
		}
	});
}
/*回收权限*/
function deleteUserOwerRoleByUid(){
	var rows=$("#dgUserInfo").datagrid("getSelected");//选中多行需要删除的数据
	var roleRows=$("#dgRoleInfo").datagrid("getSelections");
	var userId=rows.user_id;
	
	
	//if(roleRows.role_id==""){
		if(roleRows.length==0){
			$.messager.alert("系统提示","您确定要回收权限吗？","warning");
			return false;
		};
			$.messager.confirm("系统提示","您确认要回收"+roleRows.length+"条权限吗？",function(r){
			if(r){
			var arrayIds=new Array();
			$.each(roleRows,function(index,row){
				arrayIds.push(row.role_id);//想controller传入row数组里的Id
			});
			
			var roleIds=arrayIds.toString();
			
			
			$.ajax({
				url:"../../userInfo/deleteUserOwerRoleByUid.action",
			    type:"post",
			    data:{roleIds:roleIds,userId:userId},
			    dataType:"json",
			    success:function(result){
			    	
			    	if(result.msg){
			    		closeUserAndRoleDialog();
			    		$("#dgUserInfo").datagrid("load");//刷新数据
			    		$.messager.alert("系统提示","回收成功","info");
			    	}else{
			    		$.messager.alert("系统提示","回收失败","error");
			    	}
			    }
			});
			}
			});
	/*}else{
		$.messager.alert("系统提示","请先回收权限","error");
	}*/
	
}	




function closeUserAndRoleDialog(){
	$("#dlgRoleInfo").dialog("close");
}