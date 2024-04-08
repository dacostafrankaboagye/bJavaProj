package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"repositories"})
public class ProjectConfig {

    @Bean
    public DataSource dataSource(){
        var dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/demo?serverTimezone=America/New_York"); // we are using the default port "the db name is "demo" "
        dataSource.setUsername("===");
        dataSource.setPassword("===");

        return dataSource;

    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        // will use the data source to connect to our database
        return new JdbcTemplate(dataSource());

    }

}
