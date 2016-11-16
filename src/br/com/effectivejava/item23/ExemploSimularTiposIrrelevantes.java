package br.com.effectivejava.item23;

import java.util.Set;
/**
 * O metodo funciona, mas usa tipo brutos, que sao perigosos. Desde a versao
 * 1.5, a linguagem Java fornece uma alternativa segura conhecida como TIPOS
 * DE CURINGA IRRESTRITO. Se voce quiser usar um tipo generico, mas nao souber
 * ou der importancia a qual parametro e o parametro de tipo real, em vez disso
 * pode usar um ponto de interrogacao. Um exemplo de tipo generico para um tipo
 * coringa é Set<E> para Set<?>. Trata-se do parametrizado Set mais generico,
 * capaz de conter qualquer conjunto.
 * 
 * 
 * */
public class ExemploSimularTiposIrrelevantes {
	
	
	static int numElementsInCommon(final Set s1, final Set s2) {
		int result = 0;
		for (Object o1: s1) {
			if (s2.contains(o1)) result++;
		}
		return result;
	}
	
	/**
	 * Trata-se do tipo parametrizado Set mais generico, capaz de conter
	 * qualquer cojunto.
	 * 
	 * A diferenca do tipo curinga irrestrito Set<?> e o tipo bruto Set e
	 * que o tipo curinga irrestrito e seguro e o tipo bruto nao e. Voce
	 * pode inserir qualquer elemento em uma colecao com um tipo bruto,
	 * adulterando facilmente a invariavel de tipo de colecao, como
	 * demostrado no pelo primeiro metodo; não e possivel inserir
	 * nenhum elemento (a nao ser null) em um objeto Collection<?>
	 * */
	static int numElementsInCommon2(final Set<?> s1, final Set<?> s2) {
		int result = 0;
		for (Object o1: s1) {
			if (s2.contains(o1)) result++;
		}
		return result;
	}
	
}
