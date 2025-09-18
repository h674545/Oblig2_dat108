package Oppgave1;

public class Main extends Thread{
	
	public static void main(String[]args) throws InterruptedException {
	
	Utskriftsloop melding = new Utskriftsloop();
	melding.start();
	
	Meldingsboks meldingInput = new Meldingsboks(melding);
	meldingInput.start();

	// fikse så boksen lukkes når man trykker avbryt? 
	//meldinginput skrives ikke ut om og om igjen
	
	}
}