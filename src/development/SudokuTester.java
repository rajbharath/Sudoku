package development;

public class SudokuTester {
	int size = 9;

	public int[][] getSeed() {
		int[][] seed = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				seed[i][j] = IOWrapper.readInt();
				IOWrapper.print(seed[i][j] + "");
			}

		}
		return seed;
	}

	public static void main(String[] args) {
		Solver solver = new Solver();
		solver.setSeed(new SudokuTester().getSeed());
		solver.solve();
		solver.display();
	}
}
