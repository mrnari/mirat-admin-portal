package com.novelis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.novelirs.config.WebSecurityConfig;

@SpringBootApplication
@ComponentScan({ "com.novelirs.*" })
@Import({ WebSecurityConfig.class })
@EnableAutoConfiguration
public class MiratAdminPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiratAdminPortalApplication.class, args);
	}
}