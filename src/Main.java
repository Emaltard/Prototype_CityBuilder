public class Main {	
	public static void main(String[] args) throws InterruptedException{
		Launcher laun = new Launcher("City Builder Launcher", 600, 500);
		while(laun.getStatutLauncher() == false){
			Thread.sleep(100);
		}
		if(laun.getStatutLauncher() == true){
			laun.setVisible(laun.getvisible());
			if(laun.getFullScreen()== true)
			{
				new Fenetre(laun.getFullScreen());
			}
			else
			{
				new Fenetre(laun.getWidthGame(), laun.getHeightGame());
			}
		}
				
	}
}