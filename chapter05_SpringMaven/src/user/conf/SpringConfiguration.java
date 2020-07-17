package user.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import user.bean.UserDTO;
import user.dao.UserDAOMybatis;
import user.main.HelloSpring;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;

@ComponentScan("user.*")
@Configuration
public class SpringConfiguration {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Bean
	public HelloSpring helloSpring() {
		HelloSpring helloSpring = new HelloSpring();
		return helloSpring;
	}
	@Bean
	public UserInsertService userInsertService() {
		UserInsertService userInsertService = new UserInsertService(); 
		return userInsertService;
	}
	@Bean
	public UserSelectService userSelectService() {
		UserSelectService userSelectService = new UserSelectService(); 
		return userSelectService;
	}
	@Bean
	public UserUpdateService userUpdateService() {
		return new UserUpdateService();
	}
	@Bean
	public UserDeleteService userDeleteService() {
		return new UserDeleteService();
	}
	@Bean
	public UserDTO userDTO() {
		return new UserDTO();
	}
	@Bean
	public UserDAOMybatis userDAOMybatis() {
		return new UserDAOMybatis();
	}
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");//org.apache.commons.dbcp2.BasicDataSource
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("c##java");
		basicDataSource.setPassword("bit");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);
		return basicDataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(){
		//방법 두가지
		PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();
		ClassPathResource mapper = new ClassPathResource("user/dao/userMapper.xml");
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(resource.getResource("spring/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(mapper);
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean;
	}
	@Bean
	public SqlSessionTemplate sqlSession(){
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactory);
		
		return sqlSession;
	}
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	
}
