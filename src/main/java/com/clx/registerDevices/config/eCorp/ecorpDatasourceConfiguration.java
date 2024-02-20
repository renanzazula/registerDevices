package com.clx.registerDevices.config.eCorp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class ecorpDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.ecorp")
    public DataSourceProperties ecorpDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource ecorpDataSource() {
        return ecorpDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate ecorpJdbcTemplate(@Qualifier("ecorpDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
