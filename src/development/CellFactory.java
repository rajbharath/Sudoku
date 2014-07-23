package development;

public class CellFactory {
	public static Cell getCell(int value, int rowIndex, int columnIndex) {
		if (value == 0)
			return new VariableCell(rowIndex, columnIndex);
		else
			return new ConstantCell(rowIndex, columnIndex, value);
	}
}
