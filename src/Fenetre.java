import javax.swing.JFrame;

import java.awt.Toolkit;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fenetre extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 8604615210182246555L;

	private int width_game;
	private int height_game;
  private Panneau pan;

  public Fenetre(int w, int h) {
    this.setTitle("City Builder");
    this.width_game = w;
    this.height_game = h;
    this.setSize(width_game, height_game);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    this.pan = new Panneau(width_game, height_game);
    
    this.setContentPane(pan);
    
    
    this.setResizable(false);
    this.setVisible(true);

    
    this.addKeyListener(new KeyListener1());
    go();
  }
  
  public Fenetre(boolean fullscreen)
  {
	  if(fullscreen == true)
	  {
	  this.setTitle("City Builder");
	  this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  this.setResizable(false);
	  this.setUndecorated(true);
	  
	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	  double width = screenSize.getWidth();
	  double height = screenSize.getHeight();
	  
	  this.width_game =  (int) width;
	  this.height_game = (int) height;
	  
	  this.pan = new Panneau(width_game, height_game);
	  
	  this.setContentPane(pan); 
	  
	  this.setVisible(true);
	  
	  
	  this.addKeyListener(new KeyListener1());
	  
	  go();
	  }
	  else System.exit(0);

  }
  
  
  
  public class KeyListener1 implements KeyListener{
	    public void keyPressed(KeyEvent keyEvent) {
	        keyEvent.getKeyCode();
	     
	        if (keyEvent.getKeyCode()==KeyEvent.VK_ESCAPE){
	            System.exit(0);
	        }
	        }
	    public void keyReleased(KeyEvent keyEvent) {
	    }
	    public void keyTyped(KeyEvent keyEvent) {
	    }
  }

  private void go() {
	  while(true)
	  {
		  try {
		        Thread.sleep(16);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		  if(pan.changement == true){
			  pan.repaint();
			  pan.changement = false;
		  }
		  
	  }
      
    }
  
  
}