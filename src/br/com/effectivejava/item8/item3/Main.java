package br.com.effectivejava.item8.item3;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * Transitividade: Este contrato de equals disrespeito a uma objeto tem que ser igual ao segundo,
		 * e o segundo for igual ao terceiro, assim o primeiro tem que ser igual ao terceiro.
		 * 
		 * Durante o livro ele aborda principio da violação do principio de Liskov
		 * 
		 * */
		
		Point p = new Point(1, 2);
		ColorPoint colorPoint = new ColorPoint(1, 2, Color.RED);
		
		//Exemplo do equals 1
		System.out.println(p.equals(colorPoint));
		System.out.println(colorPoint.equals(p));
		
		System.out.println("\n");
		
		ColorPoint p11 = new ColorPoint(1, 2, Color.RED);
		Point p12 = new Point(1, 2);
		ColorPoint p13 = new ColorPoint(1, 2, Color.BLUE);
		
		System.out.println(p11.equals(p12));
		System.out.println(p12.equals(p13));
		System.out.println(p11.equals(p13));
		
		
	}

}
