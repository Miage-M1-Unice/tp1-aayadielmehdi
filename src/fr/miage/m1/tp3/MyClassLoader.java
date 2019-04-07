package fr.miage.m1.tp3;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureClassLoader;
import java.util.ArrayList;



public class MyClassLoader extends SecureClassLoader {  	
	private ArrayList<File> path = null;  	 
	public MyClassLoader(ArrayList<File> p) {  
	   this.path = p;  
	}  
	
	@Override  
	protected Class<?> findClass(String name) throws ClassNotFoundException {  		 	
		byte[] b = loadClassData(name);  
        if (b == null) {
            throw new ClassNotFoundException();
        }
        return super.defineClass(name, b, 0, b.length);             		  
	 }  
	
	 private byte[] loadClassData(String name) throws ClassNotFoundException  {  		 
		 name = name.replace(".", File.separator) + ".class";
		 System.out.println(name);
		 for(int i=0 ; i< this.path.size();i++){
			 String s = this.path.get(i)+ File.separator + name ; 
			 File f = new File(s);			
			 if (f.exists()){
				 try {
					return Files.readAllBytes(Paths.get(s));
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		 }				 
		 return null;  
	 }  
	  
	 public static void main(String[] args) {  
		 ArrayList<File> al = new ArrayList<File>();  
	     al.add(new File("."));  
	     MyClassLoader myCL = new MyClassLoader(al);  
	     try {  
	    	Class classs = myCL.loadClass("tp3.MyClassLoader");
	    	System.out.println(classs);
	     } catch (ClassNotFoundException e) {  
	    	 e.printStackTrace();  
	     }  
	 }  
	}  