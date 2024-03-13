package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RedesController {

	static BufferedReader read;
	static Runtime run = Runtime.getRuntime();
	static Process process;

	public RedesController() {
		// TODO Auto-generated constructor stub
	}

	private String os() {
		return System.getProperty("os.name").toLowerCase();
	}

	public void ip() {
		String osType = os();
		String command;

		if (osType.contains("win")) {
			command = "ipconfig";
			try {
				process = run.exec(command);

				read = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = read.readLine();

				while (line != null) {
					StringBuilder ss = new StringBuilder();
					if (line.contains("Ethernet")) {
						ss.append(line);
						// System.out.println(line.trim());
					}

					if (line.contains("IPv4")) {
						ss.append(line);
						// System.out.println(line.trim().replace(". ", ""));
					}

					if (!ss.toString().contains("Ethernet") && !ss.toString().contains("IPv4")) {
						ss.delete(0, ss.length());
					} else {
						System.out.println(ss.toString().trim().replace(". ", ""));
					}
					line = read.readLine();
				}
				read.close();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		} else if (osType.contains("unix")) {
			command = "ifconfig";
			try {
				process = run.exec(command);

				read = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = read.readLine();

				while (line != null) {
					StringBuilder ss = new StringBuilder();
					if (line.contains("mtu")) {
						ss.append(line);
						// System.out.println(line.trim());
					}

					if (line.contains("inet")) {
						ss.append(line);
						// System.out.println(line.trim().replace(". ", ""));
					}

					if (!ss.toString().contains("mtu") && !ss.toString().contains("inet")) {
						ss.delete(0, ss.length());
					} else {
						System.out.println(ss.toString().trim().replace(". ", ""));
					}
					line = read.readLine();
				}
				read.close();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

	}

	public void ping() {
		String osType = os();
		String command;

		if (osType.contains("win")) {
			command = "ping -4 -n 10 www.google.com.br";
			try {
				process = run.exec(command);

				read = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = read.readLine();

				while (line != null) {
					System.out.println("Realizando processo, aguarde!");
					
					if(line.contains("dia")) {
						String[] p = line.trim().split(" ");
						System.out.println("Média de ping igual a " + p[p.length-1]);
					}

					line = read.readLine();
				}
				read.close();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		} else if(osType.contains("unix")) {
			command = "ping -4 -c 10 www.google.com.br";
			try {
				process = run.exec(command);

				read = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = read.readLine();

				while (line != null) {
					System.out.println("Realizando processo, aguarde!");
					
					if(line.contains("avg")) {
						String[] p = line.trim().split(" ");
						String[] pl = p[3].split("/");
						System.out.println("Média de pings igual a " + pl[1] + "ms.");
					}

					line = read.readLine();
				}
				read.close();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

	}

}
