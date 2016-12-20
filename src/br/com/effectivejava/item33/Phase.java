package br.com.effectivejava.item33;

/**
 * Este programa e deselegante, pois o compilador
 * nao tem como conhecer o relacionamento entre
 * ordinais e indices de matriz. Se voce cometer
 * um erro na tabela de transicao, ou esquecer de
 * atualiza-la ao modificadoro o tipo enum Phase
 * ou Phase. Transition, seu programa falhara no
 * tempo de execucao. A falha pode assumir a forma
 * de uma ArrayIndexOutOfBoundsException,
 * NullPointerException ou pior um erro silencioso
 * comportamento incorreto.
 * */
public enum Phase {
	
	SOLID, LIQUID, GAS;
	
	public enum Transition {
		
		MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
		
		private static final Transition[][] TRANSITIONS = {
				{null, MELT, SUBLIME},
				{FREEZE, null, BOIL},
				{DEPOSIT, CONDENSE, null}
		};
		
		// Retorna a transicao de uma fase para outra
		public static Transition from(final Phase src, final Phase dst) {
			return TRANSITIONS[src.ordinal()][dst.ordinal()];
		}
	}
}
