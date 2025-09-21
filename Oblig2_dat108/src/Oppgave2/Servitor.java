package Oppgave2;

public class Servitor extends Thread{	
	
	private HamburgerBrett brett;
	private String navn;
	
	public Servitor(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep((int)(Math.random()) * 2000);
				brett.taAv("Servitør " + navn);
			} catch (InterruptedException e) {
			}
		}
	}
}
