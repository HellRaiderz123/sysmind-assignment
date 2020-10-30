package com.sysmind.org.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sysmind.org.business.pojo.IntArrayResponsePojo;
import com.sysmind.org.business.pojo.StringArrayRequestPojo;
import com.sysmind.org.business.service.StringArrayRequestService;

@RestController
@ControllerAdvice
@RequestMapping(value="/logics")
public class LogicController {
	
	//Initialize logger
	private static final Logger logger = LogManager.getLogger(HomeController.class);

	
	@Autowired
	StringArrayRequestService objStringArrayRequestService;
	
	@PostMapping(path="/java-string-problem", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody IntArrayResponsePojo getStringResult(@RequestBody StringArrayRequestPojo objStringArrayRequestPojo) throws Exception {
		logger.debug("Inside getStringResult of Logic Controller");
		IntArrayResponsePojo objIntArrayResponsePojo = null;
		try {
			objIntArrayResponsePojo = new IntArrayResponsePojo();
			int[] iaData;
				iaData = objStringArrayRequestService.getResult(objStringArrayRequestPojo);
				objIntArrayResponsePojo.setIaResponseParam(iaData);
		}  
		catch (Exception e) {
			logger.debug(e.getMessage());
			logger.debug("Inside getStringResult of LogicController catch block and sending Error Response");
			throw new Exception(e.getMessage());
		}
		
		logger.debug("Inside getStringResult of LogicController and sending Ok Response");
		return objIntArrayResponsePojo;
	}

}
