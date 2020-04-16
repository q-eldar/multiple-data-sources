package guru.springframework.multipledatasources.config;

import com.zaxxer.hikari.HikariDataSource;
import guru.springframework.multipledatasources.model.inventory.Tree;
import guru.springframework.multipledatasources.model.inventory.Seed;
import guru.springframework.multipledatasources.model.inventory.Shrub;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "guru.springframework.multipledatasources.dao.inventory",
        entityManagerFactoryRef = "inventoryEntityManagerFactory",
        transactionManagerRef= "inventoryTransactionManager"
)
public class InventoryDataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.inventory")
    public DataSourceProperties inventoryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.inventory.configuration")
    public DataSource inventoryDataSource() {
        return inventoryDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "inventoryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean inventoryEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(inventoryDataSource())
                .packages(Seed.class)
                .packages(Tree.class)
                .packages(Shrub.class)
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager inventoryTransactionManager(
            final @Qualifier("inventoryEntityManagerFactory") LocalContainerEntityManagerFactoryBean inventoryEntityManagerFactory) {
        return new JpaTransactionManager(inventoryEntityManagerFactory.getObject());
    }

}
