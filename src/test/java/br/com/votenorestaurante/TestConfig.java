package br.com.votenorestaurante;

import org.hsqldb.jdbc.JDBCDataSource;
import org.springframework.context.annotation.*;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@ComponentScan
public class TestConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("default");
    }

    @Bean @Scope("prototype")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean @DependsOn("entityManagerFactory")
    public DataSource dataSource() {
        Map<String, Object> props = entityManagerFactory().getProperties();
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.setUrl((String) props.get("javax.persistence.jdbc.url"));
        dataSource.setUser("sa");
        dataSource.setPassword("");

        DatabasePopulatorUtils.execute(databasePopulator(), dataSource);

        return dataSource;
    }

    private DatabasePopulator databasePopulator() {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(resourceLoader.getResource("classpath:dados.sql"));

        return databasePopulator;
    }
}
