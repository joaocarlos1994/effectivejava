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
 * */
public class Main {
	
	public static void main(String[] args) {
		
		
		
	}
	
}
