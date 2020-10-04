package edu.anatomist.apigeteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApiGetewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGetewayApplication.class, args);
	}

}

@RestController
class Hello {

	@RequestMapping("/")
	String index() {
		return "Hello world";
	}
}
