package batch.demo.model;

import batch.helper.ICsvHeader;

public class TestHeader implements ICsvHeader{
	
	public TestHeader(){
		
	}
	
	@Override
	public Object[] getHeaders(){
		return new Object[]{"«¢«¤«Ç«£","Ù£îñ"};
	}
}
