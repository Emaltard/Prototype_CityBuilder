import java.awt.Color;

public class Route_Cross extends Batiment{
	

		public Route_Cross() {
			super(Color.darkGray);
		}

		@Override
		public String toString() {
			return "route de taille "+this.getTailleX()+"x"+this.getTailleY();
		}
}

