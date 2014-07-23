package development;

public class VariableCell extends Cell {

	public VariableCell(int rowIndex, int columnIndex) {
		super(rowIndex, columnIndex);
	}

	@Override
	public int apply(int value) {
		this.value = value;
		return this.value;
	}

}
