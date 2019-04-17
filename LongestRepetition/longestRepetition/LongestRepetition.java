package longestRepetition;

import java.util.ArrayList;

public class LongestRepetition {
	/**
	 * Calcula Longest repetition usando Fuerza Bruta.
	 * @param text texto a analizar
	 * @returns subString de mayor longitud que se repite.
	 */
	public static String repetition(String text) {
		ArrayList<String> arrayOfSubstrings= subStrings(text);//se crea e inicializa el ArrayList con las subcadenas de text
		int index=0; //indice del while que nos permite recorrer el ArrayList
		String maxString=""; //variable que guarda la string maxima que se repite secuencialmente
		while(index<arrayOfSubstrings.size()) {//mientras no sea el fin del ArrayList
			if(arrayOfSubstrings.get(index).length() % 2 ==0){//si la subcadena extraida tiene tamaño par
				boolean equals=true;
				String element=arrayOfSubstrings.get(index);//coloca la sub cadena extraida en element
				String aux=element.substring(element.length()/2, element.length());//coloca la segunda mitad de element en aux
				for(int indexAux=0;indexAux<aux.length() && equals;indexAux++) {/*recorre aux y element mientras sus caracteres coincidan hasta que aux se termine*/
					if(!(element.charAt(indexAux) == aux.charAt(indexAux))) {//si los caracteres de element y aux no coinciden
						equals=false;
					}
				}
				if(equals) {//si aux y la primera mitad de element son iguales
					if(aux.length() > maxString.length()) {//si encontre una sub cadena mas larga que la que tenia
						maxString=aux;//la guardo
					}
				}
			}
			index++;
		}
		return maxString;//retorno la subcadena mas larga que se repite consecutivamente
	}
	
	/**
	 * Calcula todas las sub cadenas de una cadena dada
	 * @param string cadena a buscar las sub cadenas
	 * @return result ArrayList con las sub cadenas de string
	 */
	public static ArrayList<String> subStrings(String string){
		ArrayList<String> result= new ArrayList<String>();//se crea el ArrayList
		for(int beginIndex=0;beginIndex<string.length();beginIndex++) {//se recorre string
			for(int endIndex=beginIndex+1;endIndex<=string.length();endIndex++) {/*para cada elemento x de string 
													se calculan los posibles y tal que al extraer lo que hay entre x e y es una subcadena*/
				result.add(string.substring(beginIndex, endIndex)); //se guarda esta sub cadena en ArrayList
			}
		}
		return result;
	}
	
	/**
	 * Calcula LOngest repetition usando D&C.
	 * @param text texto a analizar
	 * @returns subString de mayor longitud que se repite.
	 */
	public static String repetitionDc(String text) {
		return " ";
	}
}
