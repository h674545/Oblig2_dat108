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
	
	//metode hvor kokken legger på hamburger 
	public synchronized void leggPaa(String kokk) throws InterruptedException {
		while(brett.size() == KAPASITET) {
			wait(); // må vente til det blir ledig
			System.out.println(kokk + " klar med hambuger, men brettet fullt. Venter!");
		}
		brett.add(burgerNr); // legger på burgerNr på brettet
		Thread.sleep(3000); //synes det gikk litt vel fort, legger på 3 sek mellom hver
		System.out.println(kokk  + " legger på hamburger " + burgerNr + " " + brett);
		burgerNr++; // øker med en for hver gang 
		notifyAll(); //gir beskjed til alle 
	}
	
	//metode hvor servitørene tar av hamburgere 
	public synchronized void taAv(String servitor) throws InterruptedException {
		while(brett.isEmpty()) {
			wait();
			System.out.println(servitor + " ønsket å ta av en hamburger, men brettet er tomt. Venter!");
		}
		int burger = brett.poll(); //tar ut den første i køen 
		Thread.sleep(3000);
		System.out.println(servitor + " tar av hamburger " + burger + " " + brett);
		notifyAll();
	}
}
