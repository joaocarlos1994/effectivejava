package br.com.effectivejava.item22;

import java.util.Collections;

/**
 * Item 22: Prefira classes membros estaticas em vez de nao-estaticas
 * 
 * Existe 4 tipos de classes aninhadas: classes membro estaticas; classes
 * membros nao-estaticas; classes anonimas e classes locais. Todas,
 * execeto o primeiro tipo, sao conhecidas como classes internas.
 * 
 * Classe membro estatico e o tipo mais simples de classe aninhada. E
 * melhor considera-la como uma classe comum declarada dentro de outra
 * classe e que tem acesso a todos membros da classe delimitadora, ate
 * declarados privados.
 * 
 * Uso comum de uma classe membro estatica e COMO classe auxiliar publica,
 * que so e util junto com sua classe externa. O enum Operation deveria
 * ser uma classe de membro estatica publica da classe Calculator, assim
 * os clientes poderiam referenciar operacoes usando nomes como 
 * Calculador.Operation.PLUS.
 * 
 * UNICA DIFERENCA ENTRE CLASSES MEMBROS ESTATICAS E NAO-ESTATICAS E QUE
 * AS CLASSES MEMBRO ESTATICASTEM O MODIFICADOR STATIC EM SUAS DECLARACOES.
 * APESAR DA SEMELHANCA SINTATICA, ESSES DOIS TIPOS DE CLASSES ANINHADAS
 * SAO MUITOS DIFERENTES.
 * 
 * Cada instancia de uma classe de membro nao-estatica esta implicitamente
 * associada a uma instancia delimitadora de sua classe externa. Dentro dos
 * metodos de instancia de uma classe membro nao-estatica, voce pode chamar
 * metodos da instancia delimitadora ou obter uma referencia a instancia
 * delimitadora usando a estrutura THIS QUALIFICADA.
 * 
 * Se uma instancia de uma classe aninhada puder existir isoladamente
 * de sua classe delimitadora, entao, a classe aninhanda deve ser uma
 * classe membro estatica: e impossivel criar uma instancia de uma classe
 * membro nao-estatica sem uma instancia delimitadora.
 * 
 * A associacao entre a instancia de uma classe membro nao-estatica e sua
 * instancia delimitadora e estabelecida quando aquele e criada; ela nao
 * pode ser modificada depois disso. Como era de se esperar, a associacao
 * ocupa espaco na instancia da classe membro nao-estatica e aumenta o
 * tempo de sua construcao.
 * 
 * Um uso comum de uma classe membro nao-estatica e na definicao de um
 * adaptador que permita que uma instancia da classse externa seja
 * visualizada como uma instancia de alguma classe nao-relacionada, um
 * exemplos de classe de implementacao de Map.
 * 
 * Ao declarar uma classe membro que nao precise acessar uma instancia
 * delimitadora, insira sempre o modificador static em sua declaracao
 * tornando-a uma classe membro estática em vez de nao-estatica. Se
 * omitir esse modificador, cada instancia tera uma referencia inutil
 * a sua instancia delimitadora.
 * 
 * Um uso comum das classes membros estaticas privadas e na representacao
 * de componentes do objeto representando por sua classe delimitadora,
 * por exemplo uma instancia de Map, que tem um objeto Entry interno para
 * cada par chave-valor do mapa, nao considerar ela estatica seria um erro.
 * 
 * Lembrar que sempre Classe membro e um elemento da API exportada e nao 
 * pode ser transformada de uma classe membro nao-estatica e nao pode ser
 * transformada de uma classe membro nao-estatica para um estatica em uma
 * versao subsequente sem violar o compartibilidade binaria.
 * 
 * Classe anonimas sao sem nome, nao é membro de uma classe delimitadora,
 * e declarada e instanciada simultaneamente no momento de ser usada. Ela
 * tem instancias delimitadoras quando, e somente quando, ocorrem em um
 * contexto nao-estatico.
 * 
 * Possui muitas limitacoes, nao podendo instancianda a nao ser no ponto
 * em que sao declaradas a nao ser no ponto que sao declaradas. Nao podem
 * executar testes instanceof ou fazer qualquer coisa que demande a
 * nomeacao, nao pode declarar uma classe anonima para implementar varias
 * interfaces ao mesmo tempo, os clientes de uma classe anonima nao podem
 * chamar nenhum membro exceto que ela herda de seu supertipo.
 * 
 * Um uso comum das classes anonumas e na criacao dinamica de objetos de
 * funcao, como instancia anonima de Comparator, Runnable, Thread ou 
 * TimerTask. Um terceiro uso comum e dentro do metodo de fabricacao
 * estatico.
 * 
 * Resumindo: Se uma classe aninhada tiver que ficar visivel fora de um
 * unico metodo ou for longa demais para caber confortavelmente dentro de
 * um metodo, use uma classe de membro. Se cada instancia da classe membro
 * precisar de uma referencia a sua instancia delimitadora, torne-a nao
 * estatica; caso contrario torne-a estatica. Supondo que a classe pertenca
 * a uma metodo, se voce tiver que criar instancia a partir de apenas um local
 * e houver um tipo preexistente que caracterize a classe, torne-a a uma classe
 * anonima, caso contrario torne-a uma classe local.
 * 
 * 
 * */
public class Main {
	
	public static void main(String[] args) {
		
		
		
	}
	
}
