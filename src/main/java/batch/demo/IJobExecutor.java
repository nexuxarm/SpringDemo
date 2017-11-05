package batch.demo;

import org.slf4j.Logger;

import batch.demo.mapper.TestMapper;

public interface IJobExecutor {
	//�� ����ȣ��
	public void execute(String key, String name, Logger logger) throws Exception;
	//����� ����ܰ�
	public void init() throws Exception;
	public void start() throws Exception;
	public void process() throws Exception;
	public void end() throws Exception;
	//����ó��
	public void exception(Exception ex) throws Exception;
}
