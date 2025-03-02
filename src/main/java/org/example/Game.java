package org.example;

import java.util.Scanner;

public class Game {
private String[][] board = new String[3][3];
private int moves = 0;
private boolean winner = false;

public void startGame() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("\nTerminal Tic Tac Toe\n");
	while (true) {
		System.out.println("==Menu Options==");
		System.out.println("1) New Game ");
		System.out.println("2) Quit\n");
		System.out.print("> ");
		int input = scanner.nextInt();
		if (input != 1 && input != 2) {
			System.out.println("\nPlease enter a valid menu option\n");
			continue;
		} else {
			switch (input) {
				case 1:
					newGame();
					break;
				case 2:
					System.out.println("Goodbye");
					break;
			}
		}
		break;
	}
}

public void drawFreshBoard() {
	System.out.println(" ");
	System.out.println(" " + "1" + " | " + "2" + " | " + " 3" + " ");
	System.out.println("   |   |    1");
	System.out.println("---+---+---  ");
	System.out.println("   |   |    2");
	System.out.println("---+---+---");
	System.out.println("   |   |    3");
}

public void newGame() {
	String player = "X";
	drawFreshBoard();
	nextMove(player);
}

public void validMoveChecker(String player, int row, int column) {
	if (board[row - 1][column - 1].equals("X") || board[row - 1][column - 1].equals("O")) {
		System.out.println("\n\nAlready taken! \n\n");
		nextMove(player);
	} else {
		makeMove(player, row, column);
	}
}

public void makeMove(String player, int row, int column) {
	board[row - 1][column - 1] = player;
	drawBoard(board);
	moves++;
	checkWin();
	if (!this.winner) {
		player = switchPlayer(player);
		nextMove(player);
	} else {
		System.out.println("=====\n");
		System.out.println(player + " wins!\n");
		System.out.println("=====");
		resetBoard();
		startGame();
	}
}


public void drawBoard(String[][] board) {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (board[i][j] == null) {
				board[i][j] = " ";
			}
			if (!board[i][j].equals("X") && !board[i][j].equals("O")) {
				board[i][j] = " ";
			}
		}
	}
	System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
	System.out.println("---+---+---");
	System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
	System.out.println("---+---+---");
	System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");

	int fillerNumber = 1;
	for (int i = 0; i < 3; i++) {
		fillerNumber++;
		for (int j = 0; j < 3; j++) {
			if (board[i][j].equals(" ")) {
				board[i][j] = (fillerNumber + "");
				fillerNumber++;
			}
		}
	}
}

public String switchPlayer(String player) {
	if (player.equals("X")) {
		player = "O";
	} else {
		player = "X";
	}
	return player;
}

public void nextMove(String player) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("\n"+player + "'s Turn\n");
	System.out.println("Enter a column and row to make your move (1-3)");
	System.out.print("Row > ");
	int row = scanner.nextInt();
	if (row < 1 || row > 3) {
		System.out.println("Invalid move");
		nextMove(player);
	}
	System.out.print("Column > ");
	int column = scanner.nextInt();
	if (column < 1 || column > 3) {
		System.out.println("Invalid move");
		nextMove(player);
	}
	if (moves != 0) {
		validMoveChecker(player, row, column);
	} else {
		makeMove(player, row, column);
	}
}

private void checkWin() {
	//Is there going to be a better way to check for a winner other than just raw if statements?
	if (board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2])) {
		this.winner = true;
	} else if (board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2])) {
		this.winner = true;
	} else if (board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])) {
		this.winner = true;
	} else if (board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0])) {
		this.winner = true;
	} else if (board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1])) {
		this.winner = true;
	} else if (board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2])) {
		this.winner = true;
	} else if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
		this.winner = true;
	} else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
		this.winner = true;
	} else if (moves >= 9) {
		System.out.println("\nNo more moves available. The game is a Draw!\n\n");
		resetBoard();
		startGame();
	} else {
		this.winner = false;
	}

}

private void resetBoard() {
	board = new String[3][3];
	this.winner = false;
	this.moves = 0;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (board[i][j] == null) {
				board[i][j] = " ";
			}
}
}}}
