package com.minsons.minmvc.demo.test;

import org.junit.Test;

public class Test2 extends Test1<String> {  
    @Test  
    public void test1() {  
        getType();  
    }  
    
    @Test
    public void test2(){
    	String s="/xiaoming/uls?xiaoming=233";
    	String a[] = s.split("/"); 
    	
    	for(String sl:a){
    		System.out.println(sl);
    	}
    	
    	String uri="/xiaoming/uls";
    	String key="/xiaoming";
    	
    	
    	System.out.println(uri.substring(key.length()+1, uri.length()));
    }
}