package br.com.effectivejava.item18;

public class Main {

	/**
	 * Item 18: Prefira interfaces a classes abstratas
	 * 
	 * As classes existentes podem ser facilmente ajustadas para implementar uma nova interface,
	 * diferetemente das classes asbtratas, onde devemos criar uma hieraquia classes caso desejamos
	 * fazer uma classe herdar novas funcionanlidades de uma classe.
	 * 
	 * Diferentemente das classes abstratas, interface não possui hierarquia e podemos implementar ela em
	 * qualquer nivel hierarquio.
	 * 
	 * As interface sao ideais para a definicao de mixins: Um mixin e um tipo que uma classe pode
	 * implementar alem de seu seu "tipo primario" para declarar que fornece algum comportamento
	 * opcional, um exemplo disso e <code>Comparable</code> que permite que uma classe declare
	 * que suas instancias sao ordenadas com relacao a outros objetos mutuamente comparaveis.
	 * 
	 * AS INTERFACES PERMITEM MELHORIAS PODEROSAS E SEGURAS NA FUNCIONALIDADES ATRAVES DO IDIOMA
	 * DE CLASSE ENCAPSULADORA. Se voce usar classes abstratas para definir tipos, deixara o 
	 * programador que quiser adicionar alguma funcionalidade sem alternativas a nao ser usar a 
	 * heranca. As classes resultantes serao menos poderosas e mais frageis do que classes
	 * encapsuladoras.
	 * 
	 * Voce pode combinar as vantagens das interfaces e classes abstratas fornecendo uma classe
	 * de IMPLEMENTACAO ESQUELETO abstrata como acompanhamento a cada interface incomum que voce
	 * exportar <code>AbstractMapEntry</code>. A interface continuara definindo o tipo, mas a implementacao esqueleto eliminara
	 * todo o trabalhado de sua implementacao.
	 * 
	 * */
	public static void main(String[] args) {
		
		
		
	}

}
