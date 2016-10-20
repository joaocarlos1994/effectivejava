package br.com.effectivejava.item8.item1;

public class Main {

	/**
	 * Item 8: Obedeça o contrato geral ao sobrepor equals
	 * 
	 * Quando não sobrepor Equals:
	 * 	- Cada instância da classe é inerentemente única.
	 * 	- Não lhe interessa se a classe fornece  um teste de "igualdade lógica"
	 * 	- Uma Superclasse já sobrepôs equals e o comportamento da superclasse é
	 * apropriado a essa classe.
	 * 	- A classe é privada ou privada de pacote e você tem certeza de que seu
	 * método equals nunca será chamado.
	 * 
	 * Quando sobrepor o método equals:
	 * 	- Quando uma classe tem uma noção de igualdade lógica que difere da simples
	 * identidade de objeto e uma superclasse ainda não sobrepôs equals para implementar
	 * o comportamento desejado.
	 * 
	 * */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
