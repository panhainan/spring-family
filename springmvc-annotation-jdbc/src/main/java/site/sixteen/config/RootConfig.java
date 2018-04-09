package site.sixteen.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfig.class)
@ComponentScan(basePackages = {"site.sixteen.dao", "site.sixteen.service", "site.sixteen.config", "site.sixteen.exception"}
)
/*excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
        }*/
public class RootConfig {

/*    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setUsername("root");
        ds.setPassword("123456");
        ds.setInitialSize(5);
        ds.setMaxTotal(10);
        return ds;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }*/
}
