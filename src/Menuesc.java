import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menuesc extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -387873206307585284L;
	
	
	//private boolean fini = false; //statut du menu : false si en cours d'exec / true si on appuis a nouveau sur escape
	
	
	
	//constructeur
	public Menuesc(int w,int h){
		

		JPanel b1 = new JPanel();
	  	b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	  	b1.add(Box.createRigidArea(new Dimension(w/3,h/16)));
	  	b1.setBackground(Color.WHITE);
	  	
	  	//box pour le menu
	  	JButton button1 = new JButton("save");
	  	JPanel b2 = new JPanel();
	    b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	    b2.add(button1);
	    button1.addActionListener(new BoutonListener());
	    b2.setBackground(Color.GRAY);
	    
	    JPanel b3 = new JPanel();
	  	b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
	  	b3.add(Box.createRigidArea(new Dimension(w/3,h/16)));
	  	b1.setBackground(Color.WHITE);
	  	
	    //box pour la sauvegarde
	  	JButton button2 = new JButton("load");
	  	JPanel b4 = new JPanel();
	    b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
	    b4.add(button2);
	    button2.addActionListener(new BoutonListener2());
	    b4.setBackground(Color.GRAY);
	    
	    JPanel b5 = new JPanel();
	  	b5.setLayout(new BoxLayout(b5, BoxLayout.LINE_AXIS));
	  	b5.add(Box.createRigidArea(new Dimension(w/3,h/16)));
	  	b1.setBackground(Color.WHITE);
	    
	  //box pour le chargement
	  	JButton button3 = new JButton("quit");
	  	JPanel b6 = new JPanel();
	    b6.setLayout(new BoxLayout(b6, BoxLayout.LINE_AXIS));
	    b6.add(button3);
	    button3.addActionListener(new BoutonListener3());
	    b6.setBackground(Color.GRAY);
	    
	    JPanel b7 = new JPanel();
	  	b7.setLayout(new BoxLayout(b7, BoxLayout.LINE_AXIS));
	  	b7.add(Box.createRigidArea(new Dimension(w/3,h/16)));
	  	b1.setBackground(Color.WHITE);
	  	
	  	JPanel b8 = new JPanel();
		    b8.setLayout(new BorderLayout());
		    b8.add(b1);
		    b8.add(b2);
		    b8.add(b3);
		    b8.add(b4);
		    b8.add(b5);
		    b8.add(b6);
		    b8.add(b7);
		    
		    this.add(b8,BorderLayout.CENTER);
		    
		    JPanel background = new JPanel();
		    background.setBackground(Color.WHITE);
		    b8.setBackground(Color.WHITE);
		    
		    
		    this.add(b8);
		    
		    

		    this.setVisible(true);  
	}

	  public class BoutonListener implements ActionListener{
		     public void actionPerformed(ActionEvent e) {
			  //lien vers le menu
		    	
		    }
		  }
	  public class BoutonListener2 implements ActionListener{
		     public void actionPerformed(ActionEvent e) {
			  //lien vers la sauvegarde
		    }
		  }
	  public class BoutonListener3 implements ActionListener{
		     public void actionPerformed(ActionEvent e) {
		    	 System.exit(0);
		    }
		  }
	  
}
