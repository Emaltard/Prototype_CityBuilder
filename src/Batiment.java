import java.awt.Color;


abstract public class Batiment {
		//Interface pour les batiments
		//Les différents batiments doivent héritées de cette classe abstraite.
		private Color col;
		private int taillex;
		private int tailley;
		
		public Batiment(Color col){
			this.col = col;
			this.taillex = 1;
			this.tailley = 1;
		}
		
		public Batiment(Color col, int taillex, int tailley){
			this.col = col;
			this.taillex = taillex;
			this.tailley = tailley;
		}
		
		public abstract String toString();
		
		public Color getColor(){
			return this.col;
		}
		
		public int getTailleX(){
			return this.taillex;
		}
		
		public int getTailleY(){
			return this.tailley;
		}
}
