package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.LoginModel;

@Service
public interface LoginService {
	public int insert(LoginModel loginModel);
	public void updatePassword(LoginModel loginModel);
	public int delete(LoginModel loginModel);
	public LoginModel selectAll(LoginModel loginModel);
	public List<LoginModel> selectAllUser(LoginModel loginModel);
	public void checkPass(LoginModel loginModel);
	public LoginModel checkAccount(LoginModel loginModel);
	public LoginModel findById(int id);
	
	public static LoginModel getUserByUserName(String user) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public List<LoginModel> showAll(LoginModel loginModel);
	public LoginModel selectPass(LoginModel loginModel);
	public LoginModel getUserByEmail(String email);
	public int update(LoginModel loginModel);
	
	}
	


//package com.example.service;
//
//import org.springframework.stereotype.Service;
//
//import com.example.model.LoginModel;
//
//@Service
//public interface LoginService {
//	public int insert(LoginModel loginModel);
//
//	boolean authenticate(String email, String password);
//
//	LoginModel getUserByEmail(String email);
//	
//	public void update(LoginModel loginModel) ;
//
//	public String someMethod();
//
//	public LoginModel checkLogin(String email, String password);
//
//	public LoginModel selectAll(LoginModel loginModel);
//	}
//
//
