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
    this.setTitle("Animation");
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
	  this.setTitle("Animation");
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
    // Les coordonnées de départ de notre rond
    int x = pan.getPosX(), y = pan.getPosY();
    // Le booléen pour savoir si l'on recule ou non sur l'axe x
    boolean backX = false;
    // Le booléen pour savoir si l'on recule ou non sur l'axe y
    boolean backY = false;

    // Dans cet exemple, j'utilise une boucle while
    // Vous verrez qu'elle fonctionne très bien
    while (true) {
      // Si la coordonnée x est inférieure à 1, on avance
      if (x < 1)
        backX = false;
      // Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
      if (x > pan.getWidth() - 50)
        backX = true;
      // Idem pour l'axe y
      if (y < 1)
        backY = false;
      if (y > pan.getHeight() - 50)
        backY = true;

      // Si on avance, on incrémente la coordonnée
      // backX est un booléen, donc !backX revient à écrire
      // if (backX == false)
      if (!backX)
        pan.setPosX(++x);
      // Sinon, on décrémente
      else
        pan.setPosX(--x);
      // Idem pour l'axe Y
      if (!backY)
        pan.setPosY(++y);
      else
        pan.setPosY(--y);

      // On redessine notre Panneau
      pan.repaint();
      // Comme on dit : la pause s'impose ! Ici, trois millièmes de seconde
      try {
        Thread.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}