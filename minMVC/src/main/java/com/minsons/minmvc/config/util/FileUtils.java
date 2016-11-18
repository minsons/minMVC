package com.minsons.minmvc.config.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	
	
	
	/*
	  * 通过递归得到某一路径下所有的目录及其文件
	  */
	 public static List<String> getFiles(String filePath, List<String> filestr){
	  File root = new File(filePath);
	    File[] files = root.listFiles();
	    for(File file:files){     
	     if(file.isDirectory()){
	      /*
	       * 递归调用
	       */
	      getFiles(file.getAbsolutePath(),filestr);
	      System.out.println("显示"+filePath+"下所有子目录及其文件"+file.getAbsolutePath());
	     }else{
	      System.out.println("显示"+filePath+"下所有子目录"+file.getAbsolutePath());
	      filestr.add(file.getAbsolutePath());
	     }     
	    }
	    
	    return filestr;
	 }
	 
	 /*
	  * 通过递归得到某一路径下所有的目录及其文件
	  */
	 public static List<String> ApadatePatg(String filePath){
		 
		 System.out.println("basePath"+filePath);
		 List<String> filestr=getFiles(filePath, new ArrayList<String>());
		 
		 List<String> newstrs=new ArrayList<>();
		 for(String str:filestr){
			 str=str.substring(filePath.length()-1, str.length()-6);
			 newstrs.add(str.replace("/", ".").replace("\\", "."));
		 }
		 
		 for(String str:newstrs){
				System.out.println(str);
			 }
	    return newstrs;
	 }
	 
	 
	 
	 
	
	
	public static void main( String[] arg){
		
		String basePath="D:/Rerenferce/githup/repository/minmvc/minMVC/src/main/java";
		
		List<String> newstrs=ApadatePatg(basePath);
		for(String str:newstrs){
			System.out.println(str);
		 }
		
	}
	
	
	
	
	
}
