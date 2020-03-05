package projektarbete;

public class matris {
	// en 9*9 matris som ska hålla koll på alla entries
	public  int[][] numbers = new int[9][9];
	public static int[][] numbersSolved = new int[9][9];

	public matris() {
	}
	
	public void allZeros() {
		for (int i = 0; i < 9; i++) {
			for (int k = 0; i < 9; i++) {
				numbers[i][k] = 0;
			}
		}
	}

	public void addEntry(int row, int column, int value) {
		numbers[row][column] = value;
	}

	public void clear() { // clears the board
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				numbers[k][i] = 0;

			}
		}
	}

	public boolean rcCheck(int row, int column, int value) {// returns false if unallowed
		// kollar om finns på raden
		if (value == 0) {
			return true;
		}
		for (int i = 0; i < 9; i++) {
			if (value == numbers[row][i]&&(i!=column)) {
				return false;
			}
		}
		// kollar om finns på kolumnen
		for (int k = 0; k < 9; k++) {
			if (value == numbers[k][column]&&(k!=row)) {
				return false;
			}
		}
		return true;
	}

	public void print() {
		for (int k = 0; k < 9; k++) {
			for (int i = 0; i < 9; i++) {
				System.out.print(numbers[k][i] + " ");
			}
			System.out.print('\n');
		}
	}

	public boolean check(int row, int column, int value) {
		if (value == 0) {
			return true;
		}
		if ((!rcCheck(row, column, value))||(!regionCheck(row,column,value))) { // OBS har tagit bort regionCheck för felsökning. 
			return false;
		}
		return true;
	}

	// kollar 3x3 boxar
	public boolean regionCheck(int row, int column, int value) {
		// box högst upp til vänster.
		if (row < 3 && column < 3) {
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {
					if ((value == numbers[i][k])&&(i!=row)&&k!=column) {
						return false;
					}
				}
			}
		}
		// högst upp mitt.
		if ((row < 3) && (column >= 3 && column < 6)) {
			for (int k = 3; k < 6; k++) {
				for (int i = 0; i < 3; i++) {
					if ((value == numbers[i][k])&&(i!=row)&&k!=column) {
						return false;
					}
				}
			}
		}
		// högst upp höger.
		if ((row < 3) && (column >= 6)) {
			for (int k = 6; k < 9; k++) {
				for (int i = 0; i < 3; i++) {
					if ((value == numbers[i][k])&&(((i!=row)&&(k!=column)))) {
						return false;
					}
				}
			}
		}

		// ***************** Mittemellanhöjd***********************
		// mitthöjd vänster
		if ((row >= 3 && row < 6) && column < 3) {
			for (int k = 0; k < 3; k++) {
				for (int i = 3; i < 6; i++) {
					if ((value == numbers[i][k])&&(i!=row)&&k!=column) {
						return false;
					}
				}
			}
		}
		// mitthöjd mitt.
		if ((row >= 3 && row < 6) && (column >= 3 && column < 6)) {
			for (int k = 3; k < 6; k++) {
				for (int i = 3; i < 6; i++) {
					if (value == numbers[i][k]&&(i!=row)&&k!=column) {
						return false;
					}
				}
			}
		}
		// mitthöjd höger.
		if ((row >= 3 && row < 6) && (column >= 6)) {
			for (int k = 6; k < 9; k++) {
				for (int i = 3; i < 6; i++) {
					if (value == numbers[i][k]&&(i!=row)&&k!=column) {
						return false;
					}
				}
			}
		}

		// ****************Längst ner*******************
		// längst ner vänster
		if ((row >= 6 && row < 9) && column < 3) {
			for (int k = 0; k < 3; k++) {
				for (int i = 6; i < 9; i++) {
					if (value == numbers[i][k]&&(i!=row)&&k!=column) {
						return false;
					}
				}
			}
		}
		// längst ner mitt.
		if ((row >= 6 && row < 9) && (column >= 3 && column < 6)) {
			for (int k = 3; k < 6; k++) {
				for (int i = 6; i < 9; i++) {
					if (value == numbers[i][k]&&(i!=row)&&k!=column) {
						return false;
					}
				}
			}
		}
		// längst ner höger.
		if ((row >= 6) && (column >= 6)) {
			for (int k = 6; k < 9; k++) {
				for (int i = 6; i < 9; i++) {
					if (value == numbers[i][k]&&(i!=row)&&k!=column) {
						return false;
					}
				}
			}
		}

		return true;
	}
}