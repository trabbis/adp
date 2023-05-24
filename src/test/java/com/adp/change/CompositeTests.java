package com.adp.change;

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

@SpringBootTest
public class CompositeTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	//TODO looks for way to have new applicationContext for each unit test method
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void callingTwiceTwentyDollarBillRequest() throws Exception   {
		mockMvc.perform(get("/coins/20")); //Used 80 of .25cents
		mockMvc.perform(get("/coins/20"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$['c25Cents']['count']").value("20")) //So only 20 left
		.andExpect(jsonPath("$['c25Cents']['totalValue']").value("5.0"));
	}

}
