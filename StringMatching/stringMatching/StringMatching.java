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
		int[] next= GenerateSuffixArray(pattern);//se inicializa el arreglo "next"
		int sizeText= text.length();
		int sizePattern= pattern.length();
		int indexText= 0;//inicializo indice para recorrer el texto
		int indexPattern= 0;//iniciaizo indice para recorrer el patron
		while(indexText<sizeText){//mientras no llegue al final del texto
			if(pattern.charAt(indexPattern) == text.charAt(indexText)){//si encuentro caracteres iguales
				indexPattern++;
				indexText++;
			}
			if(indexPattern == sizePattern){//si se correspondieron todos los caracteres del patron con alguna sub secuencia del texto
				int modulo; 
				if(indexText<=indexPattern)modulo=indexPattern-indexText;
				else modulo = indexText-indexPattern;
				return modulo;//devuelvo el modulo de indexText - indexPattern, que seria el indice del texto donde empiezan a coincidir
			}
			else if(indexText < sizeText && pattern.charAt(indexPattern)!=text.charAt(indexText)){//si no corresponden y no llegue al final del texto
				if(indexPattern != 0){//cuando no estoy al principio del patron
					indexPattern = next[indexPattern-1];//desplaza el patron tantas posiciones como sea necesario
				}
				else{
					indexText++;
				}
			}
		}
		return -1;
	}
	/**
	 * Genera el arreglo que guarda las posiciones del patron donde se debe saltar en caso de un error
	 * @param Pattern patron a comparar
	 * @returns arreglo cargado con las posiciones a saltar
	 */
	public static int[] GenerateSuffixArray(String Pattern){
		int indexMove= 1;//indice para moverse en el patron
		int indexCompare= 0;//indice para hacer las comparaciones
		int sizePattern= Pattern.length();
		final int N= sizePattern; 
		int[] next= new int[N];//se crea el arreglo
		while(indexMove<sizePattern){
	   	 	if(Pattern.charAt(indexMove) == Pattern.charAt(indexCompare)){//si hay un caracter repetido en el patron
		 		next[indexMove]= indexCompare + 1;//le guardo la posicion siguiente al caracter repetido
		        indexCompare= indexCompare + 1;
		        indexMove= indexMove + 1;
			}
		    else if(indexCompare != 0){//si hay una discrepancia pero se ya se encontro una coincidencia
		            indexCompare= next[indexCompare-1];//vuelvo a la posicion donde me indica el arreglo
			}
		    else{//si hay discrepancia e indexCompare esta al inicio del patron
				next[indexMove]= 0;
				indexMove= indexMove + 1;
			}
		}
		return next;
	}
	
}
