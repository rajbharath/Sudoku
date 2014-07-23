package development;

public abstract class Cell {

	private static final int DEFAULT_CELLVALUE = 0;
	int columnIndex;
	int rowIndex;
	int value;

	public int getColumnIndex() {
		return columnIndex;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public int getValue() {
		return value;
	}

	public Cell(int rowIndex, int columnIndex) {
		this(rowIndex, columnIndex, DEFAULT_CELLVALUE);
	}

	public Cell(int rowIndex, int columnIndex, int value) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.value = value;
	}

	@Override
	public String toString() {
		return this.getValue() + "";
	}

	public abstract int apply(int value);
}
