package longestRepetition;

import java.util.ArrayList;

public class LongestRepetition {
	/**
	 * Calcula Longest repetition usando Fuerza Bruta.
	 * @param text texto a analizar
	 * @returns subString de mayor longitud que se repite.
	 */
	public static String repetition(String text) {
		ArrayList<String> arrayOfSubstrings= subStrings(text);
		int index=0;
		String maxString="";
		while(index<arrayOfSubstrings.size()) {
			if(arrayOfSubstrings.get(index).length() % 2 ==0){
				String element=arrayOfSubstrings.get(index);
				String aux=element.substring(element.length()/2, arrayOfSubstrings.size());
				boolean equals=true;
				for(int indexAux=0;indexAux<aux.length() && equals;indexAux++) {
					//EL FOR SE VA DE RANGO
					if(!(element.charAt(indexAux) == aux.charAt(indexAux))) {
						equals=false;
					}
				}
				if(equals) {
					if(aux.length() > maxString.length()) {
						maxString=aux;
					}
				}
			}
			index++;
		}
		return maxString;
	}
	
	//auxiliar para la resolucion de repetition
	public static ArrayList<String> subStrings(String string){
		ArrayList<String> result= new ArrayList<String>();
		for(int beginIndex=0;beginIndex<string.length();beginIndex++) {
			for(int endIndex=beginIndex+1;endIndex<=string.length();endIndex++) {
				result.add(string.substring(beginIndex, endIndex));
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
