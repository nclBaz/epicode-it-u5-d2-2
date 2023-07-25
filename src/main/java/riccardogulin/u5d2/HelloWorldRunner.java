package riccardogulin.u5d2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component // NON DIMENTICARE QUESTA ANNOTAZIONE!!
@Slf4j
@Order(0) // Verrà eseguito per primo
public class HelloWorldRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("Hello World");
	}

}
