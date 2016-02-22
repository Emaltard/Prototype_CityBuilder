import java.awt.Color;


public class Maison extends Batiment {

	public Maison() {
		super(Color.yellow, 1, 1);
	}

	@Override
	public String toString() {
		return "Maison de taille "+this.getTailleX()+"x"+this.getTailleY();
	}

}
