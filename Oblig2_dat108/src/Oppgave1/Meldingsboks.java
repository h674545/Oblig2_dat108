package Oppgave1;

import javax.swing.JOptionPane;

public class Meldingsboks extends Thread {
	
	private Utskriftsloop t; //oppretter objekt av typen utskriftsloop
	
	public Meldingsboks(Utskriftsloop t) {
		this.t = t;
	}
	
	private boolean fortsettBoks = true;
	
	public void stopp() {
		fortsettBoks = false;
	}
	
	@Override
	public void run() {
		while(fortsettBoks) {
		String meldingInput = JOptionPane.showInputDialog(
				null, 
				"Skriv inn en melding her",
				"Melding"
				, JOptionPane.PLAIN_MESSAGE);
		
		if(meldingInput != null) {
			System.out.println(meldingInput);
		}else { 
		t.stopp();
	}
		}
}
}
