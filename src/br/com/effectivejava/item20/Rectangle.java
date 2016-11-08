package br.com.effectivejava.item20;

public class Rectangle extends AbstractFigure {

	private final double length;
	private final double width;
	
	public Rectangle(final double length, final  double width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	double area() {
		return length * width;
	}

}
