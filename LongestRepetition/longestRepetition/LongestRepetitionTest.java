package longestRepetition;



import org.junit.jupiter.api.Test;

class LongestRepetitionTest {

	@Test
	void testRepetition1() {
		String text="hola queque taltal comocomo estas";
		System.out.println(LongestRepetition.repetition(text));
	}//se espera que devuelva "como"
	
	@Test
	void testRepetition2() {
		String text="hola";
		System.out.println(LongestRepetition.repetition(text));
	}//se espera que devuelva ""
	
	@Test
	void testRepetition3() {
		String text="hoy es un diadia muymuy lindo";
		System.out.println(LongestRepetition.repetition(text));
	}//se espera que devuelva "dia"
	
	@Test
	void testRepetition4() {
		String text="hoy es un muy muylindo";
		System.out.println(LongestRepetition.repetition(text));
	}//se espera que devuelva " muy"

	@Test
	void testRepetition5() {
		String text="holalacomoesta";
		System.out.println(LongestRepetition.repetition(text));
	}//se espera que devuelva "la"
	
	@Test
	void testRepetitionDc() {
		System.out.println("");
	}

}
