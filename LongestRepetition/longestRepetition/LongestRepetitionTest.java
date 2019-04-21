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
	}//se espera que devuelva "dia" o "muy"
	
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
	void testRepetition6() {
		String text="hola que tal hola";
		System.out.println(LongestRepetition.repetition(text));
	}//se espera que devuelva ""
	
	
	@Test
	void testRepetitionDc1() {
		String text="hola queque taltal comocomo estas";
		System.out.println(LongestRepetition.repetitionDc(text));
	}//se espera que devuelva "como"
	
	@Test
	void testRepetitionDc2() {
		String text="hola";
		System.out.println(LongestRepetition.repetitionDc(text));
	}//se espera que devuelva ""

	@Test
	void testRepetitionDc3() {
		String text="hoy es un diadia muymuy lindo";
		System.out.println(LongestRepetition.repetitionDc(text));
	}//se espera que devuelva "dia" o "muy"
	
	@Test
	void testRepetitionDc4() {
		String text="hoy es un muy muylindo";
		System.out.println(LongestRepetition.repetitionDc(text));
	}//se espera que devuelva " muy"

	@Test
	void testRepetitionDc5() {
		String text="holalacomoesta";
		System.out.println(LongestRepetition.repetitionDc(text));
	}//se espera que devuelva "la"
	
	@Test
	void testRepetitionDc6() {
		String text="hola que tal hola";
		System.out.println(LongestRepetition.repetitionDc(text));
	}//se espera que devuelva ""

}
