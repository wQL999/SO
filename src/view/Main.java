package view;

import javax.swing.JOptionPane;

import controller.KillController;
import controller.RedesController;
import controller.TPingController;
import controller.TSaposController;
import controller.ThreadController;
import controller.ThreadVetController;

public class Main {

	public static void main(String[] args) {
		/*
		 * RedesController rede = new RedesController(); String[] options = { "IP",
		 * "PING", "X" }; int n; do { n = JOptionPane.showOptionDialog(null,
		 * "Selecione as opçoes", "Menu", JOptionPane.YES_NO_CANCEL_OPTION,
		 * JOptionPane.DEFAULT_OPTION, null, options, options[1]);
		 * 
		 * switch (n) { case 0: rede.ip(); break; case 1: rede.ping(); break; case 2:
		 * System.exit(0); break; }
		 * 
		 * } while (n != 2);
		 * 
		 * 
		 * KillController killer = new KillController(); killer.listaProcessos();
		 * killer.mataPid(15840); killer.mataNome("notepad.exe");
		 * 
		 * 
		 * int[][] m = new int[3][5];
		 * 
		 * for(int i = 0; i < 3; i++) { for(int j = 0; j < 5; j++) { m[i][j] =
		 * (int)(Math.random()*41) +10; } }
		 * 
		 * for(int i = 0; i < 3; i++) { ThreadController t = new ThreadController(m[i]);
		 * t.start(); }
		 * 
		 * 
		 * int[] a = new int[1000];
		 * 
		 * for (int i = 0; i < 1000; ++i) { a[i] = (int) (Math.random() * 100); }
		 * 
		 * for (int i = 1; i <= 2; i++) { ThreadVetController t1 = new
		 * ThreadVetController(i, a); t1.start(); }
		 

		for (int i = 0; i < 5; ++i) {
			TSaposController t = new TSaposController();
			t.start();
		}
	*/
		
		TPingController t1 = new TPingController("google");
		TPingController t2 = new TPingController("terra");
		TPingController t3 = new TPingController("uol");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
