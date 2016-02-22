import java.awt.Color;
import java.util.*;

public class Grille {
	
	private ArrayList<Case> grille;
	private int nbCasesLignes;//Une grille est obligatoirement carré pour le moment.
	
	
	public Grille(){
		// il faut initialiser la grille
		this.grille = new ArrayList<Case>();
		this.nbCasesLignes = 200;
		
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
	
	public void setMairie(int x, int y){//Envoyer x et y en partant du haut-droite de (0, 0) jusqu'� la taille de la grille obtenable gr�ce � la m�thode int getTaille();
		setCase(x, y, new Mairie(), 2, 2);
	}
	
	public void setRoute(int x, int y){
		setCase(x, y, new Route(), 1, 1);
	}
	
	public void setLibre(int x, int y){
		int axe, xtemp, ytemp;
		Case cas;
		xtemp = x;
		ytemp = y*this.nbCasesLignes;
		axe = xtemp + ytemp;
		cas = this.grille.get(axe);
		for(int i = 0; i<cas.getBatiment().getTailleX(); i++){
			for(int j = 0; j<cas.getBatiment().getTailleY(); j++){
				xtemp = (x+i);
				ytemp = (y+j)*this.nbCasesLignes;
				axe = xtemp+ytemp;
				cas = this.grille.get(axe);
				cas.setVide();
			}
		}		
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
	
	private int setCase(int x, int y, Batiment bat, int taillex, int tailley){
		int axe, xtemp, ytemp;
		Case cas;
		for(int i = 0; i<taillex; i++){
			for(int j = 0; j<tailley; j++){
				xtemp = (x+i);
				ytemp = (y+j)*this.nbCasesLignes;
				axe = xtemp+ytemp;
				cas = this.grille.get(axe);
				if(cas.getStatut() != 0){
					return -1;
				}
			}
		}
		for(int i = 0; i<taillex; i++){
			for(int j = 0; j<tailley; j++){
				xtemp = (x+i);
				ytemp = (y+j)*this.nbCasesLignes;
				axe = xtemp+ytemp;
				cas = this.grille.get(axe);
				cas.setOccuper(bat);
			}
		}
		return 0;
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
	
//	Mairie : 2x2 rouge
//	Maison : 1x1 jaune
//	Police : 1x1 bleu
//	Route: 1x1 gris
//	Herbe: 1x1 vert
//	Atelier: 2x2 marron

}
