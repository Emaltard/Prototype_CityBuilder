public class Main {	
	public static void main(String[] args) throws InterruptedException{
		launcher laun = new launcher("City Builder Launcher", 600, 500);
		while(laun.fini == false){
			Thread.sleep(100);
		}
		if(laun.fini == true){
			new Fenetre(laun.w, laun.h);
		}
				
	}
}