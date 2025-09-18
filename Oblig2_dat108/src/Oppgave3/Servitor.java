package Oppgave3;

import java.util.concurrent.BlockingQueue;

public class Servitor implements Runnable{	
	
	private final String navn;
	private final BlockingQueue<Integer> brett;
	
	public Servitor(BlockingQueue<Integer> brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	@Override
	public void run() {
		try {
			while(true) {
				int burger = brett.take();
			System.out.println("Servitør " + navn + " tok av hamburger " + burger);
			Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		}
	}