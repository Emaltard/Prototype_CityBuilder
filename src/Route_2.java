import java.awt.Color;


public class Route_2 extends Batiment{

	public Route_2() {
		super(Color.LIGHT_GRAY);
	}

	@Override
	public String toString() {
		return "route de taille "+this.getTailleX()+"x"+this.getTailleY();
	}

}