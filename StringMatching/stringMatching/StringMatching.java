package stringMatching;

public class StringMatching {
	/**
	 * Calcula String Matching usando Fuerza Bruta.
	 * @param text texto a analizar
	 * @param pattern patron a buscar en el texto
	 * @returns indice de la primera ocurrencia de pattern en text, en caso de que exista,
	 * o -1 en caso que no se encuentre. 
	 */
	public static int match (String text, String pattern) {
		//convierte todo el texto y la palabra ingresada en minuscula
		text.toLowerCase();
		pattern.toLowerCase();
		//comienza
		if(text.length()<pattern.length()) {
			return -1;
		}
		int result=-1;
		int indexPattern=0;
		for(int indexText=0;indexText<text.length() && indexPattern<pattern.length();indexText++) {
			if(text.charAt(indexText) == (pattern.charAt(indexPattern))) {
				if(indexPattern==0) {
					result=indexText;
					
				}
				indexPattern++;
			}
			else {
				result=-1;
				indexPattern=0;
			}
		}
		return result; //resolver el problema
	}
	
	
	/**
	 * Calcula String Matching usando Knuth-Morris-Pratt.
	 * @param text texto a analizar
	 * @param pattern patron a buscar en el texto
	 * @returns indice de la primera ocurrencia de pattern en el text, en caso que exista,
	 * o -1 en caso que no se encuentre.
	 */
	public static int matchKmp(String text, String pattern) {
		return -1;
	}
}
