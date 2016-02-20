import java.awt.Color;
import java.util.*;

public class Grille {
	
	private ArrayList<Case> grille;
	private int nbCasesLignes;//Une grille est obligatoirement carr√© pour le moment.
	
	
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
		for(int i = 0; i<nbCasesLignes*nbCasesLignes; i++){
			this.grille.add(new Case());
		}
	}
	
//	public void setCase(int x, int y){
//		int axe;
//		y = y*this.nbCasesLignes;
//		axe = y+x;
//		Case cas = this.grille.get(axe);
//		cas.setOccuper()
//		//TODO: Faire les setter.
//	}
	
	public void setMairie(int x, int y){//Envoyer x et y en partant du haut-droite de (0, 0) jusqu'‡ la taille de la grille obtenable gr‚ce ‡ la mÈthode int getTaille();
		int axe;
		y = y*this.nbCasesLignes;
		axe = y+x;
		Case cas = this.grille.get(axe);
		cas.setOccuper(new Mairie());
	}
	
	public void setRoute(int x, int y){
		int axe;
		y = y*this.nbCasesLignes;
		axe = y+x;
		Case cas = this.grille.get(axe);
		cas.setOccuper(new Route());
	}
	
	public void setLibre(int x, int y){
		int axe;
		y = y*this.nbCasesLignes;
		axe = y+x;
		Case cas = this.grille.get(axe);
		cas.setVide();
	}
	
	public int getTaille(){
		return this.nbCasesLignes;
	}
	
	public Color getCaseColor(int x, int y){
		int axe;
		y = y*this.nbCasesLignes;
		axe = y+x;
		Case cas = this.grille.get(axe);
		return cas.getColor();
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
