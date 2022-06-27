package br.com.Project.Pattern.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringStarter {

	public static void main(String[] args) {
		SpringApplication.run(SpringStarter.class, args);
	}

}
