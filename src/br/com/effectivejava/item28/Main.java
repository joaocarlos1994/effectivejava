package br.com.effectivejava.item28;

/**
 * Item 28: Use curingas restritos para aumentar a flexibilidade da API
 * 
 * Como mencionado no item 25, os tipos parametrizados sao invariantes,
 * Type2 nao e subtipo de Type1. Ex.:
 * 
 * 		Stack<Number> listNumber = ...;
 * 		Integer oneInteger = new Integer();
 * 		listNumber.pushAll(oneInteger);
 * 
 * Este metodo nao sera executado, apesar de Interger herdar de Number,
 * pois tipo parametrizados sao invariantes. Para resolver este problema
 * a linguagem java oferece um tipo para parametrizado conhecido como
 * tipo de curinga restrito. Para resolver o este problema o metodo
 * pushAll nao deve ser "Iteravel de E", mas "Interavel de algum subtipo
 * de E" assim assinatura do metodo ficara Iteravel<? extends E>. Ex:
 * 
 * 	// Tipo de curinga para parametro que serve como um produtor de E
 * 		public void pushAll(Iterable<? extends E> src) {
 * 			for (E e : src)
 * 				push(e)
 * 		}
 * 
 * Com esta alteracao o metodo acima ira funcionar sem nenhum problema.
 * Agora suponha que voce quisesse criar um metodo popAll para acompanhar
 * o pushAll. O metodo popAll extrai cada elemento da pilha e adiciona os
 * elementos a colecao fornecida.
 * 
 * 	// Metodo popAll sem tipo de curinga - deficiente
 * 		public void popAll(Collection<E> dst) {
 * 			while(!isEmpty())
 * 				dst.add(pop());
 * 		}			
 * 
 * Este metodo sera compilado sem problemas se a colecao destino coincidir
 * exatamente com o da pilha, porem havera um erro se os tipo forem dife-
 * rente. Ex.:
 * 		
 * 		// Erro
 * 		Stack<Number> numberStack = ...;
 * 		Collection<Object> objects = ...;
 * 		numberStack.popAll(objects);
 * 
 * Para resolver este problema os tipo coringas oferecem uma solucao, onde
 * o parametro de entrada nao deve ser "Colecao de E", mas "colecao de algum
 * super tipo de E" (onde o supertipo e definido de modo que E seja um 
 * supertipo de si proprio). O metodo resolvido ficaria assim:
 * 
 * 		// Tipo de curinga para parametro que serve como consumidor de E
 * 		public void popAll(Collection<? super E> dst) {
 * 			while(!isEmpty())
 * 				dst.add(pop())
 * 		}
 * 
 * PARA OBTER MAXIMA FLEXIBILIDADE, USE TIPOS DE CURINGAS EM PARAMETROS PARA
 * DE ENTRADA QUE REPRESENTEM PRODUTORES OU CONSUMIDORES
 * 
 * PECS: produtor-extends, consumidor-super
 * 
 * Tipo produtor (Pegar valores) T: <? extends T>
 * Tipo consumidor T (Colocar valores): <? super T>
 * 
 * Em nosso exemplo de Stack, o parametro src pushAll produz instancias de E
 * para serem usadas por stack, por o tipo apropriado e extends, enquanto o
 * parametro dst de popAll consome instancias de E a partir da Stack, logo
 * o tipo apropriado e super.
 * 
 * Principio Get an Put: Use <? extends E> quando você somente for pegar
 * valores fora de uma estrutura. Use <? super E> quando voce somente colocar
 * valor em uma estrutura, e nao use ambos.
 * Fonte: http://www.ibm.com/developerworks/library/j-jtp07018/
 * 
 * NAO USE TIPOS DE CURINGA COMO TIPOS DE RETORNO.
 * 
 * Usando tipo coringa de maneira apropriada, os tipos de curinga sao quase
 * invisivel para os usuarios de uma classe. Eles fazem com que os metodos
 * aceitem os parametros que devem aceitar e rejeitas os que devem rejeitar.
 * 
 * SE O USUARIO DE UMA CLASSE TIVER QUE CONSIDERAR OS TIPOS DE CURINGA, DEVE
 * HAVER ALGO ERRADO COM A API DA CLASSE.
 * 
 * Vamos analisar o metodo Union:
 * 	
 * 		Set<Integer> integers = ...;
 * 		Set<Double> doubles = ...;
 * 		Set<Number> numbers = union(integers, doubles)		
 * 
 * 		public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2)
 * 		
 * Se testar esta classe havera de incompatibilidades de tipos. Felizmente ha
 * uma maneira de resolver este problema inferindo o tipo que queriamos que 
 * ele tivesse. Podemos informa-lo sobre o tipo a ser usado com um parametro
 * de tipo explicito. 
 * 
 * 		Set<Number> numbers = Union.<Number>union(integers, doubles);
 * 
 * Vejamos outro metodo revisada que usa tipo de curinga:
 * 
 * 		public static <T extends Comparable<? super T>> T max(List<? extends T> list)
 * 
 * Foi aplicada a transformacao de PECS duas vezes. O metodo max recebe list, onde e 
 * um produtor, ou seja, pega valores como explicamos anteriormente. A aplicacao
 * complicada ocorre no parametro de tipo T. T foi especificado originalmente para
 * estender Comparable<T>, mas um comparavel de T consome instancias (Coloca valores)
 * e produz (Pega) inteiros indicando relacoes de ordem. Comparaveis sao sempre
 * consumidores (Colocar valores), portanto voce deve sempre usar Comparable<? super T>
 * em vez de Comparable<T>. O mesmo e verdade para comparadores, logo, voce deve sempre
 * usar Comparator<? super T> em vez de Comparator<T>. Aqui esta um exemplo uma lista
 * seria excluida pela declaracao original, mas e permitida pela revisada:
 * 
 *  		List<ScheduleFuture<?>>
 *  
 *  Ha um pequeno problema da declaracao revisada maz: ela impede que o metodo seja
 *  compilado. Aqui esta o metodo da declaracao revisada:
 *  
 *  // Nao sera compilado - curingas pordem demandar alteracoes no corpo do metodo
 *  // Erro: Incompatible types.
 *  public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
 *  	Interator<T> i = list.iterator();
 *  	T result = i.next();
 *  	while (i.hasNext()) {
 *  		T t = i.next();
 *  		if (t.compareTo(result) > 0)
 *  			result = t;
 *  	}
 *  	return result;
 *  }
 *  
 *  O erro ocorreu porque o objeto list nao e um objeto do List<T> portanto, o metodo
 *  iterator nao retorna Iterator<T>. Retorna um iterator de algum tipo de algum
 *  subtipo de T, logo, substituimos a declaracao do iteradir por essa que usa um 
 *  tipo de curinga restrito:
 *  
 *  	Iterator<? extends T> i = list.iterator();
 *  
 * Exite uma dualidade entre parametros de tipo e curingas e muitos podem ser declarados
 * com o uso de um ou outro. Por exemplo, aqui estao estao duas declaracoes possiveis
 * para o metodo estatico que troca dois itens indexados em uma lista. A primeira 
 * usa parametros de tipo irrestrito e a segunda um curinga irrestrito:
 * 	
 * 		public static <E> void swap(List<E> list, int i, int j);
 * 		public static void swap(List<?> list, int i, int j);
 * 
 * Em uma API pública a segunda opcao e melhor porque e mais simple. Nao ha parametro de tipo
 * com os quais se preocupar. Como regra, se um parametro de tipo aparecer uma vez em uma
 * declaracao de metodo, substitua-o por curinga. Se ele for um parametro de tipo irrestrito,
 * substitua-o por um curinga irrestrito; se for um parametro de tipo restrito, substitua-o por
 * um curinga em vez de um parametro de tipo: a implementacao simples nao sera compilada.
 * 
 * Ha um problema na segunda declaracao de swap, que usa um curinga em vez de um parametro de
 * tipo: a implementacao simples nao sera compilada:
 * 
 * 		public static void swap(List<?> list, int i, int j) {
 * 			list.set(i, list.set(j, list.get(i)));
 * 		}
 * 
 * Nao parece certo nao podermos devolver para lista um elemento que acabamos de extrair. O
 * problema e que o tipo de list e List<?> e nao podemos inserir nenhum valor exceto null em
 * um objeto List<?>. Felizmente, ha uma maneira de implementar esse metodo sem recorrer a
 * uma conversao invalida ou um tipo bruto. A ideia e criar um metodo auxiliar privado para
 * capturar o tipo de curinga. O metodo auxiliar deve ser um metodo generico para capturar o
 * tipo:
 * 
 * 		public static void swap(List<?> list, int i, int j) {
 * 			swapHelper(list, i, j);
 * 		}
 * 
 * 		private static <E> void swapHelper(List<E> list, int i, int j) {
 * 			list.set(i, list.set(j, list.get(i)));
 * 		}
 * 
 * O metodo swapHelper sabe que list e um objeto List<E>. Portanto, sabe que qualquer valor que
 * capturar nessa lista sera de tipo E e que e seguro inserir qualquer valor de tipo E na lista.
 * Esta declaracao nos permite exportar a declaracao adequada de swap baseada em curinga, ao
 * mesmo tempo em que se beneficia internamente do metodo generico mais complexo.
 * 
 * Resumido: Considere o uso de curingas para API e lembre-se a regra basica (PECS) produto-extends
 * consumidor-super.
 * 
 * */
public class Main {
	
	public static void main(final String[] args) {
			
	}
}