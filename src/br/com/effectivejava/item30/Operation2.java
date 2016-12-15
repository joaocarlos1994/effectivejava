package br.com.effectivejava.item30;

public enum Operation2 {
	
	PLUS { double apply(double x, double y) {return x + y;} },
	MINUS { double apply(double x, double y) {return x - y;} },
	TIMES { double apply(double x, double y) {return x * y;} },
	DIVIDE { double apply(double x, double y) {return x / y;} };
	
	abstract double apply(final double x, final double y);
}
