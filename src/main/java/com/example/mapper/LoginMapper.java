package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.model.LoginModel;

@Mapper
@Repository
public interface LoginMapper {
	int insert(LoginModel loginModel);
	int update(LoginModel loginModel);
//	void updatePassword(@Param("email") String email, @Param("password") String password);
	public LoginModel selectAll(LoginModel loginModel);
	public List<LoginModel> selectAllUser(LoginModel loginModel);
	List<LoginModel> showAll(LoginModel loginModel);
	LoginModel checkAccount(LoginModel loginModel);

}

//package com.example.mapper;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Repository;
//
//import com.example.model.LoginModel;
//
//@Mapper
//@Repository
//public interface LoginMapper {
//	int insert(LoginModel loginModel);
//
//	@Select("SELECT * FROM login_trun WHERE email = #{email}")
//	LoginModel getUserByEmaill( String email);
//
//	void update(LoginModel loginModel);
//}
