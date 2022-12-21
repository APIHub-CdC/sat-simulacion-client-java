package com.cdc.ccmx.client.api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.ccmx.client.ApiClient;
import com.cdc.ccmx.client.ApiException;
import com.cdc.ccmx.client.model.ResponseRFCValidator;

import okhttp3.OkHttpClient;

public class RfcValidatorApiTest {
    private final RfcValidatorApi api = new RfcValidatorApi();
    private Logger logger = LoggerFactory.getLogger(RfcValidatorApiTest.class.getName());
   
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
    public void getRFCValidatorTest() throws Exception {
        String id = "";
        
        try {
        	ResponseRFCValidator response = api.getRFCValidator(xApiKey, id);
    		
    		Assert.assertTrue(response != null);
            if(response != null) {
                logger.info(response.toString());
            }
    	} catch (ApiException e) {
    		logger.info(e.getResponseBody());
    	}
    }
    
}
