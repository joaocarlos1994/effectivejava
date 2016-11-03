package br.com.effectivejava.item17;

import java.util.Date;


public final class Sub extends Super {

	private final Date date;

	public Sub() {
		super();
		this.date = new Date();
	}

	@Override
	public void overrideMe() {
		System.out.println(date);
	}

	/**
	 * Contrutores nao devem chamar metodos substituiveis, direta ou indiretamente.
	 * 
	 * O construtor da superclasse e executado antes do construtor da subclasse, 
	 * portanto, o metodo de sobreposicao da subclasse sera chamado antes do construtor
	 * da subclasse ter sido executado.
	 * 
	 * O metodo overrideMe e chamado pelo construtor de Super antes do construtor de Sub
	 * ter uma chance de inicializar o campo Date.
	 * 
	 */
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}

}
