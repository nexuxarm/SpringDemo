package batch.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
public class MapperConfigFactory {
	
	@Autowired
	private PlatformTransactionManager txManager;
	
	@Autowired
	public MapperConfig config;
	
	public MapperConfig getConfig() {
		return config;
	}
	
	public PlatformTransactionManager getTransactionManager() {
		return txManager;
	}
}
