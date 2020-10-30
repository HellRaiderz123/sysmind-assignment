package com.sysmind.org.business.pojo;

import java.util.Arrays;

public class IntArrayResponsePojo {
	
	private int[] iaResponseParam;

	public int[] getIaResponseParam() {
		return iaResponseParam;
	}

	public void setIaResponseParam(int[] iaResponseParam) {
		this.iaResponseParam = iaResponseParam;
	}

	@Override
	public String toString() {
		return "IntArrayResponsePojo [iaResponseParam=" + Arrays.toString(iaResponseParam) + "]";
	}
	
	

}
