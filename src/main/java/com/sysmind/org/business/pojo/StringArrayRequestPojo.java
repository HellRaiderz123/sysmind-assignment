package com.sysmind.org.business.pojo;

import java.util.Arrays;

public class StringArrayRequestPojo {
	
	private String[] saRequestParam;
	
	private String strData;

	public String getStrData() {
		return strData;
	}

	public void setStrData(String strData) {
		this.strData = strData;
	}

	public String[] getSaRequestParam() {
		return saRequestParam;
	}

	public void setSaRequestParam(String[] saRequestParam) {
		this.saRequestParam = saRequestParam;
	}

	@Override
	public String toString() {
		return "StringArrayRequestPojo [saRequestParam=" + Arrays.toString(saRequestParam) + "]";
	}
	
	

}
