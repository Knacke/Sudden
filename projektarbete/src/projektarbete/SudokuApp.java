package projektarbete;

public class SudokuApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		matris matrix = new matris();
		matrix.clear();
		matrix.addEntry(0, 2, 8);
		matrix.addEntry(0, 5, 9);
		matrix.addEntry(0, 7, 6);
		matrix.addEntry(0, 8, 2);
		matrix.addEntry(1, 8, 5);

		matrix.addEntry(2, 0, 1);
		matrix.addEntry(2, 2, 2);
		matrix.addEntry(2, 3, 5);

		matrix.addEntry(3, 3, 2);
		matrix.addEntry(3, 4, 1);
		matrix.addEntry(3, 7, 9);

		matrix.addEntry(4, 1, 5);
		matrix.addEntry(4, 6, 6);

		matrix.addEntry(5, 0, 6);
		matrix.addEntry(5, 7, 2);
		matrix.addEntry(5, 8, 8);

		matrix.addEntry(6, 0, 4);
		matrix.addEntry(6, 1, 1);
		matrix.addEntry(6, 3, 6);
		matrix.addEntry(6, 5, 8);

		matrix.addEntry(7, 0, 8);
		matrix.addEntry(7, 1, 6);
		matrix.addEntry(7, 4, 3);
		matrix.addEntry(7, 6, 1);

		matrix.addEntry(8, 6, 4);

		matrix.print();
		Solver matrixSolver = new Solver();

		// boolean res = matrixSolver.newSolver(matrix,0,0);
		// nyMatris.print();
		matris matrix2 = new matris(); 
	   matrixSolver.simpleSolver(matrix);
		matrix.print();
		//System.out.println(matrix3);
		
		for( int i = 0; i<9; i++)
			{
			System.out.println(matrix.numbersSolved[i][0]); 
			}
		


//		for (int j = 0; j < 9; j++) {
//			for (int i = 0; i < 9; i++) {
//
//				System.out.print(resMatris[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		System.out.println(resMatris); 


	}

}
