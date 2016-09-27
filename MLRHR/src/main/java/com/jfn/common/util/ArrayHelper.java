package com.jfn.common.util;

import java.util.List;

public class ArrayHelper {

	static public Object[] list2Array(List al){
		if(al==null)return new Object[0];
		Object[] ret = new Object[al.size()];
	    for(int i=0;i<ret.length;i++){
	    	ret[i] = al.get(i);
	    }
	    return ret;
	}
}
