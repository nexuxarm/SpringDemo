package batch.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {	
	@Autowired
	public TestMapper testMapper;
}
