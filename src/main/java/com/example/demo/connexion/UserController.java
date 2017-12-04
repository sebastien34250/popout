package com.example.demo.connexion;

import java.util.Map;

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


    @Autowired
    public UserController(UserRepository UserService) {
        this.users = UserService;
    }
    
    @GetMapping("/")
    public String index() {
    	return "index";
    }
    
    @GetMapping("/creatMember")
    public String initCreationForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
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
        User user = this.users.findById(user_id);
        System.out.println(user.getFirstName());
        mav.addObject(user);
        return mav;
    }
    
    @GetMapping("/modifyMember/{user_id}")
    public ModelAndView updateUser(@PathVariable("user_id") int user_id) {
        ModelAndView mav = new ModelAndView("user/modifyMember");
        User user = this.users.findById(user_id);
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
    
    

}
