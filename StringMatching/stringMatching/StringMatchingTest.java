package stringMatching;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringMatchingTest {

	@Test
	void testMatch1() { //cuando la palabra es mas grande que el texto
		String text="hoy curse";
		String pattern="hoy curse Estadistica";
		System.out.println(StringMatching.match(text,pattern));
	}
	
	@Test
	void testMatch2() { //cuando son iguales
		String text="mañana rindo Algoritmos II";
		String pattern="mañana rindo Algoritmos II";
		System.out.println(StringMatching.match(text,pattern));
	}
	
	@Test
	void testMatch3() { //cuando aparece en el centro
		String text="mañana sera un gran dia";
		String pattern="sera un";
		System.out.println(StringMatching.match(text,pattern));
	}

	@Test
	void testMatchKmp() {
		fail("Not yet implemented");
	}

}
