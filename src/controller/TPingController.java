package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TPingController extends Thread {

	private BufferedReader read;
	private Runtime run = Runtime.getRuntime();
	private Process process;
	private String sis;

	public TPingController(String site) {
		sis = site;
	}

	@Override
	public void run() {
		ping(sis);
	}

	private void ping(String site) {
		/*
		 * String command = "ping -4 -n 10 www." + site + ".com.br"; try { process =
		 * run.exec(command);
		 * 
		 * read = new BufferedReader(new InputStreamReader(process.getInputStream()));
		 * String line = read.readLine();
		 * 
		 * while (line != null) { System.out.println(line);
		 * 
		 * if (line.contains("avg")) { String[] p = line.trim().split(" "); String[] pl
		 * = p[3].split("/"); System.out.println("Média de pings igual a " + pl[1] +
		 * "ms."); }
		 * 
		 * line = read.readLine(); } System.out.println("Site: " + site); read.close();
		 * 
		 * } catch (Exception e) { System.err.println(e.getMessage()); }
		 */
		String command = "ping -4 -n 10 www." + site + ".com.br";
		try {
			process = run.exec(command);

			read = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = read.readLine();

			while (line != null) {
				System.out.println(line);

				if (line.contains("dia")) {
					String[] p = line.trim().split(" ");
					System.out.println("Site: " + site + " Média de ping igual a " + p[p.length - 1]);
				}

				line = read.readLine();
			}

			read.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
