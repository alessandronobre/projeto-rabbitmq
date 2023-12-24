package com.devpro.msconta;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MscontaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscontaApplication.class, args);
	}

}
