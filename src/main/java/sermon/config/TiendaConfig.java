package sermon.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
//@ComponentScan(basePackages={"sermon.db"})
//@EnableTransactionManagement
public class TiendaConfig {
	
	/*
	@Autowired
	private Environment env;
	*/
	/*
	@Bean(name="basicSourceBasic", destroyMethod="close")
	public BasicDataSource dataSourceBasic() {
		BasicDataSource bs = new BasicDataSource();
		
		//String host = "69.61.93.208"; //"127.0.0.1"; //"127.9.115.130";
		String host = "127.0.0.1"; //"127.9.115.130";
		String port = "3306"; //"3306";
		String username = "root";
		//String password = "";
		String password = "test123";
		
		System.out.println("host : " + host);
		System.out.println("port : " + port);
		System.out.println("username : " + username);
		System.out.println("jdbc:mysql://" + host + ":" + port + "/jbossews?autoReconnect=true");
		
		bs.setDriverClassName("com.mysql.jdbc.Driver");
		//String url = String.format("jdbc:mysql://%s:%s/jbossews", host, port);
		//bs.setUrl("jdbc:mysql://127.9.115.130:3306/jbossews?autoReconnect=true");
		bs.setUrl("jdbc:mysql://" + host + ":" + port + "/jbossews?autoReconnect=true");
		
		//bs.setUrl(url);
		bs.setUsername(username);
		bs.setPassword(password);
		
		//bs.setInitialSize(3);
		//bs.setMaxActive(10);
		if (bs != null && ! bs.isClosed()) {
			System.out.println("DB Connection open for business !!");
		}else {
			System.out.println("Opps it's shutdown this business.. too bad, go somewhere else :p ");
		}
		return bs;
	}
	*/
	/*
	@Bean(name="basicSource", destroyMethod="close")
	public ComboPooledDataSource dataSource() {
		ComboPooledDataSource cp = new ComboPooledDataSource();
		try {
			//String host = "69.61.93.208"; //"127.0.0.1"; //"127.9.115.130";
			String host = "127.0.0.1"; //"127.9.115.130";
			String port = "3306"; //"3306";
			String username = "root";
			//String password = "";
			String password = "test123";
			
			System.out.println("host : " + host);
			System.out.println("port : " + port);
			System.out.println("username : " + username);
			System.out.println("jdbc:mysql://" + host + ":" + port + "/jbossews?autoReconnect=true");
			
			cp.setDriverClass("com.mysql.jdbc.Driver");
			cp.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/jbossews?autoReconnect=true");
			cp.setUser(username);
			cp.setPassword(password);
			cp.setMaxPoolSize(55);
			cp.setMinPoolSize(10);
			cp.setMaxStatements(35);
			cp.setTestConnectionOnCheckout(true);
			cp.setInitialPoolSize(5);
			cp.setIdleConnectionTestPeriod(1);
			cp.setAcquireIncrement(3);
			cp.setAutoCommitOnClose(false);
			cp.setNumHelperThreads(5);
			
			System.out.println("DB Connection open for business !!");
		} catch (PropertyVetoException e) {
			System.out.println("DataSourcePool Error !! ");
			System.out.println(e.getMessage());
			System.out.println("Opps it's shutdown this business.. too bad, go somewhere else :p ");
		}
		return cp;
	}
	*/
	@Bean(name="basicSource", destroyMethod="close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		String host = "69.61.93.57"; //"127.0.0.1"; //"127.9.115.130";
		//String host = "127.0.0.1"; //"127.9.115.130";
		String port = "3306"; //"3306";
		String username = "root";
		String password = "";
		//String password = "test123";
		
		System.out.println("host : " + host);
		System.out.println("port : " + port);
		System.out.println("username : " + username);
		System.out.println("jdbc:mysql://" + host + ":" + port + "/jbossews?autoReconnect=true");
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://" + host + ":" + port + "/jbossews?autoReconnect=true");
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(5);
		ds.setMaxActive(25);
		ds.setMaxIdle(5);
		ds.setMinIdle(1);
		ds.setRemoveAbandoned(true);
		ds.setRemoveAbandonedTimeout(3);
		
		return ds;
	}
	@Bean
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}


