package controller;

import java.util.concurrent.Semaphore;

public class CavaleirosController extends Thread{
	private Semaphore semaforo;
	static int portaCerta = (int) (Math.random()*4)+1;
	static boolean visited[] = {false, false, false, false, false};
	int vel = 10;
	static boolean tocha = false;
	static boolean pedra = false;
	
	
	public CavaleirosController(Semaphore sem) {
		semaforo = sem;
	}
	
	
	@Override
	public void run() {
		try {
			corredor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void corredor() throws InterruptedException {
		int distMax = 2000;
		int distCavaleiro = 0;
		
		while(distCavaleiro < distMax) {
			try {
				int pass = (int) (Math.random()*3)+vel;
				sleep(50);
				distCavaleiro += pass;
				System.out.println("Cavaleiro #" + getId() + " correu " + pass + "metros de " + distCavaleiro + " metros percorridos.");
				
				if(distCavaleiro >= 500 && !tocha) {
					semaforo.acquire();
					vel += 2;
					tocha = true;
					semaforo.release();
				}
				
				if(distCavaleiro >= 1500 && !pedra) {
					semaforo.acquire();
					vel += 2;
					pedra = true;
					semaforo.release();
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		semaforo.acquire();
		portas();
		semaforo.release();
	}
	
	public void portas() {
		int escolha;
		do {
			escolha = (int) (Math.random()*4) + 1;
		}while(visited[escolha]);
		
		if(escolha == 1 && escolha != portaCerta && !visited[escolha]) {
			System.out.println("Cavaleiro #" + getId() + " entrou na porta " + escolha + ".");
			visited[escolha] = true;
		} else if(escolha == 2 && escolha != portaCerta && !visited[escolha]) {
			System.out.println("Cavaleiro #" + getId() + " entrou na porta " + escolha + ".");
			visited[escolha] = true;
		} else if(escolha == 3 && escolha != portaCerta && !visited[escolha]) {
			System.out.println("Cavaleiro #" + getId() + " entrou na porta " + escolha + ".");
			visited[escolha] = true;
		} else if(escolha == 4 && escolha != portaCerta && !visited[escolha]) {
			System.out.println("Cavaleiro #" + getId() + " entrou na porta " + escolha + ".");
			visited[escolha] = true;
		}
		
		if(escolha == portaCerta && !visited[escolha]) {
			System.out.println("Cavaleiro #" + getId() + " entrou na porta escolhida " + escolha + " e os outros cavaleiros ficaram pas picaKOASKDOAKSODKOASDO.");
			visited[escolha] = true;
		}
	}
	
	

}
