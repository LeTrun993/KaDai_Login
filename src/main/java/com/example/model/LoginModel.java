package com.example.model;

import lombok.Data;

@Data
public class LoginModel {
	private int id;
	private String firstName;
	private String lastName;
	private String firstName_furigana;
	private String lastName_furigana;
	private String bday;
	private String gender;
	private String email;
	private String password;
	private String confirm_password;
	private String addres;
	private String country;
	public boolean validate() {
		
		return true;
	}
	
	
	
}
//package com.example.model;
//
//
//
//
//import lombok.Data;
//
//@Data
//public class LoginModel {
//	private int id;
//	private String firstName;
//	private String lastName;
//	private String firstName_furigana;
//	private String lastName_furigana;
//	private String bday;
//	private String gender;
//	private String email;
//	private String password;
//	private String confirm_password;
//	private String addres;
//	private String country;
//	public boolean validate() {
//		
//		return true;
//	}
////	public Object getNewPassword() {
////		// TODO 自動生成されたメソッド・スタブ
////		return null;
////	}
////	public Object getConfirmNewPassword() {
////		// TODO 自動生成されたメソッド・スタブ
////		return null;
////	}
////	public void setPassword(Object newPassword) {
////		// TODO 自動生成されたメソッド・スタブ
////		
////	}
//	
//}