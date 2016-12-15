package br.com.effectivejava.item29;

/**
 * Item 29: Considere conteineres heterogenos com consistecia de tipos.
 * 
 * O uso mais comum dos genericos e em colecoes, como Set e Map, e
 * conteineres com apenas um elemento, como ThreadLocal e AtomicReference.
 * Em todos esses casos, e o conteiner que e parametriza. Normalmente, e 
 * exatamente o que queremos. Um objeto Set tem apenas um parametro de tipo,
 * representano seu tipo de elemento, um objeto Map tem dois, representando
 * seus tipos de chave e valor e assim por diante.
 * 
 * As vezes, no entanto, precisamos de mais flexibilidade. Por exemplo, uma
 * linha de banco de dados pode ter arbitrariamente  muitas colunas e seria
 * bom poder acessar todas elas com consistencia de tipos. Felizmente, ha
 * uma maneira facil de obter esse efeito. A ideia e parametrizar a chave em
 * vez do conteiner. Em seguida, apresente a chave parametrizada para o 
 * conteiner para inserir ou recuperar um valor. O sistema de tipos genericos
 * e usados para garantir que o tipo do valor esteja de acordo com a chave.
 * 
 * Como um exemplo simples considere o exemplo <code>Favorites</code> que
 * permita que seus clientes armazenem e recuperem uma instancia "favorita" de
 * varias outras classes arbitrarias.
 * 
 * Ela se parece com uma mapa comum, exceto pela chave ser parametrizada em vez
 * do mapa. O cliente apresenta um objeto Class ao configurar e acessar favoritos.
 * 
 * Como era de se esperar, esse programa exibe Java cafebabe Favorites.
 * 
 * Uma instancia de Favorites tem consistencia de tipos: ela nunca retornara um 
 * objeto Integer se voce solicitar um objeto Strin. Tambem e heterogenea: diferente
 * do que ocorre em um mapa comum, todas as chaves sao de tipos tipos diferentes.
 * Portanto, Favorites pode ser chamada de conteiner heterogeneo com consistencia
 * de tipo.
 * 
 * Cada instancia de Favorites e representada por um objeto privado 
 * Map<Class<?>, Object> chamado favorites. Talvez pareca nao ser possivel inserir
 * algo nesse objeto Map por causa do tipo de curinga irrestrito. Deve ser notado
 * que o tipo de curinga e aninhado: nao e o tipo do objeto Map que e um tipo de
 * curinga, mas o topo de sua chave. Isso significa que cada chave pode ter um
 * tipo parametrizado diferente: um pode ser Class<String>, o proximo Class<Integer>
 * e assim por diante. E dai que vem a heterogeneidade.
 * 
 * O valor do Map e object, assim nao garante o relacionamento de tipos entre chaves
 * e valores e e por isso que cada valor e do tipo representado por sua chave.
 * 
 * O putFavorite e uma implementacao simples: ela apenas insere em favorites um
 * mapeamento do objeto Class fornecido para a instancia favorita especificada. Assim
 * ela descarta a "vinculacao de tipo" entre a chave e o valor; nao sabe que o valor
 * e uma instancia da chave. Mas isso e valido, porque o metodo getFavorites pode
 * restabelecer e realmente restabelece essa vinculacao.
 * 
 * Esta implementacao e a mais complicada. Primeiro ele captura no mapa favorites o
 * valor correspondente ao objeto Class fornecido. Essa e a referencia de objeto 
 * correta a ser retornada, mas tem o tipo tempo de compilacao errado. Seu tipo e
 * simplesmente Object (o tipo do valor do mapa favorites) e temos que retornar um T.
 * Portanto, a implementacao de getFavorites converte dinamicamente a referencia de 
 * objeto para o tipo representado pelo objeto Class, usando o metodo cast de Class.
 * 
 * O metodo cast da classe Class verifica se seu argumento e uma instancia do tipo
 * representado pelo objeto Class, se for, retorna o argumento, caso contrario lanca
 * uma ClassCastException.
 * 
 * A assinatura do metodo cast se beneficia integralmente do fato de que a classe
 * Class foi generificada. Seu tipo de retorno e o parametro de tipo do objeto
 * Class. Seu tipo de retorno e o parametro de tipo do objeto Class.
 * 
 * Isso e que nos permite fazer com que favorites tenha consistencia de tipos sem
 * recorrer a uma conversao nao verificada para T.
 * 
 * Ha duas limitacoes na classe Favorites. Um cliente malicioso poderia facilmente
 * corromper a consistencia de tipos de tipos de uma instancia de Favorites,
 * simplemente usando um objeto Class em sua forma bruta. Mas o codigo cliente
 * resultante geraria um aviso de nao verificado quando fosse compilado. A maneira
 * de assegurar que Favorites nunca viole sua invariavel de tipo e fazendo o metodo
 * putFavorites verificar se instance e realmente uma instancia do tipo representado
 * por type, para isso usamos a conversao dinamica:
 * 
 * 		// Obtendo consistencia de tipos no tempo de execucao com uma conversao dinamica
 * 		public <T> void putFavorite(Class<T> type, T instance) {
 * 			favorites.put(type, type.cast(instance));
 * 		}
 * 
 * Ha encapsuladores de colecoes em Collections que fazem o mesmo truque, sao chamados de 
 * checkedSet, checkedMap. Suas fabricas estaticas usam um objeto Class(ou dois) alem de
 * uma colecao.
 * 
 * A segunda limitacao da classe Favorites e ela nao poder ser usada em um tipo nao
 * reificavel (Impoe seu tipo no tempo execucao). Em outras palavras, voce pode 
 * armazenar seu objeto String ou String[] favorito, mas nao seu objeto List<String>
 * favorito, pois voce nao pode obter para List<String> : List<String>.class e um 
 * erro de sintaxe, mas tambem e util. List<String> e List<Integer> compartilham o mesmo
 * o mesmo objeto Class, que e List.class, assim seria desastroso para os elementos 
 * internos de um objeto Favorites se os "literais de tipo" List<String>.class e
 * List<Integer>.class fossem validos e retornassem a mesma referencia de objeto.
 * 
 * Para solucionar o problema da segunda limitacao existe um tecnica chamada tokens de
 * supertipos, assim o token de tipo usados por Favorites sao irrestritos: getFavorite e
 * putFavorite aceitam qualquer objeto Class. Em algumas situacoes voce pode ter que
 * limitar os tipos que podem ser passados para um metodo. Isso pode ser feito com um
 * token de tipo restrito, que e simplesmente um token de tipo que impoe um limite ao tipo
 * a ser representado.
 * 
 * Por exemplo, aqui esta o metodo que le uma anotacao no tempo  de execucao. Esse metodo
 * vem da interface AnnotatedElement, que e implementada pelos tipos reflexivo que 
 * representam classes, metodos, campos e outros elementos de programa
 * 
 * 		public <T extends Annotation> T getAnnotation(Class<T> annotationType);
 * 
 * O argumento annotationType e um token de tipo restrito que representa um tipo de
 * anotacao. O metodo retorna a anotacao desse tipo contida no elemento, se ele tiver uma, 
 * ou null, se nao tiver. Na verdade, um elemento anotado e um coneiner heterogeneo com
 * consistencia de tipos cujas chaves sao tipos de anotacao.
 * 
 * Suponhamos que voce tivesse um objeto de tipo Class<?> e quisesse passa-lo para um
 * metodo que demandasse um token de tipo restrito, como getAnnotation. Poderia converter
 * o objeto para Class<? extends Annotation>, mas essa conversao e nao-verificada, portanto,
 * geraria um aviso em tempo de compilacao. Felizmente, a classe Class fornece um metodo de
 * instancia que executa esse tipo de conversao seguramente e dinamicamente. O metodo se
 * chama asSubclass e converter o objeto Class em que e chamado na representacao de uma
 * subclasse da classe representada por seu argumento.
 * 
 * 
 * 
 * */
public class Main {

	public static void main(String[] args) {
		
		final Favorites f = new Favorites();
		f.putFavorite(String.class, "Java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, Favorites.class);
		final String favoriteString = f.getFavorite(String.class);
		final Integer favoriteInteger = f.getFavorite(Integer.class);
		final Class<?> favoriteClass = f.getFavorite(Class.class);
		System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
	}

}
