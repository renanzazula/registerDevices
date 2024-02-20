package com.clx.registerDevices.config.eCorp;

import com.clx.registerDevices.entity.ecorp.RegisteredDevices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "ecorpEntityManagerFactory",
        transactionManagerRef = "ecorpTransactionManager",
        basePackages = {"com.clx.registerDevices.repository.ecorp"})
public class ecorpJpaConfiguration {


    @Bean
    public LocalContainerEntityManagerFactoryBean ecorpEntityManagerFactory(@Qualifier("ecorpDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource).packages(RegisteredDevices.class).build();
    }

    @Bean
    public PlatformTransactionManager ecorpTransactionManager(@Qualifier("ecorpEntityManagerFactory") LocalContainerEntityManagerFactoryBean ecorpEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(ecorpEntityManagerFactory.getObject()));
    }

}
