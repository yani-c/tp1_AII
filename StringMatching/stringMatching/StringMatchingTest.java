package stringMatching;

import org.junit.jupiter.api.Test;

class StringMatchingTest {


	@Test
	void testMatch1() { //cuando la palabra es mas grande que el texto
		String text="hoy curse";
		String pattern="hoy curse Estadistica";
		System.out.println(StringMatching.match(text,pattern));
	}//Se espera que devuelva -1
	
	@Test
	void testMatch2() { //cuando son iguales
		String text="mañana rindo Algoritmos II";
		String pattern="mañana rindo Algoritmos II";
		System.out.println(StringMatching.match(text,pattern));
	}//Se espera que devuelva 0
	
	@Test
	void testMatch3() { //cuando aparece en el centro
		String text="mañana sera un gran dia";
		String pattern="sera un";
		System.out.println(StringMatching.match(text,pattern));
	}//Se espera que devuelva 7
	
	@Test
	void testMatch4() { //cuando se busca una subcadena de una cadena continua
		String text="eeei";
		String pattern="eei";
		System.out.println(StringMatching.match(text,pattern));
	}//Se espera que devuelva 1

	@Test
	void testMatch5() { //cuando aparece en el centro
		String text="hola buen dia";
		String pattern=" ";
		System.out.println(StringMatching.match(text,pattern));
	}//Se espera que devuelva 4
	
	@Test
	void testMatch6() { //que aparezca mas de una vez a ver si devuelve el primero
		String text="hoy es un muy muy buen dia";
		String pattern="muy";
		System.out.println(StringMatching.match(text,pattern));
	}//Se espera que devuelva 10

	@Test
	void testMatch7() { //con mayusculas y minusculas
		String text="hola BUeN dia";
		String pattern="buen"; 
		System.out.println(StringMatching.match(text,pattern));
	}//Se espera que devuelva -1
	
	@Test
	void testMatch8() {//cuando el texto es largo y la palabra esta casi al final
		String text="Alan Turing fue un brillante matemático, criptoanalista e informático teórico nacido el veintitrés de Junio de 1912 en Maida Vale un distrito residencial al oeste de Londres. Turing, ademas de ser un brillante científico era homosexual, lo cual le costó la vida el siete de junio de 1954."; 
		String pattern="1954";
		System.out.println(StringMatching.match(text,pattern));
	}//Se espera que devuelva 283
	
	@Test
	void testMatchKmp1() { //cuando la palabra es mas grande que el texto
		String text="hoy curse";
		String pattern="hoy curse Estadistica";
		System.out.println(StringMatching.matchKmp(text,pattern));
	}//Se espera que devuelva -1
	
	@Test
	void testMatchKmp2() { //cuando son iguales
		String text="mañana rindo Algoritmos II";
		String pattern="mañana rindo Algoritmos II";
		System.out.println(StringMatching.matchKmp(text,pattern));
	}//Se espera que devuelva 0
	
	@Test
	void testMatchKmp3() { //cuando aparece en el centro
		String text="mañana sera un gran dia";
		String pattern="sera un";
		System.out.println(StringMatching.matchKmp(text,pattern));
	}//Se espera que devuelva 7
	
	@Test
	void testMatchKmp4() { //cuando se busca una subcadena de una cadena continua
		String text="eeei";
		String pattern="eei";
		System.out.println(StringMatching.matchKmp(text,pattern));
	}//Se espera que devuelva 1

	@Test
	void testMatchKmp5() { //cuando aparece en el centro
		String text="hola buen dia";
		String pattern=" ";
		System.out.println(StringMatching.matchKmp(text,pattern));
	}//Se espera que devuelva 4
	
	@Test
	void testMatchKMp6() { //que aparezca mas de una vez a ver si devuelve el primero
		String text="hoy es un muy muy buen dia";
		String pattern="muy";
		System.out.println(StringMatching.matchKmp(text,pattern));
	}//Se espera que devuelva 10

	@Test
	void testMatchKmp7() { //con mayusculas y minusculas
		String text="hola BUeN dia";
		String pattern="buen"; 
		System.out.println(StringMatching.matchKmp(text,pattern));
	}//Se espera que devuelva -1
	
	@Test
	void testMatchKmp8() {//cuando el texto es largo y la palabra esta casi al final
		String text="Alan Turing fue un brillante matemático, criptoanalista e informático teórico nacido el veintitrés de Junio de 1912 en Maida Vale un distrito residencial al oeste de Londres. Turing, ademas de ser un brillante científico era homosexual, lo cual le costó la vida el siete de junio de 1954."; 
		String pattern="1954";
		System.out.println(StringMatching.matchKmp(text,pattern));
	}//Se espera que devuelva 283

}
