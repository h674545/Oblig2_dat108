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
				Thread.sleep((int)(Math.random()) * 2000); //tid det tar å servere er random, 2 sek 
				brett.taAv("Servitør " + navn);
			} catch (InterruptedException e) {
			}
		}
	}
}