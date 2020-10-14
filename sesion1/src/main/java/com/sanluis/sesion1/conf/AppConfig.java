package com.sanluis.sesion1.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = {
		@ComponentScan("com.sanluis.sesion1.service"),
		@ComponentScan("com.sanluis.sesion1.dao")
})
public class AppConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource());
	    sessionFactory.setPackagesToScan("com.sanluis.sesion1.model");
	    sessionFactory.setHibernateProperties(hibernateProperties());
	
	    return sessionFactory;
	}
	
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tareas?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("alberto");
        dataSource.setPassword("4lb3rT0o");
 
        return dataSource;
    }
 
    @Bean
    public HibernateTransactionManager getTransactionManager() {
       HibernateTransactionManager transactionManager = new HibernateTransactionManager();
       transactionManager.setSessionFactory(sessionFactory().getObject());
       return transactionManager;
    }
 
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
 
        return hibernateProperties;
    }
}
