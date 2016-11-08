package br.com.effectivejava.item21;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Esta classe é hospedeira, pois possui diferentes tipo de estrategias
 * encapsulando as classes concretas que implementa as estrategia.
 * */
public class Host {
	
	private static class StrLenCmp  implements Comparator<String>, Serializable {

		@Override
		public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
		
	}
	
	public static final Comparator<String>
	 STRING_LENGHT_COMPARATOR = new StrLenCmp();
	
}
