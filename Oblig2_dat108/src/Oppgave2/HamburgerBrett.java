package Oppgave2;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett extends Thread{
	
	private final int KAPASITET;
	private final Queue<Integer> brett = new LinkedList<>();
	private int burgerNr = 1; 

	public HamburgerBrett(int KAPASITET) {
		this.KAPASITET = KAPASITET;
	}
	

	public synchronized void leggPaa(String kokk) throws InterruptedException {
		while(brett.size() == KAPASITET) {
			wait(); 
			System.out.println(kokk + " klar med hambuger, men brettet fullt. Venter!");
		}
		brett.add(burgerNr); 
		Thread.sleep(3000); 
		System.out.println(kokk  + " legger på hamburger " + burgerNr + " " + brett);
		burgerNr++; 
		notifyAll();
	}
	
	
	public synchronized void taAv(String servitor) throws InterruptedException {
		while(brett.isEmpty()) {
			wait();
			System.out.println(servitor + " ønsket å ta av en hamburger, men brettet er tomt. Venter!");
		}
		int burger = brett.poll(); 
		Thread.sleep(3000);
		System.out.println(servitor + " tar av hamburger " + burger + " " + brett);
		notifyAll();
	}
}
