package riccardogulin.u5d2.tools;

import org.springframework.stereotype.Component;

@Component
public class CustomMath {

	static public int sum(int a, int b) {
		return a + b;
	}

	static public int sum(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}

}
