package com.test.madhu.ownApp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.jwt.ownApp.MyOwnAppMain;
import com.test.jwt.ownApp.controller.AppController;
import com.test.jwt.ownApp.payload.PollResponse;
import com.test.jwt.ownApp.security.UserPrincipal;
import com.test.jwt.ownApp.services.PollService;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = MyOwnAppMain.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class AppTest {
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private PollService pollService;

	@InjectMocks
	private AppController appController;

	private static ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private WebApplicationContext wac;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testApp() {
		System.out.println("testing the test classes methods ");

	}

	@Test
	public void getHealthStatus() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/app/checkApp").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals("These methods are working", response.getContentAsString());
	}

	@Test
	public void testPollService() throws Exception {
		List<GrantedAuthority> list = new ArrayList<>();
		UserPrincipal user = new UserPrincipal(1l, "", "", "", "", list.stream().collect(Collectors.toList()));

		PollResponse pollResponse = new PollResponse();
		pollResponse.setId(1l);

		Mockito.when(pollService.getPollById(Mockito.anyLong(), Mockito.any())).thenReturn(pollResponse);
		PollResponse result = pollService.getPollById(1l, user);
		Assert.assertEquals(result.getId(), new Long(1));
		Mockito.verify(pollService, Mockito.times(1)).getPollById(Mockito.anyLong(), Mockito.any());
	}

}
