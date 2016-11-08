package br.com.effectivejava.item20;

/**
 * A <code>Figure</code> apresenta varias deficiencias. Elas ficam amontoadas
 * com texto padronizado, inclusive declaracoes de enums, campos marcadores e
 * instrucoes switch. A legibilidade fica ainda mais prejudicada porque varias
 * implementacoes ficam misturadas na mesma classe. Aumenta a ocupacao da memo-
 * ria porque as instancias ficam cheias de campos irrelevantes pertencentes a
 * outras versoes. Os campos nao podem ser tornados finais a menos que
 * construtores inicilizam os campos irrelevantes, que resulta em mais texto
 * padronizado. Os construtores devem configurar o campo marcador e inicilizar
 * os campos de dados corretos sem ajuda do compilador: se você inicializar
 * os campos de dados errdos, o programa falhara no tempo de execucao. Voce
 * nao pode adicionar uma versao a uma classe marcada a menos que consiga
 * modificar seu arquivo-fonte. Se conseguir adicionar uma versao, deve lembrar-se
 * de adicionar uma clausula case a cada instrucao switch ou a classe falhara no 
 * tempo de execucao.
 * 
 * UMA CLASSE MARCADA E APENAS UMA IMITACAO PALIDA DE UMA HIERARQUIA DE CLASSES.
 * 
 * */
public class Figure {
	
	enum Shape {RECTANGLE, CIRCLE};
	
	//Campo marcador - a forma dessa figura
	final Shape shape;
	
	//Esse campos so sao usados quando a forma e RECTANGLE 
	double length;
	double width;
	
	// Esse campos so e usado quando a forma e CIRCLE
	double radius;
	
	// Constructor do circulo
	Figure(final double radius) {
		this.shape = Shape.CIRCLE;
		this.radius = radius;
	}
	
	// Constructor do retangulo
	Figure(final double length, final double width) {
		this.shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}
	
	double area() {
		switch (shape) {
		case RECTANGLE:
			return length * width;
		case CIRCLE:
			return Math.PI * (radius * radius);
		default:
			throw new AssertionError();
		}
	}
	
}
