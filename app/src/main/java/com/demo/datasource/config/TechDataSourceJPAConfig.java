package com.demo.datasource.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

public class TechDataSourceJPAConfig {

	 
	    @Bean
	    public LocalContainerEntityManagerFactoryBean techEntityManager() {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(techDataSource());
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
	    public DataSource techDataSource() {
	  
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setUrl("jdbc:postgresql://localhost:5432/db2database");
	        dataSource.setUsername("postgres");
	        dataSource.setPassword("AbcD#1234");
	        dataSource.setDriverClassName("org.postgresql.Driver");	        
	 
	        return dataSource;
	    }
	 
	    @Bean
	    public PlatformTransactionManager techTransactionManager() {
	  
	        JpaTransactionManager transactionManager
	          = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(
	          techEntityManager().getObject());
	        return transactionManager;
	    }
}
 
