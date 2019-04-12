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
		int[] next= GenerateSuffixArray(pattern);
		int sizeText= text.length();
		int sizePattern= pattern.length();
		int indexText= 0;
		int indexPattern= 0;
		while(indexText<sizeText){
			if(pattern.charAt(indexPattern) == text.charAt(indexText)){
				indexPattern++;
				indexText++;
			}
			if(indexPattern == sizePattern){
				int modulo=-1;
				if(indexText<=indexPattern) modulo=indexPattern-indexText;
				if(indexPattern<indexText) modulo= indexText-indexPattern;
				return modulo;
			}
			else if(indexText < sizeText && pattern.charAt(indexPattern)!=text.charAt(indexText)){
				if(indexPattern != 0){
					indexPattern = next[indexPattern-1];	
				}
				else{
					indexText++;
				}
			}
		}
		return -1;
	}
	
	//Auxiliar para matchKmp
	public static int[] GenerateSuffixArray(String Pattern){
		int i= 1;
		int j= 0;
		int sizePattern= Pattern.length();
		final int N= sizePattern; 
		int[] next= new int[N];
		while(i<sizePattern){
	   	 	if(Pattern.charAt(i) == Pattern.charAt(j)){
		 		next[i]= j + 1;
		        j= j + 1;
		        i= i + 1;
			}
		    else if(j != 0){
		            j= next[j-1];
			}
		    else{
				next[i]= 0;
				i= i + 1;
			}
		}
		return next;
	}
	
}
