package batch.demo;

import org.slf4j.Logger;

import batch.demo.mapper.TestMapper;

public interface IJobExecutor {
	//잡 실행호출
	public void execute(String key, String name, Logger logger) throws Exception;
	//잡실행 서브단계
	public void init() throws Exception;
	public void start() throws Exception;
	public void process() throws Exception;
	public void end() throws Exception;
	//에러처리
	public void exception(Exception ex) throws Exception;
}
