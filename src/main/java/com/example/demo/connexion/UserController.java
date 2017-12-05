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
	
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "/user/creatMember";
    private final UserRepository users;
    private final PictoRepository pictos;
    private  String imgPath = "/resources/static/resources/img";
    


    @Autowired
    public UserController(UserRepository UserService, PictoRepository PictoService) {
        this.users = UserService;
        this.pictos = PictoService;
    }
    
   
    
    @GetMapping("/")
    public String index() {
    	return "index";
    }
    
    @GetMapping("/creatMember")
    public String initCreationForm(Map<String, Object> model) {
        User user = new User();
        Iterable<Pictogram> pictos = this.pictos.findAll();
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
        System.out.println(user.getFirstName());
        mav.addObject(user);
        return mav;
    }
    
    @GetMapping("/modifyMember/{user_id}")
    public ModelAndView updateUser(@PathVariable("user_id") int user_id) {
        ModelAndView mav = new ModelAndView("user/modifyMember");
        User user = this.users.findOne(user_id);
        mav.addObject(user);
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
     
    

}
