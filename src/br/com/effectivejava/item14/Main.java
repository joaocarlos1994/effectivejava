package br.com.effectivejava.item14;

public class Main {

	
	/**
	 * Item 14: Em classes publicas, use metodos acessadores e nao campos publicos.
	 * 
	 * Ja que os campos de dados dessas classes sao acessados diretamente, elas nao oferecem os beneficios
	 * do encapsulamento. Voce nap pode alterar a representacao sem alterar a API, nao pode impor invariaveis
	 * e nao pode tomar uma medida auxiliar.
	 * 
	 * * Se uma classe puder ser acessada fora de seu pacote, forneca metodos acessadores para preserva a flexi-
	 * bilidade de alterar a representacao interna da classe.
	 * */
	public class Point {
		public double x;
		public double y;
	}
	
	public static void main(String[] args) {

	}

}
