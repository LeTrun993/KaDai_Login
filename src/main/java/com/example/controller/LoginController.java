package com.example.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.LoginModel;
import com.example.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	@Resource
	LoginService loginService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "xin chào, tôi đây!!");
		return "index";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		return "signup";
	}

	@PostMapping("/login")
	public String login(Model model, LoginModel loginModel) {
		// Kiem tra dieu kien trong phuong thuc
		if (!loginModel.validate()) {
			// Ktra firstName & lastName 

			// Ktra thong tin !Null
			if (loginModel.getFirstName() == null || loginModel.getLastName() == null
					|| loginModel.getFirstName_furigana() == null
					|| loginModel.getLastName_furigana() == null || loginModel.getBday() == null
					|| loginModel.getGender() == null
					|| loginModel.getEmail() == null || loginModel.getPassword() == null
					|| loginModel.getConfirm_password() == null
					|| loginModel.getAddres() == null) {

				model.addAttribute("error", "入力直してください");
				return "signup";
			}

		}

		loginService.insert(loginModel);
		return "login";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	//chuyen huong tu trang welcome sang confirm
	@PostMapping("/confirm")
	public String confirm(Model model, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("firstName_furigana") String firstName_furigana,
			@RequestParam("lastName_furigana") String lastName_furigana,
			@RequestParam("bday") String bday,
			@RequestParam("gender") String gender,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("addres") String addres,
			@RequestParam("country") String country) {
		LoginModel user = new LoginModel();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setFirstName_furigana(firstName_furigana);
		user.setLastName_furigana(lastName_furigana);
		user.setBday(bday);
		user.setGender(gender);
		user.setEmail(email);
		user.setPassword(password);
		user.setAddres(addres);
		user.setCountry(country);

		model.addAttribute("user", user);

		return "confirm";
	}

	@PostMapping("/welcome")
	public String welcome(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {

		// Ktra gia tri null
		if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
			//Thong bao loi
			model.addAttribute("error", "Emailとパスワードが必要");
			return "login";
		}

		//Ktra thong tin dang nhap
		if (loginService.authenticate(email, password)) {
			// Lay thong tin user tu DB
			LoginModel user = loginService.getUserByEmail(email);
			//Lay thong tin in ra man hinh
			model.addAttribute("username", user.getFirstName());
			// Them thong tin nguoi dung vao Model
			model.addAttribute("user", user);
			return "welcome";
		} else {
			model.addAttribute("fal", "Emailまたはパスワードが正しくない");
			return "login";
		}

	}

}