import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	int screenx;
	int screeny;
	int dx;
	int dy;
	boolean changement = false;
	private BufferedImage tile_grass;
	private BufferedImage tile_road_line;
	private BufferedImage tile_road_cross;
	
	public Panneau(int w, int h)
	{
		dx = w / 2;
		dy = ((h/2)-((nb_cases_par_lignes/2)*TILE_HEIGHT));
		try {
			tile_grass = ImageIO.read(new File("./images/tile_grass.png"));
			tile_road_line = ImageIO.read(new File("./images/tile_road_line.png"));
			tile_road_cross = ImageIO.read(new File("./images/tile_road_cross.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
  public void paintComponent(Graphics g) {
    for(int mapx = 0; mapx<nb_cases_par_lignes; mapx++)
    {
    	for(int mapy = 0; mapy<nb_cases_par_lignes; mapy++)
    	{
    		
    		
    		screenx = (mapx-mapy)*(TILE_WIDTH/2) + dx;
    		screeny = (mapx+mapy)*(TILE_HEIGHT/2) + dy;
    		
    		
    		int x1 = screenx;
    		int x2 = screenx + (TILE_WIDTH /2);
    		int x3 = screenx;
    		int x4 = screenx - (TILE_WIDTH /2);
    		
    		int y1 = screeny;
    		int y2 = screeny + (TILE_HEIGHT/2);
    		int y3 = screeny + (TILE_HEIGHT);
    		int y4 = screeny + (TILE_HEIGHT/2);
    		int [] polx = { x1, x2, x3, x4};
    		int [] poly = {y1, y2, y3, y4};
    		
    		if(grille_game.getCaseColor(mapx, mapy) == Color.green)
    		{
    				g.drawImage(tile_grass, screenx - TILE_WIDTH/2, screeny, this);
    		}
    		else if(grille_game.getCaseColor(mapx, mapy)== Color.gray)
    		{
    			g.drawImage(tile_road_line, screenx - TILE_WIDTH/2, screeny, this);
    		}
    		else if(grille_game.getCaseColor(mapx, mapy)== Color.darkGray)
    		{
    			g.drawImage(tile_road_cross, screenx - TILE_WIDTH/2, screeny, this);
    		}
    		else
    		{
    		
    		Polygon tile = new Polygon(polx,poly,4);
    		
    		//float r_color = rand.nextFloat();
    		//float g_color = rand.nextFloat();
    		//float b_color = rand.nextFloat();
    		//Color randomColor = new Color(r_color, g_color, b_color);
    		//g.setColor(randomColor);
    		g.setColor(grille_game.getCaseColor(mapx,mapy));
    		g.fillPolygon(tile);
    		
    		
    		
    		
    		g.setColor(Color.gray);
    		
    		/*
    		g.drawLine(x1,y1,x2,y2);
    		
    		g.drawLine(x1,y1,x4,y4);
    		
    		g.drawLine(x3,y3,x2,y2);
    		
    		g.drawLine(x4,y4,x3,y3); */
    		}
    	}
    }
    this.addMouseListener(new MouseListener1());
  }
  
  public Grille get_grille()
  {
	  return grille_game;
  }
  
  public class MouseListener1 implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {

			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			int buttonDown = e.getButton();
			float screenx_float =  e.getX() - dx;
			float screeny_float = e.getY() -dy - TILE_HEIGHT/2;
			
			float mapx_float = (screenx_float / (TILE_WIDTH/2) + screeny_float / (TILE_HEIGHT/2)) /2;
			float mapy_float = (screeny_float / (TILE_HEIGHT/2) -(screenx_float / (TILE_WIDTH/2))) /2;
			
			int mapx = Math.round(mapx_float);
			int mapy = Math.round(mapy_float);
			if(mapx<nb_cases_par_lignes && mapy<nb_cases_par_lignes && mapx>=0 && mapy>=0)
			{
				if (buttonDown == MouseEvent.BUTTON1) {
			           	grille_game.setRoute(mapx, mapy);
						changement = true;
			    } else if(buttonDown == MouseEvent.BUTTON2) {
			           // Bouton du MILIEU enfonc�
			    } else if(buttonDown == MouseEvent.BUTTON3) {
			    		grille_game.setRoute_Cross(mapx, mapy);
			    		changement = true;
			    }
				
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	  }

}