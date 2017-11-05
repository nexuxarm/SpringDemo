package batch.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory
			.getLogger(DemoApplication.class);
	
	@PostConstruct
	public void logPostConstruct() {
		logger.debug("Demo.logPostConstruct Debug Message");
		logger.trace("Demo.logPostConstruct Trace Message");
	}
	
	@PreDestroy
	public void logPreDestroy() {
		logger.debug("Demo.PreDestroy Debug Message");
		logger.trace("Demo.PreDestroy Trace Message");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args).close();
	}
	
//	@Bean
//	CommandLineRunner demo (TestMapper testMapper){
//		return args -> {
//			List<Test> list = testMapper.selectByExample(null);
//			for (Test test : list) {
//				logger.debug("ID(" + test.getId() + "), Name(" + test.getName() + ")");
//			}
//		};
//	}
}
