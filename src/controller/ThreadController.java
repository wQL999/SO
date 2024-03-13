package controller;

public class ThreadController extends Thread {

	private int vet[];
	
	public ThreadController(int[] vet) {
		this.vet = vet;
	}
	
	@Override
	public void run() {
		somaMatriz();
	}
	
	
	private void somaMatriz() {
		int sum = 0;
		for(int i = 0; i < vet.length; i++) {
			sum += vet[i];
		}
		System.out.println("Thread #" + getId() + " Soma:" + sum);
	}

}
