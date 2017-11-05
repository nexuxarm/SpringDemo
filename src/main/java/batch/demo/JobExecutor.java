package batch.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import batch.demo.mapper.MapperConfigFactory;
import batch.demo.mapper.TestMapper;
import batch.helper.ValidateHelper;

public class JobExecutor implements IJobExecutor {
	//배치코드
	protected String key = null;
	//배치이름
	protected String name = null;
	//로거
	protected Logger logger = null;
	//매퍼
	protected MapperConfigFactory mcf = null;
	
	public void setConfigFactory(MapperConfigFactory mcf) {
		this.mcf = mcf;
	}
	
	public MapperConfigFactory getConfigFactory() {
		return this.mcf;
	}
	
	@Override
	public void execute(String key, String name, Logger logger) throws Exception {
		try {
			this.key = key;
			this.name = name;
			this.logger = logger;
			
			init();
			start();
			process();
			end();			
		} catch (Exception e) {
			exception(e);
		}
	}
	
	@Override
	public void init() throws Exception {
		if (!ValidateHelper.CheckNotNull(key)) {
			throw new Exception("JobExecutor.key 가 없습니다.");
		}
		
		if (!ValidateHelper.CheckNotNull(name)) {
			throw new Exception("JobExecutor.name 가 없습니다.");
		}
		
		if (logger == null) {
			throw new Exception("JobExecutor.logger 가 없습니다.");
		}
	}
	
	@Override
	public void start() throws Exception {
		logger.debug(name + "(" + key + ") 시작.");
	}

	@Override
	public void process() throws Exception {
		throw new Exception(name + "(" + key + ") 의 처리코드(process)를 기숧하십시요.");
	}

	@Override
	public void end() throws Exception {
		logger.debug(name + "(" + key + ") 종료.");
	}

	@Override
	public void exception(Exception ex) throws Exception {
		if (logger == null) {
			logger = LoggerFactory
					.getLogger(JobExecutor.class);
		}
		
		if (ValidateHelper.CheckNotNull(name) && ValidateHelper.CheckNotNull(key)) {
			logger.error(name + "(" + key + ") 에러.", ex);	
		} else {
			logger.error("에러.", ex);
		}
	}
}
