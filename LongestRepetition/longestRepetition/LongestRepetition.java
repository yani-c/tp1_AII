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
		find_repetitions(text,0);
		String max="";
		for(int i=0;i<repetitions.size();i++) {
			if(max.length() < repetitions.get(i).length()) {
				max=repetitions.get(i);
			}
		}
		return max;
	}
	
	
	
	static ArrayList<String> repetitions= new ArrayList<String>();
	
	//en la posicion i del arreglo guarda la cant de caracteres iguales a los primeros de s hay desde la posicion i de s
	public static ArrayList<Integer> z_function(String s){//ERA POR REFENCIA VER QUE HACER
		 int n = s.length();
    	 ArrayList<Integer> z = new ArrayList<Integer>();
    	 for(int j=0;j<n;j++) {//inicializo con cero
    		 z.add(0);
    	 }
    	for (Integer i = 1, l = 0, r = 0; i < n; i++) {
        	if (i <= r){
            	z.set(i,Math.min(r-i+1, z.get(i-l)));
			}
        	while (i + z.get(i) < n && s.charAt(z.get(i)) == s.charAt(i+z.get(i))){
            	z.set(i,z.get(i)+1);//mientras sigan siendo iguales va sumando un contador
			}
        	if (i + z.get(i) - 1 > r) {
				l = i;
				r = i + z.get(i) - 1;
        	}
    }
    return z;	
	}

	
	public static Integer get_z(ArrayList<Integer> z, int i) {
    	if (0 <= i && i < (Integer)z.size()){//si exista la posicion esta en el arreglo, devuelve lo que hay en esa posicion
       	 return z.get(i);
		}
		else{
    	    return 0;
		}
	}
	
	//si hay repeticiones, guarda la palabra que se repite en el arreglo
	public static void convert_to_repetitions(String s, boolean left, int cntr, int l, int k1, int k2) {
    	for (int l1 = Math.max(1, l - k2); l1 <= Math.min(l, k1); l1++) {
    	    if (left && l1 == l) break;
    	    int pos = (left ? cntr - l1 : cntr - l - l1 + 1);
    	    String aux=s.substring(pos,pos+l);
			repetitions.add(aux);
    	}
	}
	
	
	public static  void find_repetitions(String s, int shift) {
    	int n = s.length();
    	if (n == 1){
			return;
		}
    	int nu = n / 2;//cantidad de elementos de u
    	int nv = n - nu;//cantidad de elementos de v
    	String u = s.substring(0, nu);
    	String v = s.substring(nu);
		String ru = new StringBuffer(u).reverse().toString();//String ru(u.rbegin(), u.rend());
    	String rv= new StringBuffer(v).reverse().toString();//String rv(v.rbegin(), v.rend());
		
    	find_repetitions(u, 0);
    	find_repetitions(v, nu);
	
    	//probar que hace sin #
		ArrayList<Integer> z1 = z_function(ru);
		ArrayList<Integer> z2 = z_function(v + '#' + u);
		ArrayList<Integer> z3 = z_function(ru + '#' + rv);
		ArrayList<Integer> z4 = z_function(v);

		for (int cntr = 0; cntr < n; cntr++) {
        	int l, k1, k2;
        	if (cntr < nu) {
        	    l = nu - cntr;
            	k1 = get_z(z1, nu - cntr);
				k2 = get_z(z2, nv + 1 + cntr);
        	}
			else {
            	l = cntr - nu + 1;
            	k1 = get_z(z3, nu + 1 + nv - 1 - (cntr - nu));
            	k2 = get_z(z4, (cntr - nu) + 1);
        	}
        	if (k1 + k2 >= l){
            	convert_to_repetitions(s, cntr < nu, cntr, l, k1, k2);
			}
    	}
	}
	
}
