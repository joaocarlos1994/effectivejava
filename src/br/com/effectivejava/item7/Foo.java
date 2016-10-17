package br.com.effectivejava.item7;

public class Foo {

	/**
	 * Evite Finalizadores
	 * 
	 * Perda de desenpenho
	 * Métodos finalize são usados com try-finally
	 * */
	
	private final Object finalizerGuardian = new Object();
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	
}
