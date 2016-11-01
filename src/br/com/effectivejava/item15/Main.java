package br.com.effectivejava.item15;

public class Main {

	/**
	 * Item 15: Reduza a mutabilidade.
	 * 
	 * Uma classe imutavel e simplemente uma classe cujas instancias nao podem
	 * ser modificadas.
	 * 
	 * 5 Passos para tornar uma classe imutavel:
	 * 
	 * * 1 - Nao forneca nenhum metodo que modifique o estado do objeto (Sets) *
	 * * 2 - Assegure que as classes nao possam ser estendidas. Isso impede que
	 * subclasses negligentes ou maliciosas comprometam o comportamento imutavel
	 * da classe comportando-se como se o estado do objeto tivesse mudado. 
	 * * 3 - Torne final todos os campos. 
	 * * 4 - Torne privado (private) todos os campos. Isso impede que os clientes 
	 * obtenham acesso a objetos mutaveis referenciados pelos campos e modifiquem
	 * esses objetos diretamente. 
	 * * 5 - Assegure acesso exclusivo a qualquer componente imutavel. Se sua classe
	 * tiver algum campo que referencie objetos mutaveis, assegure que os
	 * clientes da classe nao possam obter referencias a esses objetos. Faça
	 * copias defensivas em construtores, acessadores e metodos readObject.
	 * 
	 * Objetos imutaveis sao simples, so pode estar em um estado, aquele que foi
	 * criado e podem ser compartilhado livremente.
	 * 
	 * Uma maneira facil de faze-lo e fornecendo constantes finais estaticas
	 * publicas para valores usados com frequencia.
	 * 
	 * 
	 * Objetos imutaveis constituem otimos blocos de construcao para outros
	 * objetos, seja mutaveis ou imutaveis.
	 * 
	 * A unica desvantagem real das classes imutaveis e que elas requerem um
	 * objeto separado para cada valor distinto.
	 * 
	 * Obs: A classe StringBuilder e uma classe complementar de String, por isso
	 * a concatenacao dela e mais rapida, pelo fato dela ser uma classe mutavel,
	 * e a classe string ser imutavel.
	 * 
	 */
	public static void main(String[] args) {

	}

}
