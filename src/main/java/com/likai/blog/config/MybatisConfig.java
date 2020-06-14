package com.likai.blog.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * mybatis配置类
 * 
 * @author likai
 *
 */
@MapperScan({"com.likai.blog.dao","com.likai.common.dao"}) // 扫描dao
@Configuration
public class MybatisConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);// 获取数据源
		sessionFactory.setTypeAliasesPackage("com.likai.blog.po");// 扫描model
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath*:sqlmap/*.xml"));// 扫描xml文件
		return sessionFactory.getObject();
	}

	/**
	 * 这里配置的文件路径较死，实际可以配置更灵活。
	 * 主要考虑因素在于工程是否业务复杂，如果不算特别复杂，那可能只会出现一个dao、一个model、一个sqlmap目录
	 * 若业务过于繁杂，也可能会一个业务模块一个dao目录，因为不这样的话只有一个dao目录，那目录下会出现过多文件，那时候必然不能这样配置死目录了
	 */

	//说明：配置类的意义在于配置项分类明确，且避免了配置全部集中于一个配置文件导致的内容过长
}
