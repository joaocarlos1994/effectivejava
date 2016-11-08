package br.com.effectivejava.item21;

public class StringLengthComparatorSingleton {
	
	private StringLengthComparatorSingleton() {}
	
	public static final StringLengthComparatorSingleton 
	 INSTANCE = new StringLengthComparatorSingleton();
	
	public int compare(final String s1, final String s2) {
		return s1.length() - s2.length();
	}
	
}
