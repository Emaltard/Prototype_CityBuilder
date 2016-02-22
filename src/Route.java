import java.awt.Color;


public class Route extends Batiment{

	public Route() {
		super(Color.gray);
	}

	@Override
	public String toString() {
		return "route de taille "+this.getTailleX()+"x"+this.getTailleY();
	}

}
