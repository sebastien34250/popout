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
		User user = new User();
		model.put("user", user);
		return "connexion";
	}

	@PostMapping("/connexion")
	 public String connexionDB(@Valid User user, BindingResult result) {
	 System.out.println(user.getEmail()+ user.getPassword());
	 //user = users.findByMail(user.getEmail(), user.getPassword());
	
	 return "redirect:/readmember/" + user.getId();
	 }

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
		if (this.users.controlEmail(user.getEmail()).size() != 0)
			result.rejectValue("email", "email.errors", user.getEmail() + " is already taken");
		if (this.users.controlPseudo(user.getPseudo()).size() != 0)
			result.rejectValue("pseudo", "pseudo.errors", user.getPseudo() + " is already taken");
		if (result.hasErrors()) {
			return "redirect:/creatMember";
		} else {

			try {
				this.users.save(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
		String newPseudo = user.getPseudo();
		String newEmail = user.getEmail();

		if (newPseudo.equals(this.users.getOne(user_id).getPseudo()) == false) {
			if (this.users.controlPseudo(user.getPseudo()).size() != 0)
				result.rejectValue("pseudo", "pseudo.errors", user.getPseudo() + " is already taken");
		}

		if (newEmail.equals(this.users.getOne(user_id).getEmail()) == false) {
			if (this.users.controlEmail(user.getEmail()).size() != 0)
				result.rejectValue("email", "email.errors", user.getEmail() + " is already taken");
		}

		if (result.hasErrors()) {
			return "/modifyMember/" + user_id;
		} else {

			user.setId(user_id);
			this.users.save(user);
			return "redirect:/readmember/" + user.getId();

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
