package projektarbete;

import java.util.Scanner;

public class Solver {
	public matris solved = new matris(); 
	private matris matrix;
	private matris inMatris = matrix;

	/*
	 * public boolean solveStart() { return solve(0,0); }
	 * 
	 * public boolean solve(int j, int k) { if(j==9) { // om programmet låtit
	 * rekursionen nå out of bound så finns lösning... return true; } for(int n=1;
	 * i<=9;i++) { if(check(j,k,n)) { return solve(jjnext,knext) // Hur lösa detta
	 * skitet med nya rader...? } } return false; }
	 */

	public boolean initialCheck(matris matrix) {
		boolean res = true;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (!matrix.check(x, y, matrix.numbers[x][y])) {
					return false;
				}
			}
		}
		return res;
	}

	public boolean newSolver(matris matrix, int row, int col) {
		if (matrix.numbers[row][col] != 0) {// går bara vidare om redan ifyllt;
			if (row == 8 && col == 8) {
				return true;
			}
			if (col < 8) {
				return newSolver(matrix, row, col + 1);
			} else {
				return newSolver(matrix, row + 1, 0);
			}

		}

		for (int n = 1; n <= 9; n++) {
			if (matrix.check(row, col, n)) {
				matrix.numbers[row][col] = n;
				if (row == 8 && col == 8) {
					return true;
				}
				if (col < 8) {
					return newSolver(matrix, row, col + 1);
				} else {
					return newSolver(matrix, row + 1, 0);
				}
			}
			System.out.println("vid rad " + row + " kolumn " + col + "  försökte vi sätta in " + n);
		}
		if (col == 8 && row == 8) {
			return false;
		}
		return false;
	}

	public void simpleSolverIni() {

	}
	public matris answerMatrix(matris m) {
		matris solvedSoduku = m; 
		System.out.println("solved soduku is");
		solvedSoduku.print(); 
		return solvedSoduku;
	}

	public void simpleSolver(matris matrix) {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if ((x == 8 && y == 8)&&matrix.numbers[8][8]!=0) {
					System.out.println("nått slutet");
					matris matrix2 = new matris();
					for (int a = 0; a < 9; a++) {
						for (int b = 0; b < 9; b++) {
							solved.addEntry(a, b, matrix.numbers[a][b]);
						}
					}
					matrix2.print();
					System.out.println("   ");
					matris.numbersSolved = matrix2.numbers;
					answerMatrix(matrix2); 
					return ;
				}

				if (matrix.numbers[x][y] == 0) {
					for (int n = 1; n < 10; n++) {
						if (matrix.check(x, y, n)) {
							matrix.numbers[x][y] = n;
							simpleSolver(matrix);
							matrix.numbers[x][y] = 0;
						}
					}
					// System.out.println("Shiieeeet");
					return;
				}
			}
		}
		System.out.println("fooooool");
		return;
	}

	public matris getMatrix() {
		return matrix;
	}

	public void setMatrix(matris matrix) {
		this.matrix = matrix;
	}

}
