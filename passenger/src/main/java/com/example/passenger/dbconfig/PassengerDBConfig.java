package com.example.passenger.dbconfig;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "passengerEntityManagerFactory", transactionManagerRef = "passengerTransactionManager")
public class PassengerDBConfig {

    @Primary
    @Bean(name = "passengerDatasource")
    @ConfigurationProperties(prefix = "spring.passenger.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();

    }

    @Bean(name = "passengerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("passengerDatasource") DataSource dataSource) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("com.example.passenger.passenger")
                .persistenceUnit("Passenger")
                .build();
    }

    @Bean(name = "passengerTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("passengerEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}