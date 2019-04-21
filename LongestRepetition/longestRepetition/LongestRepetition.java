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
		repetitions.clear();//limpio el array 
		find_repetitions(text,0);
		String max="";
		for(int i=0;i<repetitions.size();i++) {//calculo el maximo de repetitions y lo retorno
			if(max.length() < repetitions.get(i).length()) {
				max=repetitions.get(i);
			}
		}
		return max;
	}
	
	
	
	static ArrayList<String> repetitions= new ArrayList<String>();
	

	/**
	 * En la posicion i del arreglo guarda la cant de caracteres 
	 * iguales a los primeros de s  que hay desde la posición i de s
	 * @param s string a devolver analizar
	 * @return array de integer
	 */
	public static ArrayList<Integer> z_function(String s){
		int stringLenght = s.length();
		ArrayList<Integer> z = new ArrayList<Integer>();
		for(int j=0;j<stringLenght;j++) {//inicializo con cero, ya que no hay caracteres antes del primer caracter de s.
    		z.add(0);
    	 }
		/*el índice limit puede verse como el "límite" en el que el algoritmo ha explorado nuestra cadena s, y iniLimit es desde donde comienza limit; Todo más allá de ese punto aún no se conoce*/
		for (Integer i = 1, iniLimit = 0, limit = 0; i < stringLenght; i++) {
        	if (i <= limit){//si a posición actual está fuera de lo que ya hemos procesado
            	z.set(i.intValue(),Math.min(limit-i+1, z.get(i.intValue()-iniLimit.intValue())));
			}
			//calcularemos z [i] comparando los valores uno por uno
        	while (i + z.get(i.intValue()) < stringLenght && s.charAt(z.get(i.intValue())) == s.charAt(i.intValue()+z.get(i.intValue()))){
            	z.set(i.intValue(),z.get(i.intValue())+1);//mientras sigan siendo iguales va sumando un contador.
			}
        	if (i + z.get(i.intValue()) - 1 > limit) {//si la posición actual está dentro de la coincidencia del segmento actual [initLimit; limit]
			/*podemos usar los valores Z ya calculados para "inicializar" el valor de z [i] a algo seguro mejor que "comenzar desde cero". Observamos que las subcadenas s [iniLimit… limit] y
			s [0… limit − iniLimit] coinciden. Esto significa que como una aproximación inicial para z [i] podemos tomar el valor ya calculadopara el segmento correspondiente s [0… limit − i], 
			y eso es z [i − iniLimit]*/
				iniLimit = i;
				limit = i + z.get(i.intValue()) - 1;
        	}
    }
    return z;	
	}

	/**
	 * Busca el elemento i del array z, si este existe, y lo devuelve
	 * @param z array de enteros donde se va a buscar un elemento
	 * @param i posicion a buscar en el array
	 * @return Integer guardado en el array z, en la posicion i (si existe tal posicion en z), sino retorna 0
	 */
	public static Integer get_z(ArrayList<Integer> z, int i) {
    	if (0 <= i && i < (Integer)z.size()){//si exista la posicion esta en el arreglo, devuelve lo que hay en esa posicion
       	 return z.get(i);
		}
		else{
    	    return 0;
		}
	}
	
	/**
	 * si hay repeticiones, guarda la palabra que se repite en el arreglo repetitions
	 * @param s string donde se busca repeticion
	 * @param left es true si el centro esta en left (cntro<nLeft)
	 * @param cntr posicion donde esta el centro en ese momento
	 * @param longit longitud de posible repeticion
	 * @param k1 mayor numero tal que los k1 elementos antes de cntr coindicen con los k1 ultimos elementos de left
	 * @param k2 mayor numero tal que los k2 elementos que comienzan en cntro, coincidan con los primeros k2 elementos de right
	 */
	public static void convert_to_repetitions(String s, boolean left, int cntr, int longit, int k1, int k2) {
    	for (int l1 = Math.max(1, longit - k2); l1 <= Math.min(longit, k1); l1++) {
    	    if (left && l1 == longit) break; //salir si centro esta en left y 
    	    int pos = (left ? cntr - l1 : cntr - longit - l1 + 1);//calcula la posicion donde comienza la repeticion dependiendo de si el centro esta en left o en right
    	    String aux=s.substring(pos,pos+longit);//desde pos, hasta pos+longitud de lo que se repite, me da lo que se repite
			repetitions.add(aux);//lo agrego al arraylist con todos los repetidos
    	}
	}
	
	/**
	 * Busca las palabras repetidas continuas en s y las guarda en repetitions
	 * @param s string a buscar repeticiones
	 * @param shift cuanto se debe shiftear 
	 */
	public static  void find_repetitions(String s, int shift) {
    	int n = s.length();//cantidad de elementos de s
    	if ((n == 1) || (n==0)){//si s tiene un solo elemento o ninguno
			return;//sale
		}
    	int nLeft = n / 2;//cantidad de elementos de left
    	int nRight = n - nLeft;//cantidad de elementos de right
    	String left = s.substring(0, nLeft);//primera mitad de s
    	String right = s.substring(nLeft);//segunda mitad de s
		String reverseLeft = new StringBuffer(left).reverse().toString();
    	String reverseRight = new StringBuffer(right).reverse().toString();
		
    	find_repetitions(left, 0);//llamada recursiva con la primera mitad
    	find_repetitions(right, nLeft);//lamada recursiva con la segunda mitad
	
		ArrayList<Integer> z1 = z_function(reverseLeft);
		ArrayList<Integer> z2 = z_function(right + '#' + left);
		ArrayList<Integer> z3 = z_function(reverseLeft + '#' + reverseRight);
		ArrayList<Integer> z4 = z_function(right);

		for (int cntr = 0; cntr < n; cntr++) {
        	int longitud, k1, k2;
        	if (cntr < nLeft) {//si el centro esta en left
        	    longitud = nLeft - cntr;// 2*longitud es la longitud de posibles repeticiones, para cada centro
            	k1 = get_z(z1, nLeft - cntr);//
				k2 = get_z(z2, nRight + 1 + cntr);//
        	}
			else {//si el centro esta en right
            	longitud = cntr - nLeft + 1;// 2*longitud es la longitud de posibles repeticiones, para cada centro
            	/*Sea k1 el número más grande,
            	 *  de modo que los primeros caracteres k1 
            	 *  antes de la posición cntr coincidan con 
            	 *  los últimos caracteres k1 en la cadena left*/
            	k1 = get_z(z3, nLeft + 1 + nRight - 1 - (cntr - nLeft));
            	/*Sea k2 el número más grande,
            	 *  de modo que los caracteres k2 que comienzan
            	 *   en la posición cntr coincidan con los primeros 
            	 *   caracteres k2 en la cadena right*/
            	k2 = get_z(z4, (cntr - nLeft) + 1);
        	}
        	if (k1 + k2 >= longitud){//si encontre una posible repeticion
            	convert_to_repetitions(s, cntr < nLeft, cntr, longitud, k1, k2);//la guarda
			}
    	}
	}
	
}
