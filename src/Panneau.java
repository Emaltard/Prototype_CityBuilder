import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class Panneau extends JPanel {

  /**
	 * 
	 */
	private static final long serialVersionUID = -8632901552607891764L; //Generationn d'une clé de série lié a JFrame depuis une version spécifique de java, n'en tenez pas compte c'est juste pour supprimer un warning

	int nb_cases_par_lignes = 20;
	Grille grille_game = new Grille(nb_cases_par_lignes);
	Random rand = new Random();
	
	final int TILE_WIDTH = 64;
	final int TILE_HEIGHT = 32;
	int x;
	int y;
	
  public void paintComponent(Graphics g) {
    for(int i = 0; i<nb_cases_par_lignes; i++)
    {
    	for(int j = 0; j<nb_cases_par_lignes; j++)
    	{
    		
    		
    		x = (j-i)*(TILE_WIDTH/2) + this.getWidth()/2;
    		y = (j+i)*(TILE_HEIGHT/2) + ((this.getHeight()/2)-((nb_cases_par_lignes/2)*TILE_HEIGHT));
    		
    		
    		
    		int x1 = x;
    		int x2 = x + (TILE_WIDTH /2);
    		int x3 = x;
    		int x4 = x - (TILE_WIDTH /2);
    		
    		int y1 = y;
    		int y2 = y + (TILE_HEIGHT/2);
    		int y3 = y + (TILE_HEIGHT);
    		int y4 = y + (TILE_HEIGHT/2);
    		int [] polx = { x1, x2, x3, x4};
    		int [] poly = {y1, y2, y3, y4};
    		Polygon tile = new Polygon(polx,poly,4);
    		
    		float r_color = rand.nextFloat();
    		float g_color = rand.nextFloat();
    		float b_color = rand.nextFloat();
    		Color randomColor = new Color(r_color, g_color, b_color);
    		//g.setColor(grille_game.getCaseColor(i,j));
    		g.setColor(randomColor);
    		g.fillPolygon(tile);
    		
    		g.setColor(Color.gray);
    		
    		x1 = x;
    		y1 = y;
    		
    		x2 = x + (TILE_WIDTH /2);
    		y2 = y + (TILE_HEIGHT /2);
    		g.drawLine(x1,y1,x2,y2);
    		
    		x1 = x;
    		y1 = y;
    		x2 = x - (TILE_WIDTH/2);
    		y2 = y + (TILE_HEIGHT/2);
    		g.drawLine(x1,y1,x2,y2);
    		
    		x1 = x + (TILE_WIDTH/2);
    		y1 = y +(TILE_HEIGHT/2);
    		x2 = x;
    		y2 = y + (TILE_HEIGHT);
    		g.drawLine(x1,y1,x2,y2);
    		
    		x1 = x - (TILE_WIDTH/2);
    		y1 = y + (TILE_HEIGHT/2);
    		x2 = x;
    		y2 = y + (TILE_HEIGHT);
    		g.drawLine(x1,y1,x2,y2);
    		
    	}
    }
  }
  
  public Grille get_grille()
  {
	  return grille_game;
  }

}