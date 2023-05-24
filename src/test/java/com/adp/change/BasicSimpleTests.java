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
public class BasicSimpleTests extends AbstractTestNGSpringContextTests {

	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	
	@Test
	public void changeRequestWithOneDollarBill() throws Exception   {
		mockMvc.perform(get("/coins/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$['c25Cents']['count']").value("4"))
		.andExpect(jsonPath("$['c25Cents']['totalValue']").value("1.0"));
	}
	
	@Test
	public void changeRequestWithTwoDollarBill() throws Exception   {
		mockMvc.perform(get("/coins/2"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$['c25Cents']['count']").value("8"))
		.andExpect(jsonPath("$['c25Cents']['totalValue']").value("2.0"));
	}
	
	@Test
	public void changeRequestWithFiveDollarBill() throws Exception   {
		mockMvc.perform(get("/coins/5"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$['c25Cents']['count']").value("20"))
		.andExpect(jsonPath("$['c25Cents']['totalValue']").value("5.0"));
	}

}
