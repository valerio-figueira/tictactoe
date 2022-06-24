package tictactoe;

public class TicTacToe {
	static void printText(String description) {
		System.out.println(description);
	}

	public static void main(String[] args) {
		String[][] tab = new String[3][3];
		Controller c = new Controller();
		String player = null;
		String iaPlayer = null;

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				tab[i][j] = " ";
			}
		}

		c.printTab(tab);
		player = c.selectPlayer(player);
		iaPlayer = c.iaPlayer(iaPlayer, player);
		c.selectRoll(tab, player, iaPlayer);
		c.printTab(tab);

	}

}
