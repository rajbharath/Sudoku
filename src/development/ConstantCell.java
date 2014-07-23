package development;

public class ConstantCell extends Cell {

	public ConstantCell(int rowIndex, int columnIndex, int value) {
		super(rowIndex, columnIndex, value);
	}

	@Override
	public int apply(int value) {
		return -1;
	}

}
