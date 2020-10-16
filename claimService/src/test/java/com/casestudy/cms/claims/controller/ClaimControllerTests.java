package com.casestudy.cms.claims.controller;

import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.casestudy.cms.claims.bean.Claim;
import com.casestudy.cms.claims.service.ClaimService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc

public class ClaimControllerTests {

	@Autowired
	private MockMvc mockMvc;

	
	@MockBean

    private Claim claim;

    @MockBean

    private ClaimService claimService;

	@InjectMocks
	private ClaimController claimController;

	

	

	@Before

	public void setUp() {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(claimController).build();

		claim = new Claim();

		claim.setClaimId(5);
		claim.setPolicyNumber(10002);
		claim.setClaimAmount("100000");
		claim.setClaimReason("Health Issues");
		claim.setApprovedClaimAmount("0");
		claim.setAdditionalComments("Please Approve");
		claim.setClaimStatus("pending");
		claim.setClaimSubmissionDate(new Timestamp(System.currentTimeMillis()));
		claim.setProofDocuments("attached");
	}

	@Test

	public void createClaimSuccess() throws Exception {

		when(claimService.createClaim(claim)).thenReturn(claim);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/claims/addClaim/claim").contentType(MediaType.APPLICATION_JSON)

				.content(asJsonString(claim)))

				.andExpect(MockMvcResultMatchers.status().isOk())

				.andDo(MockMvcResultHandlers.print());

		

	}
	
	 private static String asJsonString(final Object obj) {

	        try {

	            return new ObjectMapper().writeValueAsString(obj);

	        } catch (Exception e) {

	            throw new RuntimeException(e);

	        }

	    }

}
