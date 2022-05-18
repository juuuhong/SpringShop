package com.spring.shop.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.shop.login.dto.UserDTO;
import com.spring.shop.login.service.DefaultUserService;
import com.spring.shop.login.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private DefaultUserService defaultUserService;
	
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String loginHome(Model m) {
		m.addAttribute("content","login.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/signUp" , method = RequestMethod.GET)
	public String signUpHome(Model m) {
		m.addAttribute("content","signUp.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/signUpPro", method = RequestMethod.POST)
	public String insertUser(UserDTO dto, Model m) {
		if(dto.getSufAddr() == null && dto.getSufAddr().equals("")) {
			dto.setSufAddr("*");
		}
		int result = defaultUserService.insertUser(dto);
		if(result > 0) {
			m.addAttribute("MSG", "회원가입 축하");
			m.addAttribute("content", "login.jsp");
		}else {
			m.addAttribute("MSG", "회원가입 실패");
			m.addAttribute("content","signUp.jsp");
		}
		return "home";
	}
	
	@RequestMapping(value="/loginPro", method = RequestMethod.POST)
	public String login(UserDTO dto, Model m, HttpSession session) {
		dto = defaultUserService.login(dto);
		if(dto != null) {
			String[] addr = dto.getAddr().split("!");
			dto.setPreAddr(addr[0]);
			System.out.println(dto.getPreAddr());
			if(!addr[1].equals("*")) {
				dto.setSufAddr(addr[1]);
				System.out.println("addr[1]이 *이 아님"+dto.getSufAddr());
			}
			m.addAttribute("MSG","로그인 성공");
			m.addAttribute("content", "main.jsp");
			session.setAttribute("loginUser", dto);
			System.out.println("로그인 Controller 세션정보확인 : " +session.getAttribute("loginUser"));
			UserDTO user = (UserDTO) session.getAttribute("loginUser");
			System.out.println("로그인 Controller session id확인 : "+user.getId());
		}else {
			m.addAttribute("MSG","로그인 실패");
			m.addAttribute("content", "login.jsp");
		}
		return "home";
	}
	
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	public String logout(Model m, HttpSession session) {
		session.invalidate();
		m.addAttribute("content","main.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/myPage" , method = RequestMethod.GET)
	public String myPage(Model m) {
		m.addAttribute("content","myPage.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/userUpdate" , method = RequestMethod.POST)
	public String userUpdate(UserDTO dto, Model m) {
		//defaultUserService.userUpdate(dto);
		m.addAttribute("content","myPage.jsp");
		return "home";
	}
}
