package development;

public class ColumnRule implements IRule {

	@Override
	public boolean isApplicable(Grid grid, Cell cell) {

		int columnIndex = cell.getColumnIndex();
		int cellValue = cell.getValue();
		for (int rowIndex = 0; rowIndex < grid.size(); rowIndex++) {
			if (rowIndex != cell.getRowIndex()
					&& grid.getCell(rowIndex, columnIndex).getValue() == cellValue) {
				return false;
			}

		}
		return true;

	}

}
