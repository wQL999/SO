package controller;

public class ThreadVetController extends Thread {

	private int choice;
	private int[] vet;
	
	public ThreadVetController(int c, int a[]) {
		choice = c;
		vet = a;
	}
	
	@Override
	public void run() {
		if(choice %2 == 1)
			estFor();
		else
			estForeach();
	}
	
	public void estFor() {
		double initialTime = System.nanoTime();
		for(int i = 0; i < vet.length; i++) {}
		double finalTime = System.nanoTime();
		double tempo = finalTime - initialTime;
		tempo /= Math.pow(10, 9);
		System.out.println("#" + getId() + " ->" + tempo + "s. For");
	}
	
	public void estForeach() {
		double initialTime = System.nanoTime();
		for(int i : vet) {}
		double finalTime = System.nanoTime();
		double tempo = finalTime - initialTime;
		tempo /= Math.pow(10, 9);
		System.out.println("#" + getId() + " -> " + tempo + "s. Foreach");
	}

}
