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
			m.addAttribute("MSG", "ȸ������ ����");
			m.addAttribute("content", "login.jsp");
		}else {
			m.addAttribute("MSG", "ȸ������ ����");
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
				System.out.println("addr[1]�� *�� �ƴ� : "+dto.getSufAddr());
			}else {
				addr[1]="*";
			}
			m.addAttribute("MSG","�α��� ����");
			m.addAttribute("content", "main.jsp");
			session.setAttribute("loginUser", dto);
			System.out.println("�α��� Controller ��������Ȯ�� : " +session.getAttribute("loginUser"));
			UserDTO user = (UserDTO) session.getAttribute("loginUser");
			System.out.println("�α��� Controller session idȮ�� : "+user.getId());
		}else {
			m.addAttribute("MSG","�α��� ����");
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
			m.addAttribute("MSG1", "��й�ȣ ���� �Ϸ�");
			dto = defaultUserService.login(dto);
			session.setAttribute("loginUser", dto);
		}else {
			m.addAttribute("MSG2", "��й�ȣ ���� ����");
		}
		return "pwChange";
	}
	
	@RequestMapping(value = "/userUpdate" , method = RequestMethod.POST)
	public String userUpdate(UserDTO dto, Model m, HttpSession session) {
		// ���̵𰪾ȳѾ�ͼ� ���ǿ��� ����
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		dto.setId(user.getId());
		// sufAddr �������� *�� ����
		if(dto.getSufAddr() == null || dto.getSufAddr().equals("")) {
			dto.setSufAddr("*");
		}
		// �������� ������Ʈ(id, pw, addr �Ѿ�Ű�..)
		int result = defaultUserService.userUpdate(dto);
		if(result > 0) {
			m.addAttribute("MSG", "ȸ���������� �Ϸ�");
			// ���ǰ� �ٽ� ���� �������� �� ��������..
			dto = defaultUserService.login(dto);
			String[] addr = dto.getAddr().split("!");
			dto.setPreAddr(addr[0]);
			if(!addr[1].equals("*")) {
				dto.setSufAddr(addr[1]);
				System.out.println("addr[1]�� *�� �ƴ� : "+dto.getSufAddr());
			}else {
				addr[1]="*";
			}
			session.setAttribute("loginUser", dto);
		}else {
			m.addAttribute("MSG", "ȸ���������� ����");
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
			m.addAttribute("MSG1", "ȸ��Ż�� �Ϸ�");
			session.invalidate();
		}else {
			m.addAttribute("MSG2", "ȸ��Ż�� ����");
		}
		return "deleteUser";
	}
	
}
