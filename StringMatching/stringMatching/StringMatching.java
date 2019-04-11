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
		//verifica si el texto es mas corto que la cadena buscada
		if(text.length()<pattern.length()) {
			return -1; 
		}
		int indexAux; //indice para comparar la cadena con el texto, dentro del segundo for
		int result=-1; //inicializacion
		int indexPattern=0;
		for(int indexText=0;indexText<text.length();indexText++) {
			indexAux=indexText; //inicializo la variable para usar en el for
			result=indexText;  //inicializo suponiendo que es donde comienza la cadena que busco
			for(indexPattern=0;indexPattern<pattern.length() && result!=-1;indexPattern++) {
				if(text.charAt(indexAux) == (pattern.charAt(indexPattern))) {
					indexAux++; //avanzo en el texto si los caracteres son iguales
				}
				else {
					result=-1; //si encuentro algun caracter distinto, deja de comparar la cadena
				}
			}
			if(result!=-1) {//si salio del for y no encontro algun caracter distinto
				return result; //devuelvo el indice donde comienzan a coincidir la cadena con el texto
			}
		}
		return result; //si recorrio todo el texto y no encontro la cadena buscada
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
