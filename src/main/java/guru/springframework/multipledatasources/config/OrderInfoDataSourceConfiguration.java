package guru.springframework.multipledatasources.config;

import guru.springframework.multipledatasources.model.orderinfo.Order;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "guru.springframework.multipledatasources.dao.orderinfo",
        entityManagerFactoryRef = "orderInfoEntityManagerFactory",
        transactionManagerRef= "orderInfoTransactionManager")
public class OrderInfoDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("app.datasource.orderinfo")
    public DataSourceProperties orderInfoDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.orderinfo.configuration")
    public DataSource orderInfoDataSource() {
        return orderInfoDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "orderInfoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean orderInfoEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(orderInfoDataSource())
                .packages(Order.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager orderInfoTransactionManager(
            final @Qualifier("orderInfoEntityManagerFactory") LocalContainerEntityManagerFactoryBean orderInfoEntityManagerFactory) {
        return new JpaTransactionManager(orderInfoEntityManagerFactory.getObject());
    }
}
