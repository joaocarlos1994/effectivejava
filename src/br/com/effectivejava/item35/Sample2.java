package br.com.effectivejava.item35;

public class Sample2 {
	
	@ExceptionTest(ArithmeticException.class)
	public static void m1() { //O teste deve ser bem bem-sucessido
		int i = 0;
		i = i / i;
	}
	
	@ExceptionTest(ArithmeticException.class)
	public static void m2() { //Deve falhar (excecao errada)
		int [] a = new int[10];
		int i = a[1];
	}
	
	@ExceptionTest(ArithmeticException.class)
	public static void m3() {} //Deve falhar (sem excecao)
	
}
