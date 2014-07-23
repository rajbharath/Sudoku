package development;

public class Grid {

	private Cell[][] cells;

	public Grid(Cell[][] cells) {
		this.cells = cells;
	}

	public int size() {
		return cells.length;
	}

	public Cell getCell(int rowIndex, int columnIndex) {
		return cells[rowIndex][columnIndex];
	}

}
