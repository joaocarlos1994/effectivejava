package br.com.effectivejava.item7;

public class Foo {

	/**
	 * Evite Finalizadores
	 * */
	
	private final Object finalizerGuardian = new Object();
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	
}
