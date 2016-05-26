package com.aiyaya.struts;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import com.yjm.service.UserLoginService;
import com.aiyaya.domain.UserInfo;
import com.aiyaya.service.LoginService;

public class MyAction extends ActionSupport {

	private static final long serialVersionUID = 123465789L;
	private static String FORWARD = null;
	private UserInfo userInfo;
	private LoginService loginService;
	
	public String execute(){
		String username = userInfo.getUsername();
		String password = userInfo.getPassword();
		
		if(null != username && !username.equals("") && null != password && !password.equals("")){
			boolean loginLegal = false;
			try{
				/*if(username.equals("admin") && password.equals("admin")){
					loginLegal = true;
				}*/
				String passwordFromDB = loginService.queryPasswordByUsername(username);
				if(passwordFromDB.equals(password)){
					loginLegal = true;
				}else{
					loginLegal = false;
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			if(loginLegal){
				FORWARD = "success";
				Map<String,Object> session = (Map<String,Object>)ActionContext.getContext().getSession();
				session.put("username", username);
			}else{
				FORWARD = "login";
			}
			
		}else{
			FORWARD = "login";
		}
		return FORWARD;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
