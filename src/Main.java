public class Main {	
	public static void main(String[] args) throws InterruptedException{
		Launcher laun = new Launcher("City Builder Launcher", 600, 500);
		while(laun.getStatutLauncher() == false){
			Thread.sleep(100);
		}
		if(laun.getStatutLauncher() == true){
			new Fenetre(laun.getWidth(), laun.getHeight());
		}
				
	}
}