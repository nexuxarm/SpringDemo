package batch.demo.model;

import batch.helper.ICsvRow;

public class TestRow extends Test implements ICsvRow {

	public TestRow() {
		super();
	}
	
	@Override
	public String[] getRow() {
		return new String[]{String.valueOf(this.getId()), String.valueOf(this.getName())};
	}
}
