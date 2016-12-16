package br.com.effectivejava.item30;

/**
 * Na versao 1.5, duas familias de tipos de referencia foram adicionados
 * a linguaguem: uma nova especie de classe chamada tipo ENUM e uma nova
 * especie de interface chamada TIPO DE ANOTACAO.
 * 
 * 
 * Item 30: Use enumeracoes em vez de constantes int
 * 
 * Um tipo ENUMERADO e um tipo cujos valores validos sao compostos por um
 * conjunto fixo de constantes, como as estacoes do ano. Antes dos tipos
 * enum serem adicionados a linguagem, eles eram representados por grupos
 * de constantes int nomeadas, uma para cada membro. Ex.:
 * 
 * // O padrao de enumeracao de inteiros - muito diferente
 * // Padrao de enumeracao de inteiros
 * public static final int APPCE_FUJI = 0;
 * public static final int ORANGE_NAVEL = 0;
 * 
 * Esta tecnica e problematica pois nao oferece a consistencia de tipos e
 * pouco com relacao a conveniencia. O compilador nao reclamara se voce
 * passar uma maca para um metodo que esteja esperando uma laranja,
 * comparar macas com laranjas com o operador ==, ou pior:
 * 
 * // Suco de maca com sabor citrico forte
 * int i = (APPLE_FUJI - ORANGE_TEMPLE) / APPLE_PIPPIN;
 * 
 * Cada constante possui o prefixo APPLE e o nome de cada constante de
 * laranja, o mesmo ocorre com ORANGE.
 * 
 * Assim programas que usam o padrao de enumeracao de inteiros sao frageis.
 * Ja que os enum int sao constantes de tempo de compilacao, sao compilados
 * nos clientes que os usam. Quando o int associado a uma constante enum e
 * alterado, seus clientes tem que ser recompilados.
 * 
 * Nao ha uma maneira facil de converter constantes enumeradas int em strings
 * exibiveis. Nao ha uma maneira confiavel de iterar por todas as constantes
 * enumeradas de tipo int de um grupo, nem mesmo obter o tamanho de um grupo
 * int enumerado.
 * 
 * Voce pode encontrar uma variacao desse padrao onde constantes String sejam
 * usadas em vez de constantes int, porem e menos desejavel, pois apresenta
 * um problema de desenpenho na comparacao destas strings. Se esse tipo de 
 * constantes de string embutida em codigo tiver um erro tipografico, escapara
 * da deteccao de tempo de compilacao.
 * 
 * Felizmente na jdk 1.5 foram adicionados os tipos enum. Os tipos enum sao
 * classes que exportam uma instancia de cada constante da enumeracao atraves
 * de um campo final estatico publico. Os tipos enum sao finais, ja que nao tem
 * construtores acessiveis, assim nao podem criar instancia de um tipo enum nem
 * estende-lo, nao pode existir instancia, apenas as constantes enum declaradas.
 * 
 * Enums fornecem consistencia de tipos no tempo de compilacao. Se voce declarar
 * um parametro para ser de tipo Apple, tera garantia de que qualquer referencia
 * de objeto nao-nula tera um dos tres valores validos de Apple. Tentativas de
 * passar valores do tipo errado resultarao em erros de tempo de compilacao, 
 * assim como tentativas de atribuir uma expressao de um tipo enum a uma variavel de
 * outro tipo enum ou usar o operador == para comparar valores de tipos diferentes.
 * 
 * Tipos enum com constantes nomeadas identicamente coexistem sem problemas porque
 * cada tipo tem seu proprio espaco de nome. Voce pode adicionar ou reordenar
 * constantes em um tipo enum sem recompilar seus clientes porque os campos que
 * exportam as constantes fornecem uma camada de isolamento entre um tipo enum
 * e seus clientes: os valores nao sao compilados nos clientes como sao no padrao
 * enum int, contudo voce pode converter enums em strings exibiveis chamando seu
 * metodo toString.
 * 
 * As enums permitem que voce adicione metodos e campos arbitrarios e implemente
 * interface interface arbitrarias. Elas fornecem implementacoes de alta
 * qualidade de todos os metodos de Object, implementam Comparable e Serializable
 * e sua forma serializada foi projetada para nao aceitar a maioria das alteracoes
 * feitasno tipo enum.
 * 
 * Adicionando metodos e campos na enum voce para comecar associar dados a suas
 * constantes, assim voce ganha pode se beneficiar de um metodo, por exemplo
 * um metodo que retorne a cor de uma fruta ou que retorne a imagem dela.
 * 
 * Como exemplo sofisticados, considere o <code>Planet</code> e um tipo enum
 * sofisticado. PARA ASSOCIAR DADOS A CONSTANTES ENUM DECLARE CAMPOS DE INSTANCIA
 * E CRIE UM CONSTRUTOR QUE OS DADOS E OS ARMAZENE NOS CAMPOS. Enums sao imutaveis,
 * portanto, todos os campos devem ser finais. No caso de Planet, o construtor
 * tambem calcula e armazena a gravidade de superfice, mas isso e apenas uma
 * otimizacao.
 * 
 * Observe que no metodo main retorna uma matriz de seus valores na ordem em que
 * foram declarados
 * 
 * O exmplo Planet sao suficientes para a maioria dos tipos enum, mas podemos
 * precisar de outras. Ha dados diferentes associados a cada constante de Planet,
 * mas as vezes e preciso associar COMPORTAMENTOS basicamente diferentes a cada
 * constante. Por exemplo uma calculadora de quatro funcoes e quisesse fornecer
 * um metodo para executar a operacao aritmetica representada por cada constante.
 * Uma maneira de fazer isso e ativado o valor do enum. Veja o 
 * <code>Operation</code>.
 * 
 * A <code>Operation</code> funciona mais nao e muito elegante, ela nao sera 
 * compilado sem a instrucao throw porque o final do metodo e tecnicamente
 * alcancavel, sem nunca ser alcancado. Pior, o codigo e fragil. Se voce
 * adicionar uma nova constante enum, mas esquecer de adicionar a instrucao
 * switch uma intrucao case correspondente, o enum sera compilado, mas
 * falhara no tempo de execucao.
 * 
 * Felizmente, ha uma maneira melhor de associar um comportamento diferente
 * a cada constante enumerada: declare um metodo abstato apply no tipo enum
 * e sobreponha-o com um metodo concreto para cada constante em um CORPO DE
 * CLASSE ESPECIFICO DE CONSTANTES. Ex.: <code>Operation2</code>
 * 
 * Se voce adicionar uma nova constante a segunda versao de Operation, e 
 * improvavel que esqueca de forncecer um metodo apply.
 * 
 * As implementacoes de metodo especificas de constante podem ser combinadas
 * com dados especificos de constante. Por exemplo o <code>Operation3</code>
 * que sobrepoe o metodo toString para retornar o simbolo normalmente
 * associado a operacao.
 * 
 * Tipos enum tem um metodo valueOf(String) gerado automaticamente que
 * converte o nome da constante na propria constante. Se voce sobrepuser
 * o metodo toString de um tipo enum, considere a criacao de um metodo
 * fromString para converter a representacao personalizada em forma de 
 * string novamente no enum correspondente.
 * 
 * 		// Implementando um metodo fromString em tipo enum
 * 		private static final Map<String, Operation> stringToEnum = ...
 * 		static { // Inicializa o mapeamento do nome da constante para a propria
 * 			for (Operation op : values())
 * 				stringToEnum.put(op.toString(), op);
 * 		}
 * 
 * 		// Retorna Operation para a string ou null se a string for invalida
 * 		public static Operation fromString(final String symbol) {
 * 			return stringToEnum.get(symbol);
 * 		}
 * 
 * Tentar fazer cada constante colocar a si propria no mapa a partir de seu
 * proprio construtor causaria um erro de compilacao. Isso e bom, porque
 * causaria NullPointerException se fosse valido. Construtores de enumeracao
 * nao podem acessar os campos estaticos do enum, exceto campos de constante
 * no tempo de compilacao. Essa restricao e necessaria porque esses campos
 * estaticos ainda nao foram inicializados quando os construtores sao
 * executados.
 * 
 * Uma desvantagem das implementacoes de metodo especifica de constante e
 * que elas tornam mais dificil o compartilhamento de codigo entre constante
 * enumeradas. Por exemplo i <code>PayrollDay</code> esse codigo e
 * inegavelmente conciso, mas perigoso do ponto de vista de manutencao.
 * Suponhamos que voce adicionasse um elemento ao enum, talvez um valor
 * especial para representar uma folga, mas esquecesse de adicionar a 
 * instrucao switch uma instrucao case correspondente. O programa continuara
 * sendo compilado, mas o metodo pay pagara ao trabalhador silenciosamente
 * pelo dia de folga a mesma quantia de um dia de semana comum.
 * 
 * Para executar o calculo do pagamento seguramente com implementacoes de
 * metodo especifica de constante, voce teria que duplicar o calculo de 
 * pagamento de hora extra para cada constante, voce teria que duplicar o
 * calculo de pagamento de hora extra para cada constante ou transferir o
 * calculo oara dois metodos auxiliares e chamar o metodo apropriado a cada
 * constante.
 * 
 * O texto padronizado poderia ser reduzido pela substituicao do metodo
 * abstrato overtimePay de PayrollDay por um metodo concreto que executasse
 * o calculo da hora extra para dias uteis. Assim, somente os dias do fim
 * de semana teriam que sobrepor o metodo. Mas isso aprensentaria a mesma
 * desvantagem da instrucao switch.
 * 
 * A maneira correta de implementar esta enum e transferir o calculo de
 * pagamento de hora extra para o enum estrategico, eliminando a 
 * necessidade de uma instrucao switch ou uma implementacao de metodo 
 * especifica de constante em PayrollDay. Embora esse padrao seja menos
 * conciso do que a instrucao switch, e mais seguro e flexivel.
 * 
 * Uma pequena desvantagem no desepenho que os enums apresentam sobre as
 * constantes int e que ha um custo de espaco e tempo para carga e
 * inicializacao de tipos enum.
 * 
 * Voce deve usar enums sempre qure precisar de um cojunto fixo de 
 * costante. Os enums sao muito mais legiveis, seguros e poderosos. Muitos
 * enums nao requerem construtores ou membros explicitos, mas varios outros
 * se beneficiam da associacao de dados a cada constante e do fornecimento
 * de metodos cujo comportamento e afetado por esses dados.
 * 
 * 
 * 
 * */
public class Main {

	public static void main(String[] args) {
		
		double mass = 100 / Planet.EARTH.getSurfaceGravity();
		for (final Planet p : Planet.values()) {
			System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
		}
		
		////////////////////////////////////////////////////////////////////////
		
		double x = 10;
		double y = 20;
		
		for (final Operation3 op : Operation3.values()) {
			System.out.printf("%f %s %f = %f%n",
					x, op, y, op.apply(x, y));
		}
		
		////////////////////////////////////////////////////////////////////////
		
		double x1 = 10;
		double y1 = 10;
		
		double result = PayrollDay2.FRIDAY.pay(x1, y1);
		System.out.println("Resultado: " + result);

	}

}
