package Oppgave1;

public class Utskriftsloop extends Thread{
	
	private boolean fortsett = true;
	
	public void stopp() {
		fortsett = false;
	}
	
	@Override
	public void run() {
		while(fortsett) {
			System.out.println("Hello verden!");
			try {
				Thread.sleep(3000); //setter den til 3 sek 
			} catch (InterruptedException e) {
			}
		}}
	}