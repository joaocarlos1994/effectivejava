package br.com.effectivejava.item30;

public enum Operation3 {
	
	PLUS("+") {
		double apply (final double x, final double y) { return x + y; }
	},
	MINUS("-") {
		double apply (final double x, final double y) { return x - y; }
	},
	TIMES("x") {
		double apply (final double x, final double y) { return x * y; }
	},
	DIVIDE("/") {
		double apply (final double x, final double y) { return x / y; }
	};
	
	private final String symbol;
	
	Operation3(final String sybol) {
		this.symbol = sybol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
	
	abstract double apply(final double x, final double y);
	
}
