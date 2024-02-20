package com.clx.registerDevices.config.retail;

import com.clx.registerDevices.entity.retail.User;
import org.springframework.beans.factory.annotation.Qualifier;
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
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "retailEntityManagerFactory",
        transactionManagerRef = "retailTransactionManager",
        basePackages = {"com.clx.registerDevices.repository.retail"})
public class RetailJpaConfiguration {

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean retailEntityManagerFactory(@Qualifier("retailDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource).packages(User.class).build();
    }

    @Bean
    public PlatformTransactionManager retailTransactionManager(@Qualifier("retailEntityManagerFactory") LocalContainerEntityManagerFactoryBean retailEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(retailEntityManagerFactory.getObject()));
    }
    
}
