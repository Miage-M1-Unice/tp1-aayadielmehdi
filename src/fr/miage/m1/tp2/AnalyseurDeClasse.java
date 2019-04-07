package fr.miage.m1.tp2;

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

  public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
    Class cl = Class.forName(nomClasse); 

    afficheEnTeteClasse(cl);

    System.out.println("\nAttributs: ");
    afficheAttributs(cl);

    System.out.println("\nConstructeur: ");
    afficheConstructeurs(cl);

    System.out.println("\nMéthode: ");
    afficheMethodes(cl);

    // L'accolade fermante de fin de classe !
    System.out.println("}");
  }


  /** Retourne la classe dont le nom est passé en paramètre */
  public static Class getClasse(String nomClasse) throws ClassNotFoundException {
	  return Class.forName(nomClasse);
	  
  }

  /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
  public static void afficheEnTeteClasse(Class cl) {
    //  Affichage du modifier et du nom de la classe
    // CODE A ECRIRE
	String Name = cl.getClass().getName();
	
   // Récupération de la superclasse si elle existe (null si cl est le type Object)
    Class supercl =cl.getSuperclass();

    // On ecrit le "extends " que si la superclasse est non nulle et
    // différente de Object
    // CODE A ECRIRE
    String NameExtends = "";
    if (! ((supercl.equals(Object.class)) && (supercl.equals(null)))) {
    	NameExtends = supercl.getName();
    }

    // Affichage des interfaces que la classe implemente
    // CODE A ECRIRE
    String NameInterface = "";
    for (Class element : cl.getInterfaces()) {
		NameInterface += element.getName()+" ";
	}
    
    // Enfin, l'accolade ouvrante !
    System.out.print(Name + " extends " + NameExtends + " implements " + NameInterface +"{\n");
  }

  public static void afficheAttributs(Class cl) {
    // CODE A ECRIRE	  
	for (Field element : cl.getDeclaredFields()) {
		  System.out.println(element.toString());
	}
  }

  public static void afficheConstructeurs(Class cl) {
    // CODE A ECRIRE
	  for (Constructor element : cl.getDeclaredConstructors()) {
		  System.out.println(element.toString());
	}   
  }

  public static void afficheMethodes(Class cl) {
    // CODE A ECRIRE
	  for (Method element : cl.getDeclaredMethods()) {
		  System.out.println(element.toString());
	}  
  }

  public static String litChaineAuClavier() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return br.readLine();
  }

  public static void main(String[] args) {
    boolean ok = false;

    while(!ok) {
      try {
        System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
        String nomClasse = litChaineAuClavier();

        analyseClasse(nomClasse);

        ok = true;
      } catch(ClassNotFoundException e) {
        System.out.println("Classe non trouvée.");
      }catch(IOException e) {
        System.out.println("Erreur d'E/S!");
      }
    }
  }
}