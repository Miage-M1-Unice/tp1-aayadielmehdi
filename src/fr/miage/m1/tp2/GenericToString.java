package fr.miage.m1.tp2;

import java.lang.reflect.Field;
import java.awt.Point;
import java.awt.Polygon;

public class GenericToString {

	public GenericToString() {
		// TODO Stub du constructeur généré automatiquement
	}

	public String toString(Object cl)  {
		String Resultat = "";
		Resultat= cl.getClass().getName()+"[";
		
		for (Field element : cl.getClass().getDeclaredFields()) {			
			try{
				element.setAccessible(true);
				
				Resultat += element.getName()+"=" ; 
				if(!element.getType().isPrimitive()){
					Resultat += "{";
					//for (iterable_type ele : element.getType().getClass()) {
						
					//}
					Resultat += "}";
				}else{
					Resultat += element.get(cl)+"; ";
				}
				
			}catch(Exception ex){
				
			}
			
		}
		
		return Resultat+"]";
	}
	
	public static void main(String[] args)  {
		// TODO Stub de la méthode généré automatiquement
		//System.out.println(new GenericToString().toString(new Point(12,24)));
		
		// deuxieme cas
		Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);  
		pol.getBounds();  
		System.out.println(new GenericToString().toString(pol));  
	}

}
