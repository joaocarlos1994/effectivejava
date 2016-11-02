package br.com.effectivejava.item16;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	/**
	 * Item 16: Prefira a composicao em vez da heranca.
	 * 
	 * Usar heranca ao estender classes projetadas e documentadas
	 * especificamente para a extensao.
	 * 
	 * Herdar de classes concretas comuns ultrapassando os limites dos pacotes,
	 * no entanto, � perigoso.
	 * 
	 * Diferente da chamada de metodo, a heranca viola o encapsulamento. Em
	 * outras palavras, uma subclasses depende dos detalhes de implementacao de
	 * sua superclasse para funcionar apropriadamente. A implementacao da
	 * superclasse pode mudar de uma versao para outra e, se isso ocorrer, a
	 * subclasse pode ficar obsoleta, ainda que seu codigo permaneca intocado.
	 * 
	 * Sera implementado <code>InstrumentedHashSet<E></code> de forma a demostrar
	 * o uso incorreto da heranca.
	 * 
	 * A <code>InstrumentedSet</code> e conhecida como classe encapsuladora porque
	 * cada instancia de InstrumentedSet (encapsula) outra instancia de Set. Isso 
	 * tambem conhecida como padrao Decorator[Gamma95, p. 175], porque a classe
	 * InstrumentedSet "decora" um cojunto adicionando a instrumentacao.
	 * 
	 */
	public static void main(String[] args) {
		
		final InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		
		System.out.println(s.getAddCount());
		
		final Set<String> n = new InstrumentedSet<>(new TreeSet<String>());
		n.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		
	}

}
