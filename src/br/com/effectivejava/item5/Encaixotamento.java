package br.com.effectivejava.item5;

public class Encaixotamento {
	
	public static void main(String[] args) {
		
		/**
		 * O método representa a criação de objetos encaixotado automáticamente.
		 */
		
		/*
		 * A variável sum é declarada como um Long em vez de long, o que significa
		 * que o programa constrói aproximadamente 2³¹ instâncias desnecessárias de Long
		 * */
		
		/**
		 * Lição: prefira primitivos simples a primitivos encaixotados e cuidado com o
		 * encaixotamento automático involuntário.
		 * */
		
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
	}
	
}
