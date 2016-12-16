package br.com.effectivejava.item31;

/**
 * Item 31: Use campos de instancia em vez de ordinais.
 * 
 * Muitas enums sao naturalmente associados a um unico valor int.
 * Todos os enums tem um metodo ordinal, que retorna a posicao
 * numerica de cada constante enumerada de seu tipo, como no
 * <code>Ensemble</code>
 * 
 * Embora funcione essa enum e dificil de manutencao. Se as 
 * constantes forem reordenadas, o metodo numberOfMusicians. Se
 * voce quiser adicionar uma segunda constante a enum associada
 * a um valor int que ja tiver usado, nao tera exito, como 
 * exemplo octeto uma constante representando um quarteto tripo.
 * 
 * Alem disso, voce nao pode adicionar uma constante para um
 * valores int, sem adicionar constantes para os valores int
 * intermediarios.
 * 
 * Felizmente, ha uma solucao simples para esses problemas. NUNCA
 * DERIVE UM VALOR ASSOCIADO A UM ENUM A PARTIR DE SEU ORDINAL, EM
 * VEZ DISSO, ARMAZENE-O EM UM CAMPO DE INSTANCIA COMO A ENUM
 * <code>Ensemble2</code>
 * 
 * O metodo ordinal foi projetado para ser empregado por estruturas
 * de dados de uso geral baseadas em enumeracao como EnumSet e 
 * EnumMap.
 * 
 * */
public class Main {

	public static void main(String[] args) {

	}

}
