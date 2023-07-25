package riccardogulin.u5d2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(1) // Verrà eseguito per secondo
public class AnotherRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("Another Runner");
	}

}
