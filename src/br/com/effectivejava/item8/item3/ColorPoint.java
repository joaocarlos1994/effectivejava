package br.com.effectivejava.item8.item3;

import java.awt.Color;

public class ColorPoint extends Point {
	
	private final Color color;
	
	public ColorPoint(final int x, final  int y, final Color color) {
		super(x, y);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
/*
 * Inv�lido - viola simetria
 * Exemplo 1
 * 	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint)) 
			return false;
		return super.equals(o) && ((ColorPoint)o).color == color;
	}*/
	
	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof Point)) 
			return false;
		
		//Quando "o" � um objeto Point comum, faz uma compara��o que ignora a cor
		if(!(o instanceof ColorPoint))
			return o.equals(this);
		
		//Quando "o" � um objeto ColorPoint, faz uma compara��o complementa
		return super.equals(o) && ((ColorPoint)o).color == color;
	}
	
}
