package br.com.effectivejava.item3;

public class Elvis2 {
	
	/**
	 * Imponnha a propriedade singleton com um construtor privado ou tipo enum
	 * 
	 * */
	
	private final static Elvis2 INSTANCE = new Elvis2();
	private Elvis2(){}
	public static Elvis2 getInstance(){
		return INSTANCE;
	}
	
}
