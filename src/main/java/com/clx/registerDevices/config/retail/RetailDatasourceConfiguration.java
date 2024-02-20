package com.clx.registerDevices.config.retail;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class RetailDatasourceConfiguration {


    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.retail")
    public DataSourceProperties retailDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @Primary
    public DataSource retailDataSource() {
        return retailDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate retailJdbcTemplate(@Qualifier("retailDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
