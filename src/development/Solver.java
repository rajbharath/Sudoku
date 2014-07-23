package development;

import java.util.ArrayList;

public class Solver {
	private Grid grid;
	private ArrayList<IRule> rules;

	public Solver() {
		rules = new ArrayList<IRule>();
		rules.add(new RowRule());
		rules.add(new ColumnRule());
		rules.add(new SquareRule());
	}

	public void setSeed(int[][] seed) {

		GridBuilder builder = new GridBuilder();
		this.grid = builder.build(seed);

	}

	public Grid solve() {
		// iterate over the 2d cell arrays
		for (int rowIndex = 0; rowIndex < getSize(); rowIndex++) {
			for (int columnIndex = 0; columnIndex < getSize(); columnIndex++) {
				display();
				// apply possible values in each cell - if any rules failed
				int appliedResult = applyValueTo(grid.getCell(rowIndex,
						columnIndex));
				if (appliedResult == -1)
					continue;
				else if (appliedResult > 9) {
					// go back algorithm
					if (columnIndex != 0) {
						grid.getCell(rowIndex, columnIndex).apply(0);
						columnIndex -= 2;

					} else if (rowIndex != 0) {
						rowIndex--;
						columnIndex = 0;
					} else {
						rowIndex = 0;
						columnIndex = 0;
					}
				} else {
					// verifying rules are applicable
					if (!checkForRules(grid.getCell(rowIndex, columnIndex))) {
						// continue with the same indexes
						if (rowIndex > 0)
							rowIndex--;
						if (columnIndex >= 0)
							columnIndex--;

					}
					continue;
				}

			}
		}

		return grid;
	}

	private boolean checkForRules(Cell cell) {
		boolean result = true;
		for (IRule rule : rules) {
			result &= rule.isApplicable(grid, cell);
		}
		return result;
	}

	private int applyValueTo(Cell cell) {
		int seed = cell.value + 1;
		return cell.apply(seed);
	}

	private int getSize() {
		// TODO Auto-generated method stub
		return grid.size();
	}

	public String[] display() {
		String[] displayContent = new String[getSize()];
		IOWrapper.println("------------------");
		for (int rowIndex = 0; rowIndex < getSize(); rowIndex++) {
			displayContent[rowIndex] = "";
			for (int columnIndex = 0; columnIndex < getSize(); columnIndex++) {
				displayContent[rowIndex] += " "
						+ grid.getCell(rowIndex, columnIndex).toString();
			}
			IOWrapper.println(displayContent[rowIndex]);
		}
		IOWrapper.println("------------------");
		return displayContent;
	}
}
