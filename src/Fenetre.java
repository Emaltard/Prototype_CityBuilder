import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fenetre extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 8604615210182246555L;


  private Panneau pan = new Panneau();

  public Fenetre(int w, int h) {
    this.setTitle("City Builder");
    this.setSize(w, h);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
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
	  this.setContentPane(pan); 
	  this.setResizable(false);
	  this.setUndecorated(true);
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
	  
	 Grille grille_game = pan.get_grille();
	 grille_game.setMairie(3, 4);
	 grille_game.setRoute(2,4);
      try {
        Thread.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  
  
}