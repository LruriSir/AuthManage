var addUrl="../../roleInfo/addRoleInfo.action";
var updateUrl="../../roleInfo/updateRoleInfo.action";
var currentUrl="";



/*模糊查询*/
function searchRoleInfo(){
	var s_roleName=$("#s_roleName").val();
	$("#dgRoleInfo").datagrid("load",{
		s_roleName:s_roleName
	});
}

/*点击添加按钮打开弹框*/
function openRoleInfoAddDialog(){
	$("#role_name").removeAttr("disabled",true);//移除禁用
	$("#fmRoleInfo").form("enableValidation");
	$("#dlgRoleInfo").dialog("open").dialog("setTitle","新增角色信息");
	currentUrl=addUrl;
};

/*光标移过角色名称 判断是否存在*/
$("#role_name").blur(function(){
		var roleName=$("#role_name").val();
		$.ajax({
			url:"../../roleInfo/findRoleNameIsExist.action",
			data:{roleName:roleName},
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.msg){
					$.messager.alert("系统提示","该用户名<span style='color:red,font-size:200px'>"+roleName+"</span>已存在");
					$("#role_name").val("");
				}
			}
		});
});

/*新增角色信息*/
function saveRoleInfo(){
	
	$("#fmRoleInfo").form("enableValidation");
	$("#fmRoleInfo").form("submit",{
		url:currentUrl/*"../../RoleInfo/addRoleInfo.action"*/,
		onSubmit:function(){
			var isValid=$(this).form('validate');
			return isValid;
		},
		success:function(result){
			var result=eval("("+result+")");
			if(result.msg){
				
				closeRoleInfoDialog();      // 为了代码的复用性   调用关闭和清空表单方法
				/*$("#fmRoleInfo").form("clear");
				$("#dlgRoleInfo").dialog("close");*/
				$("#dgRoleInfo").datagrid("load");
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
function closeRoleInfoDialog(){
	$("#fmRoleInfo").form("clear");
	$("#dlgRoleInfo").dialog("close");
}

/*修改角色信息*/
function openRoleInfoModifyDialog(){
	
	$("#role_name").removeAttr("disabled",true);//移除禁用
	var rows=$("#dgRoleInfo").datagrid("getSelections");
	if(rows.length!=1){
		$.messager.alert("系统提示","请选择一行需要修改的数据","error");
		return false;
	}
	currentUrl=updateUrl;
	$("#fmRoleInfo").form("disableValidation");
	$("#role_name").attr("disabled",true);
	$("#fmRoleInfo").form("load",rows[0]);
	$("#dlgRoleInfo").dialog("open").dialog("setTitle","修改用户信息");
}

/*删除用户信息*/
function deleteRoleInfo(){
	var rows=$("#dgRoleInfo").datagrid("getSelections");
	
	if(rows.length<1){
		$.messager.alert("系统提示","请至少选择一行需要删除的数据","error");
		return false;
	};
		$.messager.confirm("系统提示","您确认要删除"+rows.length+"数据吗？",function(r){
		
		if(r){
		var arrayIds=new Array();
		$.each(rows,function(index,row){
			arrayIds.push(row.role_id);
		});
		
		var roleIds=arrayIds.toString();
		$.ajax({
			url:"../../roleInfo/deleteRoleInfo.action",
		    type:"post",
		    data:{roleIds:roleIds},
		    dataType:"json",
		    success:function(result){
		    	
		    	if(result.msg){
		    		$("#dgRoleInfo").datagrid("reload");
		    		$.messager.alert("系统提示","删除成功","info");
		    	}else{
		    		$.messager.alert("系统提示","删除失败","error");
		    	}
		    }
		});
		}
		});
}

/*分配权限*/
function roleInfoMenu(){
	var rows=$("#dgRoleInfo").datagrid("getSelections"); 
	if(rows.length!=1){
		$.messager.alert("系统提示","请选择一行需要授权的角色","error");
		return false;
	}
	var roleId=rows[0].role_id;
	$.ajax({
		url:"../../menuInfo/findAllMenuInfoByRoleId.action",
	    type:"post",
	    data:{roleId:roleId},
	    dataType:"json",
	    success:function(result){
	    	$("#tree").tree({
				data:result,
				lines:true,
				checkbox:true,// 复选框
				cascadeCheck:false,// 取消级联关系
				onLoadSuccess:function(node,param){
					$("#tree").tree("expandAll");//展开所有节点
				},
				onCheck:function(node,checked){
					if(checked){                               //父节点
						var nodeParent=$("#tree").tree("getParent",node.target);
						if(nodeParent==null){
							
						}            //如果target为空，执行else
						else{
							$("#tree").tree("check",nodeParent.target);
						}
					}else{                                     //子节点
						var nodeChildrens=$("#tree").tree("getChildren",node.target);
						for(var i=0;i<nodeChildrens.length;i++){
							$("#tree").tree("uncheck",nodeChildrens[i].target);
						}
					}
				}
			});
	    	}
	});
	$("#dlgMenuInfo").dialog("open").dialog("setTitle","角色授权");
}

/*关闭按钮*/
function closeRoleAndMenuDialog(){
	$("#dlgMenuInfo").dialog("close");
}

/*授权按钮*/
function saveRoleAndMenu(){
	//显示所有节点
	var nodes=$("#tree").tree("getChecked");
	if(nodes.length==0){
		$.messager.alert("系统提示","请至少选择一个权限！","warning");
		return false;
	}
	var arrayNodes=new Array();
	$.each(nodes,function(index,node){
		arrayNodes.push(node.id);
	});
	var menuIds=arrayNodes.toString();
	
	var roleRows=$("#dgRoleInfo").datagrid("getSelections");
	var role_id=roleRows[0].role_id;
	
	$.ajax({
		url:"../../menuInfo/saveRoleAndMenu.action",
		type:"post",
		data:{role_id:role_id,menuIds:menuIds},
		dataType:"json",
		success:function(result){
			if(result.msg){
				closeRoleAndMenuDialog();//为了代码的复用性 调用关闭方法
				//$("#dgRoleInfo").datagrid("roload");
				$("#dgRoleInfo").datagrid("load");  //刷新数据
				$.messager.alert("系统提示","授权成功","info");
			}else{
				$.messager.alert("系统提示","授权失败","error");
			}
		}
	});
}