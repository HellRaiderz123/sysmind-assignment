package com.sysmind.org.controller.thread;

import org.springframework.web.client.RestTemplate;

import com.sysmind.org.business.pojo.IntArrayResponsePojo;
import com.sysmind.org.business.pojo.StringArrayRequestPojo;

public class ControllerThread extends Thread{
	
	StringArrayRequestPojo objStringArrayRequestPojo;
	RestTemplate objRestTemplate = new RestTemplate();
	IntArrayResponsePojo response;
	
	public ControllerThread(StringArrayRequestPojo objStringArrayRequestPojo) {
		System.out.println("Inside Cons of  thread");
		this.objStringArrayRequestPojo = objStringArrayRequestPojo;
	}

	public void run() 
    { 
        try
        { 
        	 this.response = objRestTemplate.
    				postForObject("http://localhost:8080/sysmind-assignment/logics/java-string-problem", 
    						objStringArrayRequestPojo , IntArrayResponsePojo.class);
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
	
	public IntArrayResponsePojo getResponse() {
		return response;
	}
}
