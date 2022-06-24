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
		return typeText("Digite \"X\" ou \"O\": ");
	}

	String[][] selectRoll(String[][] tab, String player, String iaPlayer) {
		printText("1st Player - Jogador " + player);
		int line;
		int column;
		while (true) {
			while (true) {
				line = typeInt("Digite a linha: ");
				column = typeInt("Digite a coluna: ");
				line--;
				column--;
				if (!((line >= 0 && line <= 2) && (column >= 0 && column <= 2))) {
					printError("Os valores devem estar entre 1 e 3.");
				} else {
					break;
				}
			}
			if (!(tab[line][column].equals(player) || tab[line][column].equals(iaPlayer))) {
				tab[line][column] = player;
				break;
			} else {
				printError("Esta posição já está marcada!");
			}
		}
		return tab;
	}

	String iaPlayer(String iaPlayer, String player) {
		if (player.equalsIgnoreCase("X")) {
			iaPlayer = "O";
		} else {
			iaPlayer = "X";
		}
		return iaPlayer;
	}

	void iaRoll(String[][] tab, String iaPlayer) {

	}
}
