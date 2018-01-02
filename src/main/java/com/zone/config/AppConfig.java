package com.zone.config;




import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;


@EnableWebMvc
@Configuration
@ComponentScan({ "com.zone.*" })
@EnableTransactionManagement
/*@PropertySource("classpath:config.properties")*/
public class AppConfig {
	
/*	@Value("${mysql.url}")
	private String mysqlURL;
	
	@Value("${mysql.username}")
	private String mysqlUsername;
	
	@Value("${mysql.password}")
	private String mysqlPassword;*/
	
	//=== Hibernate DataBase Connection ======//
	
	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		builder 
					.scanPackages("com.zone.*")
					.addProperties(getHibernateProperties());
		
		return builder.buildSessionFactory();
		
	}
	
	
	private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return prop;
    }
	
	@Bean(name = "dataSource")
	public BasicDataSource dataSource() {		
		BasicDataSource ds = new BasicDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/zone_2017");
		ds.setUsername("root");
		ds.setPassword("admin");		
		return ds;
	}
		
	@Bean
	public HibernateTransactionManager txManager(){
		return new HibernateTransactionManager(sessionFactory());
		
	}

	//====== Spring MVC Config ==========//
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	@Bean
	public ViewResolver getCsvViewResolver(){
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasename("views");
		resolver.setOrder(1);
		return resolver;
		
	}
	
	@Bean
	public ContextLoaderListener contextLoaderListener(){
		return new ContextLoaderListener();
		
	}
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher(){
		return new HttpSessionEventPublisher();
	}
	
	

	
}