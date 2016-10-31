package br.com.effectivejava.item12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	
	/**
	 * Considere a implementacao de Comparable
	 * 
	 * Ao implementar Comparable a classe indica que suas instancias tem uma ordem natural: ordem, igualdade.
	 * É igualmente facil pesquisar, calcular valores extremos e editar automaticamente colecoes ordenadas de
	 * objetos Comparable.
	 * 
	 * */
	public static void main(String[] args) {
		
		final List<Pessoa> pessoas = new ArrayList<>(2);
		
		pessoas.add(new Pessoa("Ziraldo", "Santos"));
		pessoas.add(new Pessoa("Amanda", "Santos"));
		
		Collections.sort(pessoas);
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.toString());
		}
		
	}

}
