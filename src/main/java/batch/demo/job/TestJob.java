package batch.demo.job;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import batch.demo.JobExecutor;
import batch.demo.JobRunner;
import batch.demo.mapper.MapperConfig;
import batch.demo.mapper.MapperConfigFactory;
import batch.demo.mapper.TestMapper;
import batch.demo.model.RowData;

public class TestJob extends JobExecutor {
	
	private static final Logger logger = LoggerFactory
			.getLogger(JobRunner.class);
	
	@Override
	public void process() throws Exception {		
		MapperConfigFactory mcf = this.getConfigFactory();
		MapperConfig mc = mcf.getConfig();
		TestMapper tm = mc.testMapper;
		
		PlatformTransactionManager tx = mcf.getTransactionManager();
		
		try {
			List<RowData> list = tm.selectByCode("aaa");
			
			for (RowData rowData : list) {

				Integer id = ((BigDecimal) rowData.getValue("ID")).intValue();
				String name = rowData.getValue("NAME").toString();
				
			    TransactionDefinition def = new DefaultTransactionDefinition();
			    TransactionStatus status = tx.getTransaction(def);
			    int updateResult = -1;
			    
				try {					
					updateResult = tm.updateByCode(id.toString(), name + "(수정)");
					if (id%2 == 0) throw new Exception("짝수");
				} catch (Exception e) {
					tx.rollback(status);					
					logger.info("롤백 : " + rowData.getDebugString());
					continue;
				}
				
				tx.commit(status);
				logger.info("커밋 : " + rowData.getDebugString());
			}
		} catch (Exception e) {
			logger.error("에러발생", e);
		}
	}
}
