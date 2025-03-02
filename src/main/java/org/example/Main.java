package org.example;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Terminal Tic Tac Toe\n");
	while (true) {
		System.out.println("==Menu Options==");
		System.out.println("1) New Game ");
		System.out.println("2) Quit");
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
public static void drawBoard(){
	System.out.println("   |   |   ");
	System.out.println("---+---+---");
	System.out.println("   |   |   ");
	System.out.println("---+---+---");
	System.out.println("   |   |   ");
}

public static void newGame() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Game Starting");
	String player = "X";
	System.out.println("X's turn.");
	drawBoard();
	System.out.println("Enter a column and row to make your move (1-3)");
	System.out.print("Row > ");
	int row = scanner.nextInt();
	System.out.print("Column > ");
	int column = scanner.nextInt();
	makeMove(player,row,column);
}
public static void makeMove(String player, int row, int column) {
	//gonna need some logic probably some sort of array or something to keep the moves
	System.out.println(" X |   |   ");
	System.out.println("---+---+---");
	System.out.println("   |   |   ");
	System.out.println("---+---+---");
	System.out.println("   |   |   ");
	player=switchPlayer(player);
	nextMove(player);

}
public static String switchPlayer(String player){
	if (player.equals("X")) {
		player = "O";
	} else {
		player = "X";
	}
	return player;
}
public static void nextMove(String player){
	Scanner scanner = new Scanner(System.in);
	System.out.println(player+"'s Turn");
	drawBoard();
	System.out.println("Enter a column and row to make your move (1-3)");
	System.out.print("Row > ");
	int row = scanner.nextInt();
	System.out.print("Column > ");
	int column = scanner.nextInt();
	makeMove(player,row,column);
}
}