import java.awt.Color;


public class Case {
	
	private int statut; // Si la case est occupé
	private Batiment bat; //Batiment qui se trouve sur la case, null si la case ne contient aucun batiments
	private Color col;
	
	
	//Default constructor
	public Case(){
		statut = 0; //La case est libre
		bat = null; // Il n'y a donc pas de batiments car la case est vide à l'initialisation.
		col = Color.green;//La case est verte pour l'herbe...
	}
	
	//Habited case constructor
	public Case(Batiment bat){
		this.statut = 1;
		this.bat = bat;
		this.col = bat.getColor();
	}
	
	//Envoie la couleur actuel de la case.
	public Color getColor(){
		return this.col;
	}
	
	//Renvoie le statut actuel de la case 0 si libre, 1 si occupé
	public int getStatut(){
		return this.statut;
	}
	
	//Renvoie l'instance batiment stockés.
	public Batiment getBatiment(){
		return this.bat;
	}
	
	//Permet de set l'occupation de la case prend le batiment qui occupera la case en params
	//Renvoie 1 pour une réussite et 0 si la case était déjà occupé.
	public int setOccuper(Batiment bat){
		if(this.statut == 0){
			this.bat = bat;
			this.col = bat.getColor();
			this.statut = 1;
			return 1;
		}
		else{
			return 0;
		}
	}
	
	//Permet de libérer une case
	//Renvoie 1 si réussite.
	public int setVide(){
		if(this.statut == 0){
			return 1;
		}
		else{
			this.col = Color.green;
			this.statut = 0;
			this.bat = null;
			return 1;
		}
	}
	
	//Méthodes pour afficher la classe Case
	public String toString(){
		if(this.statut == 1){
			return "Cette case est occupé par " +this.bat.toString()+". Elle est de couleur "+this.getColor().toString()+".";
		}
		else{
			return "Cette case est libre.";
		}
	}
}
