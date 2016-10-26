package com.minsons.minmvc.demo.test;


import java.io.File;    
import java.io.IOException;    
import java.net.URL;    
import java.util.ArrayList;    
import java.util.List;

import com.minsons.minmvc.config.MinCofigure;    

public class ClassUtil {    
	   
	    
	    /**   
	     * 获取同一路径下所有子类或接口实现类   
	     *    
	     * @param intf   
	     * @return   
	     * @throws IOException   
	     * @throws ClassNotFoundException   
	     */    
	    public static List<Class<?>> getAllAssignedClass(Class<?> cls) throws IOException,    
	            ClassNotFoundException {    
	        List<Class<?>> classes = new ArrayList<Class<?>>();    
	        for (Class<?> c : getClasses(cls)) {
	        	
	        	if(c.getGenericSuperclass().getClass().equals(cls)){
	        		System.out.println("找到父类了！"+c.getName());
	        	}
	        	
	            if (cls.isAssignableFrom(c) && !cls.equals(c)) {    
	                classes.add(c);    
	            }    
	        }    
	        return classes;    
	    }    
	    
	    /**   
	     * 取得当前类路径下的所有类   
	     *    
	     * @param cls   
	     * @return   
	     * @throws IOException   
	     * @throws ClassNotFoundException   
	     */    
	    public static List<Class<?>> getClasses(Class<?> cls) throws IOException,    
	            ClassNotFoundException {    
	       // String pk = cls.getPackage().getName();    
	        
	    	 String pk="com";
	         String path = pk.replace('.', '/');
	        System.out.println(path);
	        ClassLoader classloader = Thread.currentThread().getContextClassLoader();    
	        URL url = classloader.getResource(path);   
	        System.out.println(url);
	        return getClasses(new File(url.getFile()), pk);    
	    }    
	    
	    /**   
	     * 迭代查找类   
	     * @param dir   
	     * @param pk   
	     * @return   
	     * @throws ClassNotFoundException   
	     */    
	    private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {    
	        List<Class<?>> classes = new ArrayList<Class<?>>();    
	        if (!dir.exists()) {    
	            return classes;    
	        }    
	        for (File f : dir.listFiles()) {    
	            if (f.isDirectory()) {    
	                classes.addAll(getClasses(f, pk + "." + f.getName()));    
	            }    
	            String name = f.getName();    
	            if (name.endsWith(".class")) {    
	                classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));    
	            }    
	        }    
	        return classes;    
	    }  
	      
	      
	    public static void main(String[] args) {    
	        try {    
	            System.out.println("获取所有子类和实现类：");    
	            for (Class<?> c : getAllAssignedClass(MinCofigure.class)) {    
	                System.out.println(c.getName());    
	            }    
	            /*System.out.println("获取所有类：");    
	            for (Class<?> c : getClasses(MinCofigure.class)) {    
	                System.out.println(c.getName());    
	            }    */
	        } catch (ClassNotFoundException e) {              
	            e.printStackTrace();    
	        } catch (IOException e) {                
	            e.printStackTrace();    
	        }    
	    }   
	      
	      
	
	
	
	
	
	
	
	
	
	
	
}
