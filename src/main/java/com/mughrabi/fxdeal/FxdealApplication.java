package com.mughrabi.fxdeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mughrabi.*"})
@EnableJpaRepositories(basePackages = {"com.mughrabi.*"})
@EnableWebMvc
@EntityScan(basePackages = {"com.mughrabi.*"})
public class FxdealApplication {

	public static void main(String[] args) {
		SpringApplication.run(FxdealApplication.class, args);
	}

}
