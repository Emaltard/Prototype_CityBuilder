import java.awt.Color;


public class Case {
	
	int statut; // Si la case est occupé
	Batiment bat; //Batiment qui se trouve sur la case, null si la case ne contient aucun batiments
	Color col;
	
	public Case(){
		statut = 0; //La case est libre
		bat = null; // Il n'y a donc pas de batiments car la case est vide à l'initialisation.
		col = Color.green;//La case est verte pour l'herbe...
	}
}
