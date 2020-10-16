package com.casestudy.cms;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.casestudy.cms.bean.Policy;

@RunWith(SpringRunner.class)
@SpringBootTest
class PremiumProcessApplicationTests {
	
	@Test
	public void contextLoads() {
		
	
	}
	@Test
	public void testGetUserPoliciesById() throws URISyntaxException {

	String randomServerPort = "8989";
	
    RestTemplate restTemplate = new RestTemplate();
     
    final String baseUrl = "http://localhost:" + randomServerPort + "/api/user/premiumDetails/6";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
    System.out.println("Result is "+result);
    //Verify request succeed
    Assert.assertEquals(202, result.getStatusCodeValue());
   
    
	
	}
	
	@Test
	public void testGetUserPoliciesById1() throws URISyntaxException {

	String randomServerPort = "8989";
	
    RestTemplate restTemplate = new RestTemplate();
     
    final String baseUrl = "http://localhost:" + randomServerPort + "/api/user/premiumDetails/16";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
    Assert.assertEquals(false, result.getBody().isEmpty());	
	
	}
	
	
	
	

}