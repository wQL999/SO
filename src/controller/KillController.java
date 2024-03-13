package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {
	
	static BufferedReader read;
	static Runtime run = Runtime.getRuntime();
	static Process process;


	public KillController() {
		// TODO Auto-generated constructor stub
	}
	
	private String os() {
		return System.getProperty("os.name").toLowerCase();
	}
	
	public void listaProcessos() {
		String osType = os();
		String command;
		if(osType.contains("win")) {
			command = "tasklist /fo table";
			try {
				process = run.exec(command);

				read = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = read.readLine();

				while (line != null) {
					System.out.println(line);
					line = read.readLine();
				}
				read.close();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else if(osType.contains("nix")) {
			command = "ps -ef";
			try {
				process = run.exec(command);

				read = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = read.readLine();

				while (line != null) {
					System.out.println(line);
					line = read.readLine();
				}
				read.close();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void mataPid(int pid) {
		String osType = os();
		String command;
		if(osType.contains("win")) {
			command = "taskkill /pid " + pid;
			try {
				process = run.exec(command);

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else if(osType.contains("nix")) {
			command = "kill -9 " + pid;
			try {
				process = run.exec(command);

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void mataNome(String nome) {
		String osType = os();
		String command;
		if(osType.contains("win")) {
			command = "taskkill /im " + nome;
			try {
				process = run.exec(command);

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else if(osType.contains("nix")) {
			command = "pkill -f " + nome;
			try {
				process = run.exec(command);

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
