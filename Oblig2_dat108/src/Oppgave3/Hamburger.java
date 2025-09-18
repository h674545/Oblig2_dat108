package Oppgave3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Hamburger {
	
	public static void main(String[]args) {
		
		BlockingQueue<Integer> brett = new ArrayBlockingQueue<Integer>(4);
		
		String[] servitorer = {"Mia", "Per"};
		String[] kokker = {"Anne", "Erik", "Knut"};
		
		skrivUtHeader(kokker, servitorer, brett);	
		
		for(String navn : kokker) {
			new Thread(new Kokk(brett, navn)).start();
		}
		
		for(String navn : servitorer) {
			new Thread(new Servitor(brett, navn)).start();
		}
	}

	private static void skrivUtHeader(String[] kokker, String[] servitorer, BlockingQueue<Integer> brett) {
		
		System.out.println("I denne simuleringen har vi: ");
		System.out.print
		(kokker.length + " kokker : ");
		for(String k : kokker) System.out.print( k + ", ");
		System.out.println(" ");
		System.out.print(servitorer.length + " servitører : ");
		for(String s : servitorer) System.out.print( s + ", ");
		System.out.println(" ");
		System.out.println("Brettets kapasitet: " + brett.remainingCapacity());
		System.out.println("Vi starter .... ");
		System.out.println(" ");
	}
}
