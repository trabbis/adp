package com.adp.change;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.adp.change.exceptions.InvalidBillException;

@SpringBootTest
public class NegativeCasesTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	//TODO looks for way to have new applicationContext for each unit test method
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void invalidBillRequest() throws Exception   {
		mockMvc.perform(get("/coins/1000"))
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$['errorMessage']").value("invalid bill"));

	}
	
	//TODO consider TestNG framework for better exception handling, etc
	@Test
	public void callingTwiceTwentyDollarBillRequest() throws Exception   {
//        Exception exception = assertThrows(
//        		InvalidBillException.class,  
//        		() -> mockMvc.perform(get("/coins/100")));
//        
//        assertEquals("not enough coins", exception.getMessage());
		
		mockMvc.perform(get("/coins/100"))
			.andExpect(status().is5xxServerError())
			.andExpect(jsonPath("$['errorMessage']").value("not enough coins"));

	}
	
	@Test
	public void callingTripleTwentyDollarBillRequest() throws Exception   {
		mockMvc.perform(get("/coins/20")); //Used 80 of .25cents
		mockMvc.perform(get("/coins/20")); //Used 20 of .25 cents
		mockMvc.perform(get("/coins/20"))
		.andExpect(status().is5xxServerError())
		.andExpect(jsonPath("$['errorMessage']").value("not enough coins")); 
	}
	

	
}
