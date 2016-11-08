package br.com.effectivejava.item21;

public class StringLengthImplementsComparator implements Comparator<String> {
	
	private StringLengthImplementsComparator() {}
	
	public static StringLengthImplementsComparator
	 INSTANCE = new StringLengthImplementsComparator();
	
	@Override
	public int compare(String t1, String t2) {
		return t1.length() - t2.length();
	}

}
