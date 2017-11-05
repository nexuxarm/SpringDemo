package batch.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import batch.demo.mapper.MapperConfigFactory;
import batch.demo.mapper.TestMapper;
import batch.helper.ValidateHelper;

@Component
public class JobRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory
			.getLogger(JobRunner.class);
	
	@Autowired
	MapperConfigFactory mcf;

	
	@Override
	public void run(String... args) throws Exception {
		
		//logger.debug("args(" + args[0] + ")");
		
		if (!ValidateHelper.CheckArgs(args)) {
			logger.error("�����߻�.", new Exception("�Ķ���Ͱ� �����ϴ�."));
			return;
		}
		
		String key = args[0].trim();
		logger.debug("key(" + key + ")");
		
		//�������� Ŭ������ ����ߴ� ġ��...
		try {
			String className = "batch.demo.job.TestJob";
			JobExecutor job = (JobExecutor) Class.forName(className).newInstance();	
			job.setConfigFactory(mcf);
			
			job.execute(key, className, LoggerFactory.getLogger(job.getClass()));
			
			
		} catch (Exception e) {
			logger.error("�����߻�.", e);
		}		
	}
}
