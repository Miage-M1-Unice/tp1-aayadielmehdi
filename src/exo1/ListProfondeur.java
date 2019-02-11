package exo1;
import java.io.File;
public class ListProfondeur {
	
	private File[] list ;
	
	public ListProfondeur(String a) {
		// TODO Stub du constructeur généré automatiquement
		File current = new File(a);
		list = current.listFiles();		 
	}
	
	public File[] ReturnEle(){
		return list;
	}
	
    public String go(File[] k) {    	
    	String s = "";
    	if (k != null){    		
    		for(int i=0 ; i<k.length;i++){    			
    			if(k[i].isDirectory()){    				
    				//go(k[i]);
    				// a faire;
    			}else{
    				s+=k[i]+"\n";	
    			}    			
    		}
    	}
    	return s;
    }

    // return table de files
	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		ListProfondeur a = new ListProfondeur(".");		
		System.out.println(a.go(a.ReturnEle()));
	}

}
