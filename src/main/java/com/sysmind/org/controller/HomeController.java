package com.sysmind.org.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sysmind.org.business.pojo.IntArrayResponsePojo;
import com.sysmind.org.business.pojo.StringArrayRequestPojo;

@RestController
public class HomeController {
	
	//Initialize logger
	private static final Logger logger = LogManager.getLogger(HomeController.class);
	
	@RequestMapping(value="/test", method={RequestMethod.GET})
	public String testService() {
		return "Live!!!";
	}
	
	/**
	 * JAVA ASSIGNMENT
	 * SYSMIND LLC
	 * Make a sample project of Spring Implementation where the code should implement all layers like
	 * Business,Service etc.. 
	 * Write a Rest Controller which redirects to another controller for core logic implementation.
	 * 
	 * Please remember the rest controller code should be in Java.
	 * The controller should consist of java concepts like exception handling, multithreading,lamba expressions.
	 * Logic inside the controller is derived from Q1 below.
	 * The sample project should implement spring custom exception handling, connections with database using 
	 * Hibernate, all kinds of dependency injections, spring security
	 * @throws InterruptedException 
	 */
	
	@RequestMapping(value="/getresult", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody IntArrayResponsePojo getStringResult (
			@RequestBody StringArrayRequestPojo objStringArrayRequestPojo, @RequestHeader("Authorization") String basicAuthDetails) throws InterruptedException{
		logger.debug("Inside getStringResult of HomeController");
		RestTemplate objRestTemplate = new RestTemplate();
		
		//Setting basic Auth in request header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", basicAuthDetails);

		HttpEntity<StringArrayRequestPojo> entity = new HttpEntity<>(objStringArrayRequestPojo, headers);
		
		//Calling logic service
		ResponseEntity<IntArrayResponsePojo> response = objRestTemplate.
				exchange("http://localhost:8080/sysmind-assignment/logics/java-string-problem", 
						HttpMethod.POST, entity , IntArrayResponsePojo.class);
		
		/**Threading
		 * 
			IntArrayResponsePojo response = null;
			ControllerThread objThread = null;
			objThread = new ControllerThread(objStringArrayRequestPojo);
			objThread.start();
			objThread.join();
			response = objThread.getResponse();
		*/
		return response.getBody();
	}
}
