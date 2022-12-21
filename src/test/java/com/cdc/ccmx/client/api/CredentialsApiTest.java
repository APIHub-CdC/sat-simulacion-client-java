package com.cdc.ccmx.client.api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.ccmx.client.ApiClient;
import com.cdc.ccmx.client.ApiException;
import com.cdc.ccmx.client.model.CredentialCiecInput;
import com.cdc.ccmx.client.model.ResponseCredential;

import okhttp3.OkHttpClient;


public class CredentialsApiTest {
	private Logger logger = LoggerFactory.getLogger(CredentialsApiTest.class.getName());
    
    private final CredentialsApi api = new CredentialsApi();
    private ApiClient apiClient;
    private String xApiKey = "";
    private String url = "";
    
    @Before()
    public void Setup() {
    	 this.apiClient = api.getApiClient();
         this.apiClient.setBasePath(url);
         OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
         apiClient.setHttpClient(okHttpClient);
    }
	
	
    
    @Test
    public void createCredentialTest() throws Exception {
    	
    	CredentialCiecInput credentialCiecInput = new CredentialCiecInput();
    	
    	credentialCiecInput.setType("ciec");
    	credentialCiecInput.setRfc("");
    	credentialCiecInput.setPassword("");
    	
        
        try {
    		ResponseCredential response = api.createCredential(xApiKey, "application/json", credentialCiecInput);
    		
    		Assert.assertTrue(response != null);
            if(response != null) {
                logger.info(response.toString());
            }
    	} catch (ApiException e) {
    		logger.info(e.getResponseBody());
    	}
    }    
    
}
