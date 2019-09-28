package com.sts3.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;//junit
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceMyBatis {
	Logger logger = Logger.getLogger(DataSourceMyBatis.class);
	@Autowired
	public DataSource dataSource;//reference <hikariConfig>
	@Autowired
	public SqlSessionFactory sqlSessionFactory;
	@Test
	public void testMyBatis() {
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Connection con = dataSource.getConnection();
			logger.info("con : "+con);
			logger.info("sqlSession : "+sqlSession);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
