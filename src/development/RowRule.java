package development;

public class RowRule implements IRule {

	@Override
	public boolean isApplicable(Grid grid, Cell cell) {
		int rowIndex = cell.getRowIndex();
		int cellValue = cell.getValue();
		for (int columnIndex = 0; columnIndex < grid.size(); columnIndex++) {
			if (columnIndex != cell.getColumnIndex()
					&& grid.getCell(rowIndex, columnIndex).getValue() == cellValue) {
				return false;
			}

		}
		return true;
	}

}
