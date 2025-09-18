package Oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class Kokk implements Runnable{
	
	private final String navn;
	private final BlockingQueue<Integer> brett;
	private static AtomicInteger burgerNr = new AtomicInteger(1);
	
	public Kokk(BlockingQueue<Integer> brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	@Override
	public void run() {
	    try {
	        while (true) {
	        	int burger = burgerNr.getAndIncrement();
	        	brett.put(burger);
	            System.out.println("Kokk " + navn + " lagde hamburger " + burger);
	        }
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	}
}
