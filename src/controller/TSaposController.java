package controller;

public class TSaposController extends Thread{
	
	static int pos=1;

	public TSaposController() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		sapo();
	}
	
	private void sapo() {
		int posSapo = 0;
		int tamanho = 100;
		
		while(posSapo <= tamanho) {
			int pulo = (int)(Math.random()*10);
			posSapo += pulo;
			System.out.println("Sapo número " + getId() + " pulou " + pulo + " metros e ja pulou " + posSapo + " metros de 100.");
			try {
				sleep(1000);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		System.out.println("Sapo " + getId() + " chegou na posição: " + pos++);
		
	}

}
