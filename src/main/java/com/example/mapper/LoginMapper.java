package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.model.LoginModel;

@Mapper
@Repository
public interface LoginMapper {
	int insert(LoginModel loginModel);

	@Select("SELECT * FROM login_trun WHERE email = #{email}")
	LoginModel getUserByEmaill( String email);
}
