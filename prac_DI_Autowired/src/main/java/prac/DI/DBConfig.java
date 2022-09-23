package prac.DI;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSourse() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/my_db");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
}
