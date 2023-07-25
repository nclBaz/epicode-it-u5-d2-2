package riccardogulin.u5d2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class U5d2Application {

	public static void main(String[] args) {
		SpringApplication.run(U5d2Application.class, args);
		configWithComponent();
	}

	public static void configWithComponent() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5d2Application.class);

		TestApplicationProperties test = ctx.getBean(TestApplicationProperties.class);

		System.out.println(test.toString());


		ctx.close();
	}

}
