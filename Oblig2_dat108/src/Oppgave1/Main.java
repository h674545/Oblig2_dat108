package Oppgave1;

public class Main extends Thread{
	
	public static void main(String[]args) throws InterruptedException {
	
	Utskriftsloop melding = new Utskriftsloop();
	melding.start();
	
	Meldingsboks meldingInput = new Meldingsboks(melding);
	meldingInput.start();

	}
}
