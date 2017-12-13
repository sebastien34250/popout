package com.example.demo.connexion;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

	 @Autowired
	    private MockMvc mockMvc;
	 
	 @MockBean
	    private UserRepository users;
	 
	 @MockBean
	    private PictoRepository picto;
	 

//	 private Pictogram picto1 = new Pictogram(1, "rf", "drgdr");
//	 private Pictogram picto2 = new Pictogram(2, "fgh", "drgfghfghdr");
//	 private ArrayList<Pictogram> al;
	 
	 @Before
	    public void setup() {

	       
	    }
	 
	 @Test
	    public void testInitCreationForm() throws Exception {
	        mockMvc.perform(get("/creatMember"))
	            .andExpect(status().isOk())
	            .andExpect(model().attributeExists("user"))
//	            .andExpect(model().attributeExists("pictos"))
	            .andExpect(view().name("/user/createUpdateUserForm"));
	    }
}
