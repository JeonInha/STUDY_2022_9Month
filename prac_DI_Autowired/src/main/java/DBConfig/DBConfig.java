package DBConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSourse() {
		DataSourse ds = new DataSourse();
	}
}
