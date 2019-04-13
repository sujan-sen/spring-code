package com.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringBasic implements CommandLineRunner {

	@Autowired
	@Qualifier("saving")
	private IAccount saving;
	
	@Autowired
	@Qualifier("current")
	private IAccount current;
	
	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args)  {
		SpringApplication.run(SpringBasic.class, args);
	}

	public void run(String... args) throws Exception {
		
		SavingsAccount s=(SavingsAccount) context.getBean("saving", IAccount.class);
		System.out.println("Default ::"+s.getType());
		s.setType("Recurring");
		System.out.println("Modified ::"+s.getType());
		
		
		ConfigurableApplicationContext configContext = (ConfigurableApplicationContext)context;
		SingletonBeanRegistry beanRegistry = configContext.getBeanFactory();
		IAccount bean=new SavingsAccount();
		
		beanRegistry.registerSingleton("newSavings", bean);
		SavingsAccount newSavings=(SavingsAccount) context.getBean("newSavings", IAccount.class);
		System.out.println("Default ::"+newSavings.getType());
		
		BeanDefinitionRegistry  beanDefinitionRegistry =(BeanDefinitionRegistry) configContext.getAutowireCapableBeanFactory();
		beanDefinitionRegistry.removeBeanDefinition("saving");
		
		System.out.println("Re-registering a bean");
		IAccount newBean=new SavingsAccount();
		
		beanRegistry.registerSingleton("saving", newBean);
		System.out.println("Bean registered");
		
		//Validating
		s=(SavingsAccount) context.getBean("saving", IAccount.class);
		System.out.println("Default ::"+s.getType());
		
		
	}

	
}
