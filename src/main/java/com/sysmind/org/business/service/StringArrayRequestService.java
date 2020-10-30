/**
 * Logic to get the response
 * 
 * Example
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 */

package com.sysmind.org.business.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sysmind.org.business.pojo.StringArrayRequestPojo;
import com.sysmind.org.controller.HomeController;
import com.sysmind.org.exeption.SysmindAppException;

@Component
public class StringArrayRequestService {
	
	//Initialize logger
	private static final Logger logger = LogManager.getLogger(HomeController.class);

	
	public int[] getResult(StringArrayRequestPojo objStringArrayRequestPojo) throws SysmindAppException, Exception {
		
		logger.debug("Inside getResult of StringArrayRequestService");
		
		String[] saDet = objStringArrayRequestPojo.getSaRequestParam();
		String strData = objStringArrayRequestPojo.getStrData();
		strData = strData.toLowerCase();
		
		int[] iData;
		//Logic Starts here
		// No of chars of a word saDet 
        int iWordSize = saDet[0].length(); 
          
        // No of words in saDet
        int iWordCount = saDet.length; 
  
        // Total char 
        int iTotalSize = iWordSize * iWordCount; 
  
        ArrayList<Integer> res = new ArrayList<Integer>(); 
        int n = strData.length(); 
          
        //Negetive Scenerio
        if (iTotalSize > n) 
        {
        	//return empty Array
        	iData = new int[0];
            return iData;
        } 
  
        try {
	        HashMap<String, Integer> hmHashData =  
	            new HashMap<String, Integer>(); 
	  
	        for (String word : saDet)  
	        { 
	            hmHashData.put(word, hmHashData.getOrDefault(word, 0) + 1); 
	        } 
	  
	          
	        for (int i = 0; i <= n - iTotalSize; i++)  
	        { 
	            @SuppressWarnings("unchecked")
				HashMap<String, Integer> hmTempMap =  
	            (HashMap<String, Integer>) hmHashData.clone(); 
	            int j = i, count = iWordCount; 
	              
	            // Traverse the substring  
	            while (j < i + iTotalSize)  
	            { 
	                // getting words
	                String word = strData.substring(j, j + iWordSize); 
	                
	                if (!hmHashData.containsKey(word) || hmTempMap.get(word) == 0)  
	                { 
	                    break; 
	                }  
	                else 
	                { 
	                    hmTempMap.put(word, hmTempMap.get(word) - 1); 
	                    count--; 
	                } 
	                j += iWordSize; 
	            } 
	
	            if (count == 0) 
	            { 
	                res.add(i); 
	            } 
	  
	        } 
	        
	        //putting into ArrayList
	        iData = new int[res.size()];
	    	for(int i=0; i<iData.length; i++) {
	    		iData[i] = res.get(i);
	    	}
	    	//throwing unchecked exception
        } catch(SysmindAppException e) {
        	logger.debug("Exception occures in StringArrayRequestService getResult method" + e.getMessage());
        	throw new SysmindAppException(e.getMessage());
        } catch(Exception e) {
        	logger.debug("Exception occures in StringArrayRequestService getResult method" + e.getMessage());
        	throw new Exception(e.getMessage());
        }
    	//return Array integ
        return iData; 
		
	}
	
	

}
