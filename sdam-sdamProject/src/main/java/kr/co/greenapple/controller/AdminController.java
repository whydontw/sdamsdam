package kr.co.greenapple.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenapple.beans.BookBean;
import kr.co.greenapple.beans.UserBean;
import kr.co.greenapple.pager.Pager;
import kr.co.greenapple.service.AdminService;
import kr.co.greenapple.service.BookService;
import kr.co.greenapple.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@Resource(name = "bookBean")
	@Lazy
	private BookBean bookBean;
	
	
	//admin user List 출력
	@GetMapping("/user")
	public String getAdminUserList(Pager userPager, Model model) {
		
		List<UserBean> userInfoList = adminService.getAdminUserList(userPager);
		model.addAttribute("adminUserList", userInfoList);
		
		return "admin/user";
	}
	
	
	//admin user 삭제
	@GetMapping("/userdelete")
	public String AdmindeleteUser(@RequestParam("user_idx") int user_idx, Model model) {
		
		adminService.AdmindeleteUser(user_idx);
		model.addAttribute(user_idx);
		
		return "admin/user_delete";
	}
	
	
	//admin 예약 List 출력
	@GetMapping("/book")
	public String getAdminUserBook(Pager bookPager, Model model) {
		
		List<BookBean> userBookList = adminService.getAdminUserBook(bookPager);
		model.addAttribute("userBookList", userBookList);
		
		return "admin/book";
	}
	
	//admin 예약 승인
	@GetMapping("/bookallow")
	public String adminUserBookAllow(@RequestParam("service_idx") int service_idx, Model model) {
		
		adminService.adminUserBookAllow(service_idx);
		
		return "admin/book_allow";
	}
	
	//admin 예약 반려
	@GetMapping("/booknotallow")
	public String adminUserBookNotAllow(@RequestParam("service_idx") int service_idx, Model model) {
		
		adminService.adminUserBookNotAllow(service_idx);
		
		return "admin/book_not_allow";
	}
}
