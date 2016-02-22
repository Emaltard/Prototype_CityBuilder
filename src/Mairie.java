import java.awt.Color;


public class Mairie extends Batiment{
		
	public Mairie(){
		super(Color.red, 2, 2);
	}
		
	@Override
	public String toString(){
		return "mairie de taille "+this.getTailleX()+"x"+this.getTailleY();
	}
}
