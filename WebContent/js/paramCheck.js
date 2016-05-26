/*
 * 控件输入值校验
 * 
 */
 
/*
 * 手机号校验
 * 1、数值；2、长度为11位
 */
function checkPhone(id){
		var obj = document.getElementById(id);
		if(obj.value != "" && (!/^[0-9]*$/.test(obj.value) || !/^\d{11}$/.test(obj.value))){
			alert("请输入正确手机号！");
			obj.focus();
			
		}
	}

/*
 * email校验
 */
function checkEmail(id){
	var obj = document.getElementById(id);
	if(obj.value != "" && (!/^\w+[-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(obj.value))){
		alert("请输入正确的email地址！");
		obj.focus();
	}
}

//校验金额
function checkMoney(id){
	var obj = document.getElementById(id);
	if(obj.value != "" && !/^\d+(\.\d+)?$/.test(obj.value)){
		alert("请输入正确的金额！");
		obj.focus();
	}
}