package com.sanluis.spring.springmvc.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/todos?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("alberto");
        dataSource.setPassword("4lb3rT0o");
     
        return dataSource;
    }
    
    @Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();

		sfb.setDataSource(dataSource);
		sfb.setPackagesToScan("com.sanluis.spring.springmvc.vo");

		Properties props = new Properties();

		//props.setProperty("hibernate.hbm2ddl.auto", "create");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.setProperty(Environment.SHOW_SQL, "true");

		sfb.setHibernateProperties(props);
		
		try {
			sfb.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sfb.getObject();
	}
    
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);
     
        return transactionManager;
    }
}
