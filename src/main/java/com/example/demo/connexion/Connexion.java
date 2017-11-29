package com.example.demo.connexion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Connexion {

	
	 @GetMapping("/")
	    public String index() {
	        return "index";
	    }
	 
	  @GetMapping("/connexion")
	    public String connexion() {
	        return "connexion";
	    }
	  
	  @GetMapping("/readmember")
	    public String readmember() {
	        return "readmember";
	    }
	  
	  @GetMapping("/creatMember")
	    public String creatMember() {
	        return "creatMember";
	    }
}
