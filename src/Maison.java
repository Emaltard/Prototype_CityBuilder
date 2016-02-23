import java.awt.Color;


public class Maison extends Batiment implements LivingQuarter{
	
	private int nbHabitants;
	private int nbHabitantsMax;
	
	public Maison() {
		super(Color.yellow, 1, 1);
	}
	
	public Maison(int nbMaxHabitants){
		super(Color.yellow, 1, 1);
		this.nbHabitantsMax = nbMaxHabitants;
		this.nbHabitants = 0;
	}

	@Override
	public String toString() {
		return "Maison de taille "+this.getTailleX()+"x"+this.getTailleY()+". "+this.toStringNbHabitants();
	}

	@Override
	public void setNbHabitantsMax(int nbMax) {
		this.nbHabitantsMax = nbMax;
	}

	@Override
	public int getNbHabitantsMax() {
		return this.nbHabitantsMax;
	}

	@Override
	public void setNbHabitants(int nbHabs) {
		this.nbHabitants = nbHabs;
	}

	@Override
	public int getNbHabitants() {
		return this.nbHabitants;
	}

	@Override
	public String toStringNbHabitants() {
		return "Il y a "+this.nbHabitants+"/"+this.nbHabitantsMax+" habitants";
	}

}
