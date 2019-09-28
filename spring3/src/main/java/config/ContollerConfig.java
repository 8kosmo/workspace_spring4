package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sts3.pojo.DeptController;

@Configuration
public class ContollerConfig {
	Logger logger = LoggerFactory.getLogger(ContollerConfig.class);
	@Bean
	public DeptController deptController() {
		logger.info("called DeptController():DeptController");
		DeptController deptController = new DeptController();
		return deptController;
	}
}
