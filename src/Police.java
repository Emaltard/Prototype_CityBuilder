import java.awt.Color;


public class Police extends Batiment {

	public Police() {
		super(Color.blue, 1, 1);
	}

	@Override
	public String toString() {
		return "Police de taille "+this.getTailleX()+"x"+this.getTailleY();
	}

}
