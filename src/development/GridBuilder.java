package development;

public class GridBuilder {

	public Grid build(int[][] seed) {

		int length = seed.length;
		Cell[][] cells = new Cell[length][length];
		for (int rowIndex = 0; rowIndex < length; rowIndex++)
			for (int columnIndex = 0; columnIndex < length; columnIndex++) {
				cells[rowIndex][columnIndex] = CellFactory.getCell(
						seed[rowIndex][columnIndex], rowIndex, columnIndex);
			}
		return new Grid(cells);
	}
}
