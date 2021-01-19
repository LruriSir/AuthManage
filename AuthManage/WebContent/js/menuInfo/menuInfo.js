var addUrl="../../menuInfo/addMenuInfo.action";
var updateUrl="../../menuInfo/updateMenuInfo.action";
var currentUrl="";

/*图标显示*/
function formatterIcon(value,row,index){
	return "<div class='"+value+"'>&nbsp;</div>";
}


/*添加弹框*/
function openMenuInfoAddDialog(){
	var node=$("#treeGridMenuInfo").treegrid("getSelected");
	if(node==null){
		$.messager.alert("系统提示","请选择一行需要添加的父节点","warning");
		return false;
	}
	$("#parentId").val(node.menu_id);
	$("#dlgMenuInfo").dialog("open").dialog("setTitle","添加菜单信息");
	currentUrl=addUrl;
}


/*添加功能*/
function saveMenuInfo(){
	//$("#fmMenuInfo").form("enableValidation");//启用验证
	$("#fmMenuInfo").form("submit",{
		url:currentUrl,
		onSubmit:function(){
			var isValid=$(this).form('validate');
			return isValid;
		},
		success:function(result){
			var result=eval("("+result+")");
			if(result.msg){
				closeMenuInfoDialog();
				$("#treeGridMenuInfo").treegrid("load");			//保存完成后刷新列表
				$.messager.alert("系统提示","保存成功","info");
			}else{ 
				$.messager.alert("系统提示","保存失败","error");
			}
		},
		error:function(){
			$.messager.alert("系统提示","系统繁忙，请稍后操作","error");
		}
	});
	currentUrl="";
}

/*关闭*/
function closeMenuInfoDialog(){
	$("#fmMenuInfo").form("clear");
	$("#dlgMenuInfo").dialog("close");
}


/*修改菜单信息*/
function openMenuInfoModifyDialog(){
	$("#fmMenuInfo").form("enableValidation");//启用验证
	//$("#menu_name").removeAttr("disabled",true);//移除禁用
	var rows=$("#treeGridMenuInfo").treegrid("getSelections");
	if(rows.length!=1){
		$.messager.alert("系统提示","请选择一行需要修改的数据","warning");
		return false;
	}
	//$("#parentId").val(node.menu_id);
	currentUrl=updateUrl;
	//$("#fmMenuInfo").form("disableValidation");//禁用验证
	//$("#menu_name").attr("disabled",true);//菜单名字不可修改
	$("#fmMenuInfo").form("load",rows[0]);
	$("#dlgMenuInfo").dialog("open").dialog("setTitle","修改菜单信息");
}


/*删除菜单信息*/
function deleteMenuInfo(){
	var rows=$("#treeGridMenuInfo").treegrid("getChecked");

	for(var i=0;i<rows.length;i++){
	    var nodes=$("#treeGridMenuInfo").treegrid("getChildren",rows[i].menu_id);
	    if(nodes.length>0){  //直接删除父节点
	    	$.messager.confirm("系统提示","你选择的节点不是子节点,您确认要删除"+rows.length+"数据吗？",function(r){
	    		if(r){
	    			var arrayIds=new Array();
	    			$.each(rows,function(index,row){
	    				arrayIds.push(row.menu_id);//想controller传入row数组里的Id
	    			});
	    			var menuId=arrayIds.toString();
	    			$.ajax({
	    				url:"../../menuInfo/deleteMenuInfo.action",
	    				type:"post",
	    				data:{menuId:menuId},
	    				dataType:"json",
	    				success:function(result){
	    					if(result.msg){
	    						$("#treeGridMenuInfo").treegrid("load");
	    						$.messager.alert("系统提示","删除成功","info");
	    					}else{
	    						$.messager.alert("系统提示","删除失败","error");
	    					}
	    				}
	    			});
	    		}
	    	});
	    }else{ //先删除子节点
	    	$.messager.confirm("系统提示","您确认要删除"+rows.length+"数据吗？",function(r){
	    		if(r){
	    			
	    			var arrayIds=new Array();
	    			$.each(rows,function(index,row){
	    				arrayIds.push(row.menu_id);//想controller传入row数组里的Id
	    			});
	    			var menuId=arrayIds.toString();
	    			$.ajax({
	    				url:"../../menuInfo/deleteMenuInfo.action",
	    				type:"post",
	    				data:{menuId:menuId},
	    				dataType:"json",
	    				success:function(result){
	    					
	    					if(result.msg){
	    						$("#treeGridMenuInfo").treegrid("load");
	    						$.messager.alert("系统提示","删除成功","info");
	    					}else{
	    						$.messager.alert("系统提示","删除失败","error");
	    					}
	    				}
	    			});
	    		}
	    	});
	    }
	};
	
}
