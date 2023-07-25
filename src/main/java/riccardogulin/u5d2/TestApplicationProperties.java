package riccardogulin.u5d2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
@PropertySource("classpath:application.properties")
// SE NON USO QUESTA ANNOTAZIONE NON RIUSCIRA' A LEGGERE IL FILE APPLICATION.PROPERTIES
public class TestApplicationProperties {
	@Value("${application.supersecret}")
	// IL VALORE VIENE SETTATO POST COSTRUZIONE
	String supersecret;

	public TestApplicationProperties() {
		// Qua il valore iniettato è null
//		System.out.println(this.supersecret);

	}

	@PostConstruct
	// fa si che il metodo venga chiamato immediatamente dopo la costruzione
	// dell'oggetto
	private void useValue() {
		// Qua il valore iniettato è invece disponibile
		System.out.println(this.supersecret);
	}
}
