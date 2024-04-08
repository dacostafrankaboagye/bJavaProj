package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource myDataSource = new DriverManagerDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost/demo?serverTimezone=America/New_York");
        myDataSource.setUsername("root");
        myDataSource.setPassword("70722023Frank");
        
        return myDataSource;
    }
}
