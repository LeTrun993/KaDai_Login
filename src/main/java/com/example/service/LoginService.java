package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.LoginModel;

@Service
public interface LoginService {
	public int insert(LoginModel loginModel);

	public boolean authenticate(String email, String password);

	public LoginModel getUserByEmail(String email);

}
