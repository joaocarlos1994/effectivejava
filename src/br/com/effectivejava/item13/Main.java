package br.com.effectivejava.item13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	/**
	 * Item 13: Reduza a acessibilidade de classes e membros.
	 * 
	 * O fator mais importante mais importante que distingue um modulo bem projetado de um mal projetado
	 * é o grau com que o modulo oculta de outros modulos seus dados internos e outros detalhes de imple-
	 * mentacao. Esse conceito, conhecido como encapsulamento ou ocultacao de informacoes, e um dos prin-
	 * cipios basicos do projeto de softwares[Parnas72].
	 * 
	 * Regra pratica e simples: torne cada classe ou membro tao inacessivel quanto possivel.
	 * 
	 * * Os campos de instancia nunca devem ser publicos. Se um campo de instancia nao for final,
	 * ou for um referencia final a um objeto mutavel, entao, ao tornar o campo publico, voce abrira
	 * mao da possibilidade de limitar os valores que podem ser armazenados no campos.
	 * 
	 * * Classes com campos publicos mutaveis nao tem seguranca de execucao de
	 *
	 * * Um campo final contendo uma referencia a um objeto mutavel apresenta todas desvantagens de um
	 * campos nao-final. Embora a referencia nao possa ser modificada, o objeto referenciado pode - com
	 * resultados desastrosos.
	 * 
	 * */
	
	
	
	
	/**
	 * Observe que a matriz de tamanho diferente de zero e sempre mutavel, portanto, e errado uma classe
	 * ter um campo de matriz final estatico publico, ou um acessador que retorne um campo assim. Se uma
	 * classe tiver esse tipo de campo ou acessador, os clientes poderap modificar seu conteudo da matriz,
	 * levando a uma grave falha de seguranca.
	 * 
	 * Ha duas maneiras maneiras de resolver de corrigir esse problema. Voce pode tornar privada a matriz
	 * publica e adicionar uma lista imutavel publica.
	 * 
	 * Alternativamente voce pode tornar privada a matriz e adicionar um metodo publico que retorne uma
	 * copia da matriz priva
	 * 
	 * */
	private static final String [] VALUES = {"A"};
	public static final List<String> VALUES_ARRAY = Collections.unmodifiableList(Arrays.asList(VALUES));
	//public static final String [] VALUES = {"A"}; VERSAO NAO CORRIGIDA
	
	/**
	 * Acessador
	 * */
	public static String[] getValues() {
		return VALUES;
		//return VALUES.clone();
	}



	public static void main(String[] args) {
		
	}

}
