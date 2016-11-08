package br.com.effectivejava.item21;

import java.util.Arrays;

/**
 * Item 21: Use objetos de funcao para representar estrategias
 * 
 * Algumas linguagem dao suporte a ponteiros, delegates e expressoes lambda como
 * o java. Normalmente esse recursos sao usados para permitir que o chamador de
 * funcao especialize seu comportamento fornecendo uma segunda funcao. Por
 * exemplo, a funcao comparadora, que qsort usa para comparar os elementos e
 * serem classificados. Ela retorna um inteiro negativo caso o elemento seja
 * menor, zero se os elementos tiverem o mesmo tamanho e um inteiro positivo
 * caso for maior.
 * 
 * Ordens de classificacao distintas podem ser obtidas com a passagem de
 * diferentes funcoes compardoras. Esse e um exemplo do padrao Strategy, a
 * funcao comparadora representa uma estrategia para a classificacao de
 * elementos.
 * 
 * Uma forma de simular a opcao lambda e o uso de referencia de objetos.
 * Normalmente a chamada a um metodo em um objeto executa alguma operacao nesse
 * objeto. A instancia de uma classe que exporte um metodo assim e efetivamente
 * um ponteiro que conduz a esse metodo. Essas instancia sao conhecidas como
 * OBJETOS DE FUNCAO. Por exemplo o <code>StringLengthComparator</code>
 * 
 * Uma referencia a StringLengthComparator serve como "ponteiro de funcao" para
 * esse comparador, permitindo que ele seja chamado em pares de strings 
 * arbitrarios.
 * 
 * Como e comum em classes de estrategia concreta, a classe StringLengthComparator
 * NAO TEM MONITORACAO DE ESTADO: nao tem campos, portando todas instancia da classe
 * sao funcionalmente equivalente, entao podemos considerar que ela seja de tipo
 * singleton para economizar a utilizacao de objetos desnecessarios como
 * <code>StringLengthComparatorSingleton</code>
 * 
 * Para passar uma instancia de StringLengthComparator para um metodo, precisamos
 * de um tipo apropriado para o parametro. Nao seria bom usar StringLengthComparator 
 * porque os clientes nao poderiam passar nenhuma outra estrategia de comparacao. Em
 * vez disso devemos definir uma interface <code>Comparator</code> e modificar
 * StringLenghtComparatorSingleton, em outras palavras definir uma interface de
 * estrategia.
 * 
 *  Ver compartor java.uti.comparator
 *  
 *  Geralmente as classes de estrategias sao declaradas com o uso de classes anonimas.
 *  Ver metodo na classe <code>Main</code>. Se ela tiver que ser usada repetidamente,
 *  considere o armazenamento do objeto da funcao em um campo final estatico privado
 *  para sua reutilizacao.
 *  
 *  Ja que a interface de estrategia serve como um tipo para todas instancias de
 *  estrategia concreta, uma classe de estrategia concreta nao precisa ser tornanda
 *  publica para exportar uma estrategia concreta. Em vez disso, uma "classe hospedeira"
 *  pode exportar um campo estatico publico (ou metodo de fabricacao estatico) cujo tipo
 *  seja a interface de estrategia e a classe de estrategia concreta pode ser uma classe
 *  aninhada privada no hospedeiro. Como o exemplo da classe <code>Host</code>
 *  
 *  Esse exemplo é usada no lugar da classe anonima para permitir que a classe de estrategia
 *  concreta implemente uma segunda interface, a Serializer.
 *  
 *  Resumindo, um forma de simular a uma lambda e implementar o padrao Strategy. Quando uma
 *  estrategia concreta nao e usada apenas uma vez, normalmente e declarada e instanciada
 *  como uma classe anonima. Quando uma estrategia concreta e projetada para uso repetido,
 *  geralmente e implementa como uma classse membro estatica privada e exportada atraves de
 *  um campo final estatico publico cujo o tipo a interface de estrategia.
 *  
 */
public class Main {

	public static void main(String[] args) {
		
		final String [] obj = {"Joao", "Augusto"};
		
		Arrays.sort(obj, new Comparator<String>() {
			@Override
			public int compare(String t1, String t2) {
				return t1.length() - t2.length();
			}
		});
		
	}

}
