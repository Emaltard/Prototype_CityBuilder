
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class launcher extends JFrame implements ActionListener{

  /**
	 * 
	 */
	private static final long serialVersionUID = -6631269741015238763L;
	
	
	public boolean fini = false;
	public int w = 500;
	public int h = 400;
	
	
  //Construteur de Fenetre: renseigner le titre, la longueur puis la largeur
  public launcher(String title, int width, int height){
	  this.setTitle(title);
	  this.setSize(width, height);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  this.setResizable(false);
	  
	  
	  ImageIcon img = new ImageIcon("./images/github-mark.png");
	  Image imgscale = scaleImage(img.getImage(), img.getIconWidth()/5,img.getIconHeight()/5);
	  img = new ImageIcon(imgscale);
	  
	  	JPanel b = new JPanel();
	  	b.setLayout(new BoxLayout(b, BoxLayout.LINE_AXIS));
	  	b.add(Box.createRigidArea(new Dimension(0,100)));
	  
	  
	    JPanel b1 = new JPanel();
	    //On définit le layout en lui indiquant qu'il travaillera en ligne
	    b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	    b1.add(new JLabel(img));
	    b1.setBackground(Color.WHITE);
	    
	    
	    JPanel b2 = new JPanel();
	  	b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	  	b2.add(Box.createRigidArea(new Dimension(0,50)));

	  	
	  	JPanel b3 = new JPanel();
	    //Idem pour cette ligne
	    b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
	    JButton button1 = new JButton("LAUNCH");
	    b3.add(button1);
	    button1.addActionListener(this);
	    
	    
	    JPanel b4 = new JPanel();
	    //On positionne maintenant ces trois lignes en colonne
	    b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
	    b4.add(b);
	    b4.add(b1);
	    b4.add(b2);
	    b4.add(b3);
	    b4.setLocation(50,50);
	    
	    JPanel background = new JPanel();
	    background.setBackground(Color.WHITE);
	    b4.setBackground(Color.WHITE);
	    
	    
	    this.getContentPane().add(b4);
	    this.setVisible(true);
	    
	    
	    
	    
  }
  
  public static Image scaleImage(Image img2, int width, int height) {
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) img.getGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(img2, 0, 0, width, height, null);
	    g.dispose();
	    return img;
	}
  
  public void actionPerformed(ActionEvent arg0) {
	this.fini = true;
	this.setVisible(false);
	
}
	
}