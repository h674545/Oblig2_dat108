package Oppgave2;

public class Kokk extends Thread{
	
	private HamburgerBrett brett;
	private String navn;
	
	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	public void run() {
		try {
			while(true) {
				Thread.sleep((int)(Math.random()) * 2000); //tid det tar å lage er random, 2 sek
				brett.leggPaa("Kokk " + navn);
			} 
		}catch (InterruptedException e) {
		}
	}
}
