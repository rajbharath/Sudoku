package development;

public class SquareRule implements IRule {

	@Override
	public boolean isApplicable(Grid grid, Cell cell) {
		int sqrtOfSize = (int) Math.sqrt(grid.size());

		int rowIndex = cell.getRowIndex() - (cell.getRowIndex() % sqrtOfSize);
		int columnIndex = cell.getColumnIndex()
				- (cell.getColumnIndex() % sqrtOfSize);

		int cellValue = cell.getValue();

		for (int i = 0; i < rowIndex + 3; i++) {
			for (int j = 0; j < columnIndex + 3; j++) {
				if (i != cell.getRowIndex() && j != cell.getColumnIndex()
						&& grid.getCell(i, j).getValue() == cellValue)
					return false;
			}

		}
		return true;
	}
}
