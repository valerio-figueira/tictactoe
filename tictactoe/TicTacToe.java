package tictactoe;

public class TicTacToe {
	static void printText(String description) {
		System.out.println(description);
	}

	static void printError(String description) {
		System.err.println(description);
	}

	public static void main(String[] args) {
		String[][] tab = new String[3][3];
		Controller c = new Controller();
		String player = null;
		String iaPlayer = null;
		int empate = 0;

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				tab[i][j] = " ";
			}
		}

		player = c.selectPlayer(player);
		iaPlayer = c.iaPlayer(iaPlayer, player);

		while (true) {
			c.printTab(tab);
			c.selectRoll(tab, player, iaPlayer);
			c.iaRoll(tab, player, iaPlayer);
			if (c.getWinner(tab, player)) {
				c.printTab(tab);
				printText("Parabéns, você ganhou!");
				break;
			}
			if (c.getWinner(tab, iaPlayer)) {
				c.printTab(tab);
				printError("GAME OVER");
				break;
			}
			empate++;
			if (c.getEmpate(empate)) {
				printText("Empate!");
				break;
			}

		}

	}

}
