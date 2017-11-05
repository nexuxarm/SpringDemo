package batch.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import batch.demo.mapper.MapperConfigFactory;
import batch.demo.mapper.TestMapper;
import batch.helper.ValidateHelper;

public class JobExecutor implements IJobExecutor {
	//��ġ�ڵ�
	protected String key = null;
	//��ġ�̸�
	protected String name = null;
	//�ΰ�
	protected Logger logger = null;
	//����
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
			throw new Exception("JobExecutor.key �� �����ϴ�.");
		}
		
		if (!ValidateHelper.CheckNotNull(name)) {
			throw new Exception("JobExecutor.name �� �����ϴ�.");
		}
		
		if (logger == null) {
			throw new Exception("JobExecutor.logger �� �����ϴ�.");
		}
	}
	
	@Override
	public void start() throws Exception {
		logger.debug(name + "(" + key + ") ����.");
	}

	@Override
	public void process() throws Exception {
		throw new Exception(name + "(" + key + ") �� ó���ڵ�(process)�� ��D�Ͻʽÿ�.");
	}

	@Override
	public void end() throws Exception {
		logger.debug(name + "(" + key + ") ����.");
	}

	@Override
	public void exception(Exception ex) throws Exception {
		if (logger == null) {
			logger = LoggerFactory
					.getLogger(JobExecutor.class);
		}
		
		if (ValidateHelper.CheckNotNull(name) && ValidateHelper.CheckNotNull(key)) {
			logger.error(name + "(" + key + ") ����.", ex);	
		} else {
			logger.error("����.", ex);
		}
	}
}
