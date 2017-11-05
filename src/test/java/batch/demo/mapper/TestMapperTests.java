package batch.demo.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapperTests {
	@Autowired
	TestMapper testMapper;
	
   @Test
    public void mapperSelectTest() throws Exception {	   
	   List<batch.demo.model.Test> list = testMapper.selectByExample(null);
	   assertThat(list.size()).isGreaterThan(0);	   
    }
}
