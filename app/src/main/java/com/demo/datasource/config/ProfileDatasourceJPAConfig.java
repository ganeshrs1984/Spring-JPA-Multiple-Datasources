package com.demo.datasource.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

 

@Configuration
public class ProfileDatasourceJPAConfig {

	@Configuration	
	@EnableJpaRepositories(
	    //Dao Entity Class
	    basePackages = "com.demo.dao.tech", 
	    entityManagerFactoryRef = "profileEntityManager", 
	    transactionManagerRef = "profileTransactionManager"
	)
	public class ProfileConfig {
		 
	    @Bean
	    public LocalContainerEntityManagerFactoryBean profileEntityManager() {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(profileDataSource());
	        //Model Entity Class
	        em.setPackagesToScan(new String[] { "com.demo.entity.technology" });
	 
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        em.setJpaVendorAdapter(vendorAdapter);
	        HashMap<String, Object> properties = new HashMap<>();
	        	properties.put("hibernate.hbm2ddl.auto","update");
	        	properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
	        em.setJpaPropertyMap(properties);
	 
	        return em;
	    }
	 
	    @Bean
	    public DataSource profileDataSource() {
	  
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
	        dataSource.setUsername("postgres");
	        dataSource.setPassword("AbcD#1234");
	        dataSource.setDriverClassName("org.postgresql.Driver");	        
	 
	        return dataSource;
	    }
	 
	    @Bean
	    public PlatformTransactionManager profileTransactionManager() {
	  
	        JpaTransactionManager transactionManager
	          = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(
	          profileEntityManager().getObject());
	        return transactionManager;
	    }
	}
}
