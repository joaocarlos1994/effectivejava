package br.com.effectivejava.item32;

/**
 * Item 32: Use EnumSet em vez de campos de bits
 * 
 * Quando os elementos de um tipo enumerado sao empregados
 * principalmente em conjuntos, e tradicional o uso do 
 * padrao de enumeracao de inteiros, com a atribuicao de 
 * uma potencia de 2 diferentes para cada constante.
 * <code>Text</code>.
 * 
 * Essa representacao permite que voce use a operacao
 * bitwise OR para combinar varias constantes em um
 * conjunto, conhecido como campo de bits:
 * 
 * 		text.applyStyles(int styles) {...}
 * 
 * A representacao de campo de bits tambem permite que
 * voce execute operacoes de conjuntos, como uniao e
 * intersecao, eficientemente usando a aritmetica
 * bitwise. Campos de bits apresentam muitas desvantagens
 * sao dificeis de interpreta-las, alem disso, na ha uma
 * maneira facil de iterar por todas elas.
 * 
 * O pacote fornece a classe EnumSet para a representacao
 * eficiente de conjuntos de valores extraidos de um 
 * mesmo tipo enum. Essa classe implementa a interface Set.
 * Mas internamente, cada EnumSet e representado como um
 * vetor de bits, assim nao ficamos isolados da deselegancia
 * e propensao a erros do deslocamento manual de bits: O
 * EnumSet fara o trabalho dificil para voce. Veja o
 * <code>Text2</code>.
 * 
 * Este codigo cliente passa um instancia de EnumSet para o 
 * metodo applyStyle. EnumSet fornece um rico conjunto de
 * fabricas estaticas para a facil criacao de cojuntos.
 * 
 * 		text.applySytles(EnumSet.of(Style.BOLD, Style.ITALIC));
 * 
 * Observe que o metodo applySytles usa um objeto Set<Style> em
 * vez de um objeto EnumSet<Style>. Embora pareca provavel
 * que todos os clientes passarao EnumSet para o metodo, e boa
 * pratica aceitar o tipo de interface em vez do tipo de
 * implementacao.
 * 
 * Resumindo: SO PORQUE UM TIPO ENUMERADO SERA USADO EM CONJUTOS,
 * NAO HA RAZAO PARA REPRESENTA-LO COMO CAMPOS DE BITS. A classe
 * EnumSet combina a concisao e o desenpenho dos campos de bits
 * com todas as diversas vantagens dos tipos enums descritas no
 * item 30.
 * 
 * 
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
