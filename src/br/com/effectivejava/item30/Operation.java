package br.com.effectivejava.item30;
/**
 * Tipo enum que ativa seu proprio valor
 * */
public enum Operation {
	
	PLUS, MINUS, TIMES, DIVIDE;
	
	double apply(final double x, final double y) {
		switch(this) {
			case PLUS: return x + y;
			case MINUS: return x - y;
			case TIMES: return x * y;
			case DIVIDE: return x / y;
		}
		throw new AssertionError("Unknown op:" + this);
	}
}
