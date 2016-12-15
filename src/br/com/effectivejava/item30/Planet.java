package br.com.effectivejava.item30;

/**
 * A <code>Planet</code> e uma enum que representa os
 * planetas do sistema solar, cada planeta tem uma massa
 * e um raio e a partir desses dois atributos voce pode
 * calcular sua gravidade na superficie. Por sua vez
 * isso permite que voce calcule o peso de um objeto na
 * superficie do planeta, dada a massa do objeto.
 * */
public enum Planet {
	
	MERCURY  (3.302e+23, 2.439e6),
	VENUS    (4.869e+24, 6.052e6),
	EARTH    (5.975e+24, 6.378e6),
	MARS     (6.419e+23, 3.393e6),
	JUPITER  (1.899e+27, 7.149e7),
	SATURN   (5.685e+26, 6.027e7),
	URANUS   (8.683e+25, 2.556e7),
	NEPTUNE  (1.024e+26, 2.477e7);
	
	private final double mass; // Em quilogramas
	private final double radius; // Em metros
	private final double surfaceGravity; // Em m / s^2
	
	// Constante gravitacional universal em m^3 / kg s^2
	private static final double G = 6.67300E-11;
	
	Planet(final double mass, final double radius) {
		this.mass = mass;
		this.radius = radius;
		surfaceGravity = G * mass / (radius *  radius);
	}

	public double getMass() {
		return mass;
	}

	public double getRadius() {
		return radius;
	}

	public double getSurfaceGravity() {
		return surfaceGravity;
	}
	
	public double surfaceWeight(final double mass) {
		return mass * surfaceGravity; // F = ma
	}

}
