package br.com.effectivejava.item21;

/**
 * A <code>StringLengthComparator</code> exporta um unico metodo que usa
 * que usa duas strings e retornar um inteiro de acordo com seus tamanhos.
 */
public class StringLengthComparator {

	public int compare(final String s1, final String s2) {
		return s1.length() - s2.length();
	}

}
