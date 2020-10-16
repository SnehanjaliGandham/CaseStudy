package com.casestudy.cms.claims;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.casestudy.cms.claims.bean.Claim;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClaimFileApplicationTests {
	@Test
	public void contextLoads() {
		
	
	}
	@Test
	public void testcreateClaim() throws URISyntaxException {

	String randomServerPort = "9095";
	
    RestTemplate restTemplate = new RestTemplate();
     
    final String baseUrl = "http://localhost:" + randomServerPort + "/api/claims/addClaim";
    URI uri = new URI(baseUrl);
    
    Claim claim = new Claim (100,10002,"10000","Health reason","approve","0",new Timestamp(0),"Pending","attached");
    		
    HttpHeaders headers = new HttpHeaders();
    
    HttpEntity<Claim> request = new HttpEntity<>(claim, headers);
     
    try
    {
    	ResponseEntity<String> result=restTemplate.postForEntity(uri, request, String.class);
    	System.out.println("result is "+result);
        Assert.assertEquals(202, result.getStatusCodeValue());
    }
    catch(HttpClientErrorException ex) 
    {
        //Verify bad request and missing header
        Assert.assertEquals(400, ex.getRawStatusCode());
        Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
    }		
    
	
	}
	

	
}
