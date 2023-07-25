package riccardogulin.u5d2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;
import riccardogulin.u5d2.tools.CustomMath;

@Slf4j
public class CustomMathTests {
	private static AnnotationConfigApplicationContext ctx;

	@BeforeAll // Corrispettivo di @BeforeClass di JUnit 4
	static void beforeAll() {
		log.info("Before All");
		ctx = new AnnotationConfigApplicationContext();

		// ctx.getBean();
	}

	@AfterAll
	static void afterAll() { // Corrispettivo di @AfterClass di JUnit 4
		log.info("After all");
		ctx.close();
	}

	@BeforeEach // Corrispettivo di @Before di JUnit 4
	void before() {
		log.info("Before Each");
	}

	@AfterEach // Corrispettivo di @After di JUnit 4
	void after() {
		log.info("After Each");
	}

	@Test
	void testSum() {
		log.info("Test1");
		int result = CustomMath.sum(2, 2);
		assertEquals(result, 4);
	}

	@Test // Obbligatoria questa annotazione per far runnare i test!
	// Se non annotiamo il test non viene eseguito!
	void testArraySum() {
		log.info("Test2");
		int result = CustomMath.sum(new int[] { 1, 2, 3 });
		assertEquals(result, 6);
	}

	@Test
	void testIfZero() {
		log.info("Test3");
		int result = CustomMath.sum(new int[] {});
		assertEquals(result, 0);
	}

	@Test
	@Disabled // // Corrispettivo di @Ignore di JUnit 4
	void testVariousAsserts() {
		log.info("Test4");

		List<String> list = Stream.of("Aldo", "Giovanni", "Giacomo").toList();

		assertFalse(list.contains("Ajeje"));
		assertEquals(list.size(), 3);

		assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
	}

	@ParameterizedTest // Indica che questo sarà un test di tipo parametrico
	@MethodSource("getParameters") // I parametri verranno forniti dal metodo statico "getParameters"
	void testWithDifferentParameters(int result, int first, int second) {
		assertEquals(result, CustomMath.sum(first, second));
	}

	static Stream<Arguments> getParameters() {
		// Metodo che fornisce i parametri al test parametrico
		// Ogni lista parametri avrà la forma seguente:
		// Arguments.arguments(risultato atteso, primo addendo, secondo addendo)

		return Stream.of(Arguments.arguments(4, 2, 2), Arguments.arguments(7, 3, 4), Arguments.arguments(100, 90, 10),
				Arguments.arguments(1000, 900, 100)); // Lista di set di parametri
	}
}
