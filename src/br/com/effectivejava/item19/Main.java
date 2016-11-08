package br.com.effectivejava.item19;

/**
 * Item 19: So use interfaces para definir tipos
 * 
 * 
 * Quando uma classe implementa uma interface, essa serve como um tipo que pode
 * ser usado para referenciar instancias da classe, o fato de uma classe
 * implementar uma interface deve dizer algo sobre que um cliente pode fazer com
 * instancias da classe.
 * 
 * Um tipo de interface que nao passa nesse teste e a chamada interface de
 * constantes. Esta interface nao contem metodos, ela e composta apenas por
 * campos finais estaticos, cada um exportando uma constante.
 * 
 * O padrao de interface de constantes e uma forma inadequada do uso de
 * interface.
 * 
 * A implementacao de uma interface de constantes faz com que esse detalhe
 * vaze para API exportada da classe.
 * 
 * O pior e representar um compremetimento: se em uma versao futura a classe
 * for modificado para que nao precise mais usar constantes, continuara tendo
 * que implementar a interface para assegurar a compatibilidade binaria. Se uma
 * classe nao-final implementar uma interface de constantes, todas suas subclasses
 * terao seus espacos de nomes adulterados pelas constates da interface.
 * 
 * Todas as classes primitivas numericas encaixotadas, como Integer e Double,
 * exportam as constantes MIN_VALUE e MAX_VALUE. Se for melhor visualizar
 * as constantes como membro de um tipo enumerado, você deve exporta-las como um
 * tipo enum. Caso contrario, deve exportar as constantes como uma classe utilitaria
 * nao instanciavel.
 * 
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {

	}

}
