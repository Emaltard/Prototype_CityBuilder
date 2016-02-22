
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Launcher extends JFrame{

  /**
	 * 
	 */
	private static final long serialVersionUID = -6631269741015238763L;
	
	
	private boolean fini = false; //statut du launcher : false si en cours d'exec / true si on a appuyer sur le bouton launch
	private int w ; // longueur du launcher
	private int h ; // hauteur du launcher
	private String titre;
	private JComboBox<String> combo = new JComboBox<>();
	private boolean visible = true;
	private boolean fullscreen = false;
	
	
  //Construteur de Fenetre: renseigner le titre, la longueur puis la largeur
  public Launcher(String title, int width, int height){
	  
	  this.w= width; 
	  this.h= height;
	  this.titre= title;
	  
	  this.setTitle(this.titre);
	  this.setSize(this.w, this.h);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  this.setResizable(false);
	  this.setUndecorated(false);
	  
	  
	  
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
	    button1.addActionListener(new BoutonListener());
	    
	    
	    
	    
	    JPanel b5 = new JPanel();
	    JLabel txt1 = new JLabel("Résolution : ");
	    
	    b5.setLayout(new BoxLayout(b5, BoxLayout.LINE_AXIS));
	    b5.add(txt1);
	    b5.add(combo);
	    b5.setBackground(Color.WHITE);
	    
	    combo.addItem("1200x800");
	    combo.addItem("600x400");
	    combo.addItem("400x200");
	    combo.addItem("200x200");
	    combo.setPreferredSize(new Dimension(100, 20));
	    combo.setMaximumSize(combo.getPreferredSize());
	    combo.getSelectedItem(); // retourne l'élement selectioné Option1/Option2 ect
	    
	    
	    
	    
	    JPanel b6 = new JPanel();
	  	b6.setLayout(new BoxLayout(b6, BoxLayout.LINE_AXIS));
	  	b6.add(Box.createRigidArea(new Dimension(0,50)));
	    
	  	
	  	JPanel b7= new JPanel();
	  	b7.setLayout(new BoxLayout(b7, BoxLayout.LINE_AXIS));
	  	JLabel txt2 = new JLabel("Plein Ecran : ");
	  	b7.add(txt2);
	  	b7.setBackground(Color.WHITE);
	  	JCheckBox checkbox1 = new JCheckBox();
	  	checkbox1.addActionListener(new BoutonListener2());
	  	b7.add(checkbox1);
	  	
	  	
	  	JPanel b8 = new JPanel();
	  	b8.setLayout(new BoxLayout(b8, BoxLayout.LINE_AXIS));
	  	b8.add(Box.createRigidArea(new Dimension(0,30)));
	    
	    JPanel b4 = new JPanel();
	    //On positionne maintenant ces trois lignes en colonne
	    b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
	    b4.add(b);
	    b4.add(b1);
	    b4.add(b2);
	    b4.add(b3);
	    b4.add(b6);
	    b4.add(b5);
	    b4.add(b8);
	    b4.add(b7);
	    
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
  
  
  public class BoutonListener implements ActionListener{
	     public void actionPerformed(ActionEvent e) {
		  visible = false;
	      fini = true;

	    }
	  }
  
  public class BoutonListener2 implements ActionListener{
	     public void actionPerformed(ActionEvent e) {
	    	 fullscreen = true;
	    }
	  }
  
  
  public boolean getvisible()
  {
	  return this.visible;
  }
  
  public boolean getStatutLauncher()
  {
	  return this.fini;
  }  
  public int getWidth()
  {
	  return this.w;
  }
  
  public int getHeight()
  {
	  return this.h;
  }
  
  public int getWidthGame()
  {
   switch(combo.getSelectedItem().toString())
   {
   case "1200x800":
	   return 1200;
   case "600x400":
	   return 600;
   case "400x200":
	   return 400;
   case "200x200":
	   return 200;
	default:
		return 50;
   }
  }
  
  public int getHeightGame()
  {
   switch(combo.getSelectedItem().toString())
   {
   case "1200x800":
	   return 800;
   case "600x400":
	   return 400;
   case "400x200":
	   return 200;
   case "200x200":
	   return 200;
	default:
		return 50;
   }
  }
  
  public boolean getFullScreen()
  {
	  return this.fullscreen;
  }
}
	