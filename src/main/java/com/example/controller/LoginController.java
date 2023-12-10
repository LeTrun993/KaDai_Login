package com.example.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mapper.LoginMapper;
import com.example.model.LoginModel;
import com.example.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	@Resource // Inject "service"
	LoginService loginService;
	@Autowired
	LoginMapper loginMapper;
	@GetMapping("/signup")
	public String signup(Model model) {
		return "signup";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
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
		log.info("{}",loginModel);
		return "login";
	}

	
	@PostMapping("/welcome")
	public String welcome( LoginModel loginModel,Model model) {
//		log.info("Password from form: {}", loginModel.getPassword());
		LoginModel user = loginService.selectAll(loginModel);
		
		if(loginModel.getEmail().isEmpty() && loginModel.getPassword().isEmpty()) {
			model.addAttribute("error", "Emailとパスワードが入力してください");
			return "login";
		}
		if(user == null) {
			model.addAttribute("error", "Emailとパスワードが致しませんでした");
			return "login";
		}else {
			model.addAttribute("user", user);
			loginService.update(loginModel);
			log.info("{}", loginModel);
			return "welcome";
		}
	}
	//chuyen huong tu trang welcome sang confirm
	@PostMapping("/confirm")
	public String confirm(Model model, LoginModel loginModel) {
		LoginModel user = loginService.selectAll(loginModel);		
//		log.info("{}", user);
		model.addAttribute("user", user);
		return "confirm";
	}
	@PostMapping("/userList")
	public String login(LoginModel loginModel,Model model) {
		List<LoginModel> user = loginService.selectAllUser(loginModel);
		log.info("{}", user);
		model.addAttribute("user", user);
		return "userList";
	}
	//Ngay 9/12
	//Doi MK
	@GetMapping("changePass/{id}")
	public String showChangePass(@PathVariable ("id") int id, LoginModel loginModel, Model model) {
		return "changePass";
	}

	@PostMapping("/changePass")
		public String changePass(HttpServletRequest request,  LoginModel loginModel, Model model) {
	        HttpSession session = request.getSession();
	        String user = (String) session.getAttribute("userLogin");
	        loginService.update(loginModel);
	        log.info("{}",loginModel);
//	        LoginModel newUser = loginService.checkAccount(loginModel);
//	        model.addAttribute("user", newUser.getEmail());
			
	        return "confirm";
	    }
	}
	
	
	
	
	
	
//	public String changePass(HttpServletRequest request, LoginModel loginModel, Model model) {
//		HttpSession session = request.getSession();
//		String user = (String) session.getAttribute("userLogin");
//		LoginModel existingUser = LoginService.getUserByUserName(user);
//		if (existingUser != null) {
//	        // Cập nhật mật khẩu mới
//	        existingUser.setPassword(loginModel.getNewPassword());
//	        loginService.update(existingUser);
//	        
//	        // Thêm thông báo thành công vào model
//	        model.addAttribute("successMessage", "Mật khẩu đã được thay đổi thành công.");
//	    } else {
//	        // Thêm thông báo lỗi vào model nếu không tìm thấy người dùng
//	        model.addAttribute("error", "Không tìm thấy người dùng.");
//	    }
//
//	    return "changePass";
//	}
//	
	
	
	
//		loginModel.setFirstName(user);
//		loginService.update(loginModel);
//		log.info("{}",loginModel);
		
//		LoginModel newUser = loginService.checkAccount(loginModel);
//		model.addAttribute("newUser", newUser);
//		model.addAttribute("message" + newUser.getFirstName() +"よこそう");
//				return "changePass";
	
	


//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.model.LoginModel;
//import com.example.service.LoginService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Controller
//@Slf4j
//public class LoginController {
//	@Autowired
//	LoginService loginService;
//	//	@Autowired
//	//	LoginMapper loginMapper;
//
//	@GetMapping("/")
//	public String index(Model model) {
//		model.addAttribute("message", "xin chào, tôi đây!!");
//		return "index";
//	}
//
//	@GetMapping("/signup")
//	public String signup(Model model) {
//		return "signup";
//	}
//
//	@PostMapping("/login")
//	public String login(Model model, LoginModel loginModel) {
//		// Kiem tra dieu kien trong phuong thuc
//		if (!loginModel.validate()) {
//			// Ktra firstName & lastName 
//
//			// Ktra thong tin !Null
//			if (loginModel.getFirstName() == null || loginModel.getLastName() == null
//					|| loginModel.getFirstName_furigana() == null
//					|| loginModel.getLastName_furigana() == null || loginModel.getBday() == null
//					|| loginModel.getGender() == null
//					|| loginModel.getEmail() == null || loginModel.getPassword() == null
//					|| loginModel.getConfirm_password() == null
//					|| loginModel.getAddres() == null) {
//
//				model.addAttribute("error", "入力直してください");
//				return "signup";
//			}
//		}
//		loginService.insert(loginModel);
//		return "login";
//	}
//
//	@GetMapping("/welcome")
//	public String welcome() {
//		return "welcome";
//	}
//
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
//
//	@GetMapping("/js")
//	public String js() {
//		return "NewFile";
//	}
//
//	@GetMapping("/check")
//	public String check() {
//		return "ChuChinhTest";
//	}
//
//	//chuyen huong tu trang welcome sang confirm
//	@PostMapping("/confirm")
//	public String confirm(Model model, @RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String lastName,
//			@RequestParam("firstName_furigana") String firstName_furigana,
//			@RequestParam("lastName_furigana") String lastName_furigana,
//			@RequestParam("bday") String bday,
//			@RequestParam("gender") String gender,
//			@RequestParam("email") String email,
//			@RequestParam("password") String password,
//			@RequestParam("addres") String addres,
//			@RequestParam("country") String country) {
//		LoginModel user = new LoginModel();
//		user.setFirstName(firstName);
//		user.setLastName(lastName);
//		user.setFirstName_furigana(firstName_furigana);
//		user.setLastName_furigana(lastName_furigana);
//		user.setBday(bday);
//		user.setGender(gender);
//		user.setEmail(email);
//		user.setPassword(password);
//		user.setAddres(addres);
//		user.setCountry(country);
//
//		model.addAttribute("user", user);
//
//		return "confirm";
//	}
//		
//	@PostMapping("/welcome")
//	public String welcome(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
//		// Ktra gia tri null
//		if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
//			//Thong bao loi
//			model.addAttribute("error", "Emailとパスワードが必要");
//			return "login";
//		}
//		//Ktra thong tin dang nhap
//		if (loginService.authenticate(email, password)) {
//			// Lay thong tin user tu DB
//			LoginModel user = loginService.getUserByEmail(email);
//			//Lay thong tin in ra man hinh
//			model.addAttribute("username", user.getFirstName());
//			// Them thong tin nguoi dung vao Model
//			model.addAttribute("user", user);
//			return "welcome";
//		} else {
//			model.addAttribute("fal", "Emailまたはパスワードが正しくない");
//			return "login";
//		}
//
//	}
//
//		@PostMapping("/welcome")
//		public String welcome(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
//			// Ktra gia tri null
//			if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
//				//Thong bao loi
//				model.addAttribute("error", "Emailとパスワードが必要");
//				return "login";
//			}
//			if (loginService.authenticate(email, password)) {
//				//Ktra thong tin dang nhap
//				if(loginService == null) {
//					log.error("ok");
//					model.addAttribute("error", "サーバーが混んでいる");
//					return "login";
//				}
//				// Lay thong tin user tu DB
//				LoginModel user = loginService.getUserByEmail(email);
//				//Lay thong tin nguoi dung vao model de hien thi o trang welcome
//				//model.addAttribute("user", user);
//				model.addAttribute("welcomeMessage", "よこそう" + user.getFirstName());
//				return "welcome";
//			} else {
//				model.addAttribute("fal", "Emailまたはパスワードが正しくない");
//				return "login";
//			}
//	
//		}
//		}
//	
//
//	@GetMapping("/changePass")
//	public String changePass() {
//		return "changePass";
//	}
//	//	@PostMapping("/changePass")
//	//	public String changePass(@ModelAttribute("loginModel") LoginModel loginModel, Model model) {
//	//	    // Kiểm tra mật khẩu hiện tại có đúng không
//	//	    
//	//	    if (userFromDB == null) {
//	//	        model.addAttribute("error", "Mật khẩu hiện tại không đúng");
//	//	        return "changePass";
//	//	    }
//	//
//	//	    // Kiểm tra mật khẩu mới và xác nhận mật khẩu mới
//	//	    if (!loginModel.getNewPassword().equals(loginModel.getConfirmNewPassword())) {
//	//	        model.addAttribute("error", "Mật khẩu mới và xác nhận mật khẩu mới không khớp");
//	//	        return "changePass";
//	//	    }
//	//
//	//	    // Update mật khẩu mới
//	//	    userFromDB.setPassword(loginModel.getNewPassword());
//	//	    loginService.update(userFromDB);
//	//
//	//	    // Chuyển hướng hoặc trả về khi thành công
//	//	    return "redirect:/welcome";
//	//	}
//
//}