import java.awt.Color;


public class Atelier extends Batiment {

	public Atelier() {
		super(new Color(139,69,19), 2, 2);
	}

	@Override
	public String toString() {
		return "Atelier de taille "+this.getTailleX()+"x"+this.getTailleY();
	}

}
