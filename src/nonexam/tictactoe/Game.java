package nonexam.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[][] board = TicTacToe.genBoard();
		boolean playing = true;
		boolean humansTurn = Math.random() < 0.5;
		final boolean humanIsX = humansTurn;
		if (humansTurn) {
			message("By random coin flip, you will go first.");
		}
		else {
			message("By random coin flip, I will go first.");
		}
		
		List<Move> locs = allMoves();
		while (playing) {
			if (TicTacToe.winFor("x", board) || TicTacToe.winFor("o", board)) {
				boolean humanWins = 
						TicTacToe.winFor("x", board) && humanIsX
						||
						TicTacToe.winFor("o", board) && !humanIsX;
				if (humanWins) {
					message("You win!");
				}
				else {
					message("I win!");
				}
				playing = false;
			}
			else if (TicTacToe.boardFull(board)) {
				message("Game over, board is full, no winner");
				playing = false;
			}
			else {
				if (humansTurn) {
					Move m = promptForAvailableMove(locs, in);
					locs.remove(m);
					TicTacToe.makeMove(humanIsX ? "x" : "o", board, m.row, m.col);
					System.out.println("After your move");
				}
				else {
					int choice = (int)(Math.random() * locs.size());
					Move m = locs.remove(choice);
					TicTacToe.makeMove(humanIsX ? "o" : "x", board, m.row, m.col);
					System.out.println("After my move");
				}
				System.out.println(TicTacToe.prettyString(board));
				humansTurn = !humansTurn;
			}
		}

	}
	
	private static List<Move> allMoves() {
		List<Move> ans = new ArrayList<Move>(9);
		for (int r=0; r < 3; ++r) {
			for (int c=0; c < 3; ++c) {
				ans.add(new Move(r,c));
			}
		}
		return ans;
	}
	
	private static Move promptForAvailableMove(List<Move> avail, Scanner in) {
		Move ans = null;
		do {
			System.out.print("Which row? ");
			int row = in.nextInt();
			System.out.print("Which col? ");
			int col = in.nextInt();
			ans = new Move(row, col);
			if (!avail.contains(ans)) {
				message("Move " + ans + " not available; try again");
			}
		} while (!avail.contains(ans));	
		return ans;
	}
	
	private static void message(String message) {
		JOptionPane.showMessageDialog(null, message);

	}

}
