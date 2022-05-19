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
		if(dto.getSufAddr() == null || dto.getSufAddr().equals("")) {
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
				System.out.println("addr[1]이 *이 아님 : "+dto.getSufAddr());
			}else {
				addr[1]="*";
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
	
	@RequestMapping(value = "/pwChange" , method = RequestMethod.GET)
	public String pwChange() {
		return "pwChange";
	}

	@RequestMapping(value = "/newPw" , method = RequestMethod.POST)
	public String newPw(UserDTO dto, Model m, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		dto.setId(user.getId());
		int result = defaultUserService.pwChange(dto);
		if(result > 0) {
			m.addAttribute("MSG1", "비밀번호 수정 완료");
			dto = defaultUserService.login(dto);
			session.setAttribute("loginUser", dto);
		}else {
			m.addAttribute("MSG2", "비밀번호 수정 실패");
		}
		return "pwChange";
	}
	
	@RequestMapping(value = "/userUpdate" , method = RequestMethod.POST)
	public String userUpdate(UserDTO dto, Model m, HttpSession session) {
		// 아이디값안넘어와서 세션에서 꺼냄
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		dto.setId(user.getId());
		// sufAddr 값없을때 *로 저장
		if(dto.getSufAddr() == null || dto.getSufAddr().equals("")) {
			dto.setSufAddr("*");
		}
		// 유저정보 업데이트(id, pw, addr 넘어갈거고..)
		int result = defaultUserService.userUpdate(dto);
		if(result > 0) {
			m.addAttribute("MSG", "회원정보수정 완료");
			// 세션값 다시 설정 유저정보 다 가져오기..
			dto = defaultUserService.login(dto);
			String[] addr = dto.getAddr().split("!");
			dto.setPreAddr(addr[0]);
			if(!addr[1].equals("*")) {
				dto.setSufAddr(addr[1]);
				System.out.println("addr[1]이 *이 아님 : "+dto.getSufAddr());
			}else {
				addr[1]="*";
			}
			session.setAttribute("loginUser", dto);
		}else {
			m.addAttribute("MSG", "회원정보수정 실패");
		}
		m.addAttribute("content","myPage.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/deleteUser" , method = RequestMethod.GET)
	public String deleteUser() {
		return "deleteUser";
	}

	@RequestMapping(value = "/deleteUserPro" , method = RequestMethod.POST)
	public String deleteUserPro(UserDTO dto, Model m, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		dto.setId(user.getId());
		int result = defaultUserService.deleteUser(dto);
		if(result > 0) {
			m.addAttribute("MSG1", "회원탈퇴 완료");
			session.invalidate();
		}else {
			m.addAttribute("MSG2", "회원탈퇴 실패");
		}
		return "deleteUser";
	}
	
}
