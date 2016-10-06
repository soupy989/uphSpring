package hello;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import DAO.UserDAO;
import DAO.UserDAOImpl;

@SpringBootApplication
@Configuration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean 
    public DataSource getDataSource()
    {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	dataSource.setUrl("jdbc:sqlserver://uph.database.windows.net:1433;database=uphTest;user=uphAdmin@uph;password=uphPassword;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    	dataSource.setUsername("uphAdmin@uph");
    	dataSource.setPassword("uphPassword!");
    	
    	return dataSource;
    }
    
    @Bean
    public UserDAO getUserDao()
    {
    	return new UserDAOImpl(getDataSource());
    }
}

