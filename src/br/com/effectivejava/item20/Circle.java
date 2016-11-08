package br.com.effectivejava.item20;

public class Circle extends AbstractFigure {
	
	private final double radius;
	
	public Circle(final double radius) {
		super();
		this.radius = radius;
	}

	@Override
	double area() {
		return Math.PI * (radius * radius);
	}

}
