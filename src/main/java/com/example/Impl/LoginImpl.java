package com.example.Impl;

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
	public boolean authenticate(String email, String password) {
		// Lay thong tin nguoi dung tu postgres bang Email
		LoginModel user = mapper.getUserByEmaill(email);

		// kiem tra password
		return user != null && user.getPassword().equals(password);

	}

	@Override
	//Khai bao getUserEmail
	public LoginModel getUserByEmail(String email) {

		return mapper.getUserByEmaill(email);
	}
}
