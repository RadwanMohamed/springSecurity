package com.coder.springsecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScans({
		@ComponentScan("com.coder.springsecuritydemo.controller"),
		@ComponentScan("com.coder.springsecuritydemo.config")
})
@EnableWebSecurity(debug = true)

public class SpringsecuritydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritydemoApplication.class, args);
	}

}
