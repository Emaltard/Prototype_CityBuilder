import java.util.*;

public class Grille {
	private ArrayList<Case> grille;
	private int nbCasesLignes;//Une grille est obligatoirement carré pour le moment.
	
	
	public Grille(){
		// il faut initialiser la grille
		grille = new ArrayList<Case>();
		nbCasesLignes = 200;
		
		for(int i = 0; i<((this.nbCasesLignes)*(this.nbCasesLignes)); i++){
			this.grille.add(new Case());
			
		}
		
	}
	
	public Grille(int NombreCasesParLignes){
		this.nbCasesLignes = NombreCasesParLignes;
		this.grille = new ArrayList<Case>();
//		System.out.println("Test avant la boucle");
		for(int i = 0; i<nbCasesLignes*nbCasesLignes; i++){
			this.grille.add(new Case());
//			System.out.println(i+"ème fois dans la boucle");
		}
	}
	
	public int getNombreCasesLignes(){
		return this.nbCasesLignes;
	}
	
	public String toString(){
		String res = new String();
		for(int i = 0; i<(this.nbCasesLignes*this.nbCasesLignes); i++){
			res += this.grille.get(i).toString();
			res += "\n";
//			System.out.println("Test "+i);
		}
		return res;
	}

}
