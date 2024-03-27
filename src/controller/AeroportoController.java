package controller;

import java.util.concurrent.Semaphore;

public class AeroportoController extends Thread{
	
	private Semaphore semaforo;
	static Semaphore semNor = new Semaphore(1), semSul = new Semaphore(1);
	static boolean ocupados[] = {false, false};
	
	public AeroportoController(Semaphore sem) {
		semaforo = sem;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			action();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	public void action() {
		
		try {
			int choos = (int) (Math.random()*100);
			
			if(choos %2 == 0) {
				semNor.acquire();
				System.out.println("Avião #" + getId() + " na pista Norte");
				manobrar();
				taxiar();
				decolar();
				afastarArea();
				semNor.release();
			} else {
				semSul.acquire();
				System.out.println("Avião #" + getId() + " na pista Sul");
				manobrar();
				taxiar();
				decolar();
				afastarArea();
				semSul.release();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void afastarArea() {
		try {			
			int tempo = (int) (Math.random()*500)+300;
			System.out.println("Preparando para afastar o Avião #" + getId());
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void decolar() {
		try {			
			int tempo = (int) (Math.random()*200)+600;
			System.out.println("Decolando o Avião #" + getId());
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void taxiar() {
		try {			
			int tempo = (int) (Math.random()*500)+500;
			System.out.println("Taxiando o Avião #" + getId());
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void manobrar() {
		try {			
			int tempo = (int) (Math.random()*400)+300;
			System.out.println("Manobrando o Avião #" + getId());
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
