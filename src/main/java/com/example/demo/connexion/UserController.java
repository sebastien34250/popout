<<<<<<< HEAD
package com.example.demo.connexion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {

	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "/user/createUpdateUserForm";
	private final UserRepository users;
	private final PictoRepository pictos;
	private String imgPath = "/resources/static/resources/img";
	private String modif;
	private String emailForm="getrgd";
	private String passwordForm="drgdrgdr";
	

	@Autowired
	public UserController(UserRepository UserService, PictoRepository PictoService) {
		this.users = UserService;
		this.pictos = PictoService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/connexion")
	public String connexion(Map<String, Object> model) {
		model.put("emailForm", emailForm);
		model.put("passwordForm", passwordForm);
		return "connexion";
	}

//	@GetMapping("email={email}&password={password}")
//	public String connexionDB(@PathVariable("email") String email, @PathVariable("password") String password) {
//		System.out.println(email + password);
//		User user = users.findByMail(email, password);
//		
//		return "redirect:/readmember/" + user.getId();
//	}

	@GetMapping("/creatMember")
	public String initCreationForm(Map<String, Object> model) {
		User user = new User();
		modif = "create";
		model.put("modif", modif);
		ArrayList<Pictogram> pictos = (ArrayList<Pictogram>) this.pictos.findAll();
		model.put("user", user);
		model.put("pictos", pictos);
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/creatMember")
	public String processCreationForm(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		} else {
			this.users.save(user);
			return "redirect:/readmember/" + user.getId();
		}
	}

	@GetMapping("/readmember/{user_id}")
	public ModelAndView showUser(@PathVariable("user_id") int user_id) {
		ModelAndView mav = new ModelAndView("user/readmember");
		User user = this.users.findOne(user_id);
		mav.addObject(user);
		return mav;
	}

	@GetMapping("/modifyMember/{user_id}")
	public ModelAndView updateUser(@PathVariable("user_id") int user_id) {
		ModelAndView mav = new ModelAndView("user/createUpdateUserForm");
		modif = "update";
		mav.addObject(modif);
		User user = this.users.findOne(user_id);
		mav.addObject(user);
		ArrayList<Pictogram> pictos = (ArrayList<Pictogram>) this.pictos.findAll();
		mav.addObject("pictos", pictos);
		return mav;
	}

	@PostMapping("/modifyMember/{user_id}")
	public String processUpdateForm(@Valid User user, BindingResult result, @PathVariable("user_id") int user_id) {
		if (result.hasErrors()) {
			return "/modifyMember/{user_id}";
		} else {
			user.setId(user_id);
			this.users.save(user);
			return "redirect:/readmember/{user_id}";
		}
	}

	@PostMapping("/deleteMember/{user_id}")
	public String deleteUser(@PathVariable("user_id") int user_id) {
		this.users.delete(user_id);
		return "redirect:/connection";
	}

	@GetMapping("/listMembers")
	public String listAllMembers(Map<String, Object> model) {
		ArrayList<User> userList = new ArrayList<User>();
		userList = (ArrayList<User>) this.users.findAll();
		model.put("userList", userList);
		return "/user/listMembers";
	}

}
>>>>>>> 467924d26a063eb25188f4e52b5bf582fc47009c
