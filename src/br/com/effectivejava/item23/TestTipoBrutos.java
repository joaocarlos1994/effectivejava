package br.com.effectivejava.item23;

import java.util.ArrayList;
import java.util.List;

/**
 * Esse codigo sera compilado, pore com tipo tera uma um aviso: warning:
 * unchecked call to add(E) in raw type List
 * 
 * Mas se voce executar o codigo tera um ClassCastException quando ele tentar
 * converter o resultado da strings.get(0). Essa conversao e gerado pelo
 * compilador, portando, normalmente e bem sucedida, mas nesse caso igonoramos
 * um aviso do compilador e pagamos o preco.
 * 
 * Se voce substituir o tipo bruto List pelo tipo parametrizado List<Object> na
 * declaracao de unsafeAdd e tentar recomilar o programa, vera que ele nao sera
 * mais compilado.
 * 
 */
public class TestTipoBrutos {

	public static void main(String[] args) {

		final List<String> strings = new ArrayList<String>();
		//unsafeAdd(strings, new Integer(42));
		// final String s = strings.get(0);
	}

	/*
	 * private static void unsafeAdd(List list, Object o) { list.add(o); }
	 */

	private static void unsafeAdd(List<Object> list, Object o) {
		list.add(o);
	}

}
