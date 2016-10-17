package br.com.effectivejava.item4;

public class UtilityClass {
	
	
	/**
	 * Imponha a não-instanciação com um constructor privado
	 * 
	 * Obs.: Uma classe pode ser tornada não-instanciável com a inclusão de um 
	 * construtor privado
	*/
	
	//Supress default constructor for noninstantiability.
	private UtilityClass(){
		throw new AssertionError();
	}
	
}
