import java.awt.Color;


abstract public class Batiment {
		//Interface pour les batiments
		//Les différents batiments doivent héritées de cette classe abstraite.
		private Color col;
		
		public Batiment(Color col){
			this.col = col;
		}
		
		public abstract String toString();
		
		public Color getColor(){
			return this.col;
		}
}
