package com.rk.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import com.rk.springboot.service.AccountService;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SbAopApplication {
	
	@Autowired
	public RestTemplate restTemplate;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SbAopApplication.class, args);
		AccountService accountService=context.getBean(AccountService.class);
		accountService.getNumberOfRecods();
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}

//http://localhost:8080/add/employee?empID=%22102%22&firstName=%22fname%22&secondName=%22sname%22
//http://localhost:8080/remove/employee?empID=%22101%22
//http://localhost:8080/remove/employee?empID=%22106%22


//http://localhost:8080/add/account?id=110&name=%22Name%22&amount=100.50
//http://localhost:8080/add/account?id=120&name=%22Name%22&amount=100.50
//http://localhost:8080/delete/account?id=120
//http://localhost:8080/checkbalance/account?id=110