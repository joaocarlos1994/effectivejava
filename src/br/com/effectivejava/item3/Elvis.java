package br.com.effectivejava.item3;

public class Elvis {
	
	
	/**
	 * Imponnha a propriedade singleton com um construtor privado ou tipo enum
	 * 
	 * */
	
	public final static Elvis INSTANCE = new Elvis();
	
	private Elvis(){}
	
}
