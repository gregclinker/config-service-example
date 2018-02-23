package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${message1}")
	private String message1;

	@Value("${message2}")
	private String message2;

	@RequestMapping("/message")
	String getMessage() {
		return message1 + "\n" + message2 + "\n";
	}
}