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
	void testRepetition7() {
		String text="(Karl o Carl Friedrich Gauss; Brunswick, actualactual Alemania, 1777 - Gotinga, id., 1855) Matemático, físico y astrónomo alemán. Nacidonacido en el seno de unauna familiafamilia humilde humilde, desde muy tempranatemprana edad Karl Friedrich Gauss Gauss dio muestrasmuestras de una prodigiosaprodigiosa capacidad capacidad para laslas matemáticas";
		System.out.println(LongestRepetition.repetition(text));
	}//se espera que devuelva "prodigiosa"
	
	@Test
	void testRepetition8() {
		String text="Alan Turing fuefue un brillantebrillante matemático, criptoanalista criptoanalista e informático teórico nacido nacido el veintitrés de Juniojunio de 1912 en Maida Vale un distrito residencial al oeste oeste de Londres. Turing, ademas ademas de ser un brillante científico era homosexual, lo cualcual le costó lala vidavida el siete dede junio de 1954.\"; ";
		System.out.println(LongestRepetition.repetition(text));
	}//se espera que devuelva "criptoanalista"
	
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
	
	@Test
	void testRepetitionDc7() {
		String text="(Karl o Carl Friedrich Gauss; Brunswick, actualactual Alemania, 1777 - Gotinga, id., 1855) Matemático, físico y astrónomo alemán. Nacidonacido en el seno de unauna familiafamilia humilde humilde, desde muy tempranatemprana edad Karl Friedrich Gauss Gauss dio muestrasmuestras de una prodigiosa prodigiosa capacidad capacidad para laslas matemáticas";
		System.out.println(LongestRepetition.repetitionDc(text));
	}//se espera que devuelva "prodigiosa"
	
	@Test
	void testRepetitionDc8() {
		String text="Alan Turing fuefue un brillantebrillante matemático, criptoanalista criptoanalista e informático teórico nacido nacido el veintitrés de Juniojunio de 1912 en Maida Vale un distrito residencial al oeste oeste de Londres. Turing, ademas ademas de ser un brillante científico era homosexual, lo cualcual le costó lala vidavida el siete dede junio de 1954.\"; ";
		System.out.println(LongestRepetition.repetitionDc(text));
	}//se espera que devuelva "criptoanalista"

}
