package br.com.effectivejava.item15;

/**
 * A <code>Complex</code> representa um numero complexo. Alem dos metodos
 * default de object, ela fornece acessadores para as partes real e imaginaria e
 * forneceas quatros operacoes aritmeticas basicas: adicao, subtracao,
 * multiplicacao e divisao.
 * 
 * Observe como as operacoes aritmeticas criam e retornam uma nova instancia de
 * Complex em vez de modificar essa instancia.
 * 
 * 
 */
public final class Complex {

	private final double re;
	private final double im;

	public Complex(final double re, final double im) {
		super();
		this.re = re;
		this.im = im;
	}

	// Acessadores sem os alteradores (Sets) correspondentes
	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

	public Complex add(final Complex c) {
		return new Complex(re + c.re, im + c.im);
	}

	public Complex subtrac(final Complex c) {
		return new Complex(re - c.re, im - c.im);
	}

	public Complex multiply(final Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}

	public Complex divide(final Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;

		Complex c = (Complex) o;
		return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
	}

	@Override
	public int hashCode() {
		int result = 17 + hasDouble(re);
		result = 31 * result + hasDouble(im);
		return result;
	}

	public int hasDouble(double val) {
		long longBits = Double.doubleToLongBits(re);
		return (int) (longBits ^ (longBits >>> 32));
	}

}
