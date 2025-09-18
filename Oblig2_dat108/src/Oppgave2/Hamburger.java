package Oppgave2;

public class Hamburger {

	public static void main(String[]args) {
		
		final String[] kokker = {"Anne", "Erik", "Knut"};
		final String[] servitorer = {"Mia", "Per"};
		final int KAPASITET = 4;
		
		skrivUtHeader(kokker, servitorer, KAPASITET);
		
		HamburgerBrett brett = new HamburgerBrett(KAPASITET);
		
			for(String navn : kokker) {
				new Kokk(brett, navn).start(); //starter tråden kokk
			}
			for(String navn : servitorer) {
				new Servitor(brett, navn).start(); // starter tråden servitor
			}
	}

	private static void skrivUtHeader(String[] kokker, String[] servitorer, int KAPASITET) {
		
		System.out.println("I denne simuleringen har vi: ");
		System.out.print
		(kokker.length + " kokker : ");
		for(String k : kokker) System.out.print( k + ", ");
		System.out.println(" ");
		System.out.print(servitorer.length + " servitører : ");
		for(String s : servitorer) System.out.print( s + ", ");
		System.out.println(" ");
		System.out.println("Brettets kapasitet: " + KAPASITET);
		System.out.println("Vi starter .... ");
		System.out.println(" ");
	}
}
