package com.example.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.LoginMapper;
import com.example.model.LoginModel;
import com.example.service.LoginService;

@Service
public class LoginImpl implements LoginService {

	@Autowired
	LoginMapper mapper;

	@Override
	public int insert(LoginModel loginModel) {

		return mapper.insert(loginModel);
	}
	@Override
	public LoginModel selectAll(LoginModel loginModel) {
		return mapper.selectAll(loginModel);
	}

	@Override
	public void checkPass(LoginModel loginModel) {
		// TODO 自動生成されたメソッド・スタブ
		
	}


	@Override
	public void updatePassword(LoginModel loginModel) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public LoginModel findById(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int delete(LoginModel loginModel) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
	@Override
	public int update(LoginModel loginModel) {
		return mapper.update(loginModel);
		
	}
	@Override
	public List<LoginModel> selectAllUser(LoginModel loginModel) {
		return mapper.selectAllUser(loginModel);
	}
	@Override
	public LoginModel checkAccount(LoginModel loginModel) {
		return mapper.checkAccount(loginModel);
	}
	@Override
	public List<LoginModel> showAll(LoginModel loginModel) {
		return mapper.showAll(loginModel);
		
	}
	@Override
	public LoginModel selectPass(LoginModel loginModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	@Override
	public LoginModel getUserByEmail(String email) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	@Override
	public LoginModel findById(int id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	

	
}



//package com.example.Impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.mapper.LoginMapper;
//import com.example.model.LoginModel;
//import com.example.service.LoginService;
//
//@Service
//public class LoginImpl implements LoginService {
//
//	@Autowired
//	private LoginMapper loginMapper;
//
//	@Override
//	public int insert(LoginModel loginModel) {
//
//		return loginMapper.insert(loginModel);
//	}
//
//	@Override
//	public boolean authenticate(String email, String password) {
//		// Lay thong tin nguoi dung tu postgres bang Email
//		LoginModel user = loginMapper.getUserByEmaill(email);
//
//		// kiem tra password
//		return user != null && user.getPassword().equals(password);
//
//	}
//
//	@Override
//	public LoginModel getUserByEmail(String email) {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
//
//	@Override
//	public void update(LoginModel loginModel) {
//		// TODO 自動生成されたメソッド・スタブ
//		
//	}
//
//	@Override
//	public String someMethod() {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
//
//	@Override
//	public LoginModel checkLogin(String email, String password) {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
//
//	@Override
//	public LoginModel selectAll(LoginModel loginModel) {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
//
//
//
//
////	@Override
////	//Khai bao getUserEmail
////	public LoginModel getUserByEmail(String email) {
////
////		return mapper.getUserByEmaill(email);
////	}
////
////	@Override
////	public void update(LoginModel loginModel) {
////		// TODO 自動生成されたメソッド・スタブ
////		
////	}
//
//	
//
//	
//}
