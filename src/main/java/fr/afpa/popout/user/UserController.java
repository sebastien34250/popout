package fr.afpa.popout.user;

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
	
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "/creatMember";
    private final UserRepository users;


    @Autowired
    public UserController(UserRepository UserService) {
        this.users = UserService;
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
    
    @GetMapping("/readmember/{ownerId}")
    public ModelAndView showUser(@PathVariable("user_id") int user_id) {
        ModelAndView mav = new ModelAndView("readmember/memberDetails");
        mav.addObject(this.users.findById(user_id));
        return mav;
    }

}
