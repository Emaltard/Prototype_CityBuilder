import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {

  /**
	 * 
	 */
	private static final long serialVersionUID = -8632901552607891764L; //Generationn d'une cl� de s�rie li� a JFrame depuis une version sp�cifique de java, n'en tenez pas compte c'est juste pour supprimer un warning
private int posX = -50;
  private int posY = -50;

  public void paintComponent(Graphics g) {
    // On d�cide d'une couleur de fond pour notre rectangle
    g.setColor(Color.white);
    // On dessine celui-ci afin qu'il prenne tout la surface
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    // On red�finit une couleur pour notre rond
    g.setColor(Color.red);
    // On le dessine aux coordonn�es souhait�es
    g.fillOval(posX, posY, 50, 50);
  }

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }
}