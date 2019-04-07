package fr.miage.m1.tp1;
import java.io.*;

public class ListRep {

	private String[] list ;
	
	public ListRep(String a) {
		File current = new File(a);
		list = current.list();		 
	}
	
	public String[] list(){
		return list;
	}
	
    public String go() {
    	String s = "";
    	if (list != null){    		
    		for(int i=0 ; i<list.length;i++){
    			s+=list[i]+"\n";
    		}
    	}
    	return s;
    }

    // return table de repertoire
	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		ListRep a = new ListRep(".");		
		System.out.println(a.go());
	}

}
