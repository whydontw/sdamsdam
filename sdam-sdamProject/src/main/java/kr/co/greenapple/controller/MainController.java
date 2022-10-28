package kr.co.greenapple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenapple.service.TopMenuService;

@Controller
public class MainController {
	
//	@Autowired
//	private MainService mainService;
	
	@Autowired
	private TopMenuService topMenuService;

	@GetMapping("/main")
	public String main(Model model) {
		
//		ArrayList<List<ContentBean>> list = new ArrayList<List<ContentBean>>();
//		
//		for(int i=1; i<=4; i++) {
//			List<ContentBean> list1 = mainService.getMainList(i);
//			list.add(list1);
//		}
//		
//		model.addAttribute("list", list);
//		
//		List<BoardInfoBean> board_list = topMenuService.getTopMenuList();
//		model.addAttribute("board_list", board_list);
		
		return "main";
	}
	
	@PostMapping("/book")
	public String mainbook(@RequestParam String company_local) {
		
		return "book/book";
	}

}
