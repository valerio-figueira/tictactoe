package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Controller {
	Scanner scanner;
	Random random;

	void printText(String description) {
		System.out.println(description);
	}

	void printError(String description) {
		System.err.println(description);
	}

	String typeText(String description) {
		scanner = new Scanner(System.in);
		System.out.print(description);
		return scanner.nextLine();
	}

	int typeInt(String description) {
		scanner = new Scanner(System.in);
		System.out.print(description);
		return scanner.nextInt();
	}

	String[][] printTab(String[][] tab) {
		printText("::::: HASH GAME :::::");
		System.out.println(":::::::::::::::::::::");
		for (int i = 0; i < tab.length; i++) {
			System.out.print(":::::::|");
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(tab[i][j]);
				System.out.print("|");
			}
			System.out.print(":::::::");
			System.out.println();
		}
		System.out.println(":::::::::::::::::::::");
		return tab;
	}

	String selectPlayer(String player) {
		while (true) {
			player = typeText("Digite \"X\" ou \"O\": ");
			if (player.equalsIgnoreCase("X") || player.equalsIgnoreCase("O")) {
				if (player.equals("x")) {
					player = "X";
				} else if (player.equals("o")) {
					player = "O";
				}
				break;
			} else {
				printError("Opção Inválida!");
			}
		}
		return player;
	}

	String[][] selectRoll(String[][] tab, String player, String iaPlayer) {
		printText("1st Player - Jogador " + player);
		;
		while (true) {
			int line = typeInt("Digite a linha: ");
			int column = typeInt("Digite a coluna: ");
			line--;
			column--;
			if (!((line >= 0 && line <= 2) && (column >= 0 && column <= 2))) {
				printError("Os valores devem estar entre 1 e 3.");
			} else {
				if (!(tab[line][column].equals(player) || tab[line][column].equals(iaPlayer))) {
					tab[line][column] = player;
					break;
				} else {
					printError("Esta posição já está marcada!");
				}
			}
		}
		return tab;
	}

	String iaPlayer(String iaPlayer, String player) {
		if (player.equals("X")) {
			iaPlayer = "O";
		} else {
			iaPlayer = "X";
		}
		return iaPlayer;
	}

	String[][] iaRoll(String[][] tab, String player, String iaPlayer) {
		random = new Random();
		Integer stop = 0;
		while (true) {
			int line = random.nextInt(3);
			int column = random.nextInt(3);
			if (!(tab[line][column].equals(player) || tab[line][column].equals(iaPlayer))) {
				tab[line][column] = iaPlayer;
				break;
			} else {
				for (int i = 0; i < tab.length; i++) {
					for (int j = 0; j < tab[i].length; j++) {
						if (tab[i][j].equals(iaPlayer) || tab[i][j].equals(player)) {
							stop++;
						}
					}
				}
				if (stop.equals(9)) {
					break;
				}
			}
		}
		return tab;
	}

	boolean getWinner(String[][] tab, String player) {
		if (checkLine(tab, player)) {
			return true;
		} else if (checkColumn(tab, player)) {
			return true;
		} else if (checkDiagonal(tab, player)) {
			return true;
		}
		return false;
	}

	boolean checkLine(String[][] tab, String player) {
		int row = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[0][i].equals(player)) {
				row++;
				if (row == 3) {
					return true;
				}
			}
		}
		row = resetRow(row);
		for (int i = 0; i < tab.length; i++) {
			if (tab[1][i].equals(player)) {
				row++;
				if (row == 3) {
					return true;
				}
			}
		}
		row = resetRow(row);
		for (int i = 0; i < tab.length; i++) {
			if (tab[2][i].equals(player)) {
				row++;
				if (row == 3) {
					return true;
				}
			}
		}
		return false;
	}

	boolean checkColumn(String[][] tab, String player) {
		int column = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i][0].equals(player)) {
				column++;
				if (column == 3) {
					return true;
				}
			}
		}
		column = resetColumn(column);
		for (int i = 0; i < tab.length; i++) {
			if (tab[i][1].equals(player)) {
				column++;
				if (column == 3) {
					return true;
				}
			}
		}
		column = resetColumn(column);
		for (int i = 0; i < tab.length; i++) {
			if (tab[i][2].equals(player)) {
				column++;
				if (column == 3) {
					return true;
				}
			}
		}
		return false;
	}

	boolean checkDiagonal(String[][] tab, String player) {
		if (tab[0][0] == tab[1][1] && tab[0][0] == tab[2][2] && tab[0][0].equals(player)) {
			return true;
		} else if (tab[2][0] == tab[1][1] && tab[2][0] == tab[0][2] && tab[2][0].equals(player)) {
			return true;
		}
		return false;
	}

	int resetRow(int row) {
		return row = 0;
	}

	int resetColumn(int column) {
		return column = 0;
	}

	boolean getEmpate(int empate) {
		if (empate == 9) {
			return true;
		}
		return false;
	}

}
