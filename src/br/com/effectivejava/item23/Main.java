package br.com.effectivejava.item23;

/**
 * Item 23: Nao use tipos brutos em codigo novo.
 * 
 * Uma classe ou interface cuja declaracoes tem um ou mais
 * PARAMETROS DE TIPO e uma classe ou interface GENERICA. Por
 * exemplo a interface List tem um unico parametro de tipo, E,
 * representando o tipo da lista.
 * 
 * Cada tipo generico define um conjunto de TIPOS PARAMETRIZADOS, que
 * sao compostos do nome da classe ou interface seguido por uma lista
 * de PARAMETROS DE TIPO REAIS entre colchetes angulares correspondentes
 * aos parametros de tipo formais do tipo generico. Por exemplo,
 * List<String> e um tipo parametrizado representando uma lista cujos
 * elementos sao do tipo String (String e o parametro de tipo real
 * correspondente ao parametro de tipo formal E)
 * 
 * Cada tipo generico define um TIPO BRUTO, que e o nome do tipo generico
 * usado sem nenhum parametro de tipo real que o acompanhe. Por exemplo, o
 * tipo bruto correspodente a List<E> é List. Os tipos brutos se comportam
 * como se todas informacoes do tipo generico tivessem sido apagadas da
 * declaracao de tipo. Na pratica, o tipo List se comporta da mesma forma
 * que o tipo de interface List se comportava antes dos genericos serem 
 * adicionados a plataforma.
 * 
 * Minha colecao de selos. Contem apenas instancias de Stamp.
 * 			
 * 				private final stamps = ...;
 * 
 * Se voce inserir acidentalmente uma moeda sem sua colecao de selos, a
 * insercao incorreta sera compilada e executada sem erro:
 * 
 * 				stamps.add(new Coin(...))
 * 
 * Voce nao vera uum erro ate recuperar a moeda na colecao de selos:
 * 
 * 				for(int i = stamps.interator(); i.hasNext();) {
 * 					Stamp s = i.next();   ...// Faz algo com o selo
 * 				}
 * 
 * Verificando a o codigo a cima, compensa descobrir erros assim  no tempo
 * de compilacao. Nesse caso, voce nao descobria o erro antes do tempo de
 * execucao, quando voce se deparar com a ClassCastException tera que
 * percorrrer a base do codigo procurando a chamada de metodo que inseriu a
 * moeda na colecao de selos.
 * 
 * Com os genericos, voce substituiria o comentario por uma declaracao de
 * tipo aperfeiçoada para a colecao que passaria ao compilador as
 * informacoes.
 * 
 * Por essa declaracao o compilador sabera que stamps deve conter apenas
 * instancias de Stamp e garantira que isso ocorra. Quando stamps e
 * declarada com um tipo parametrizado, a insercao incorreta gera mensagem
 * de erro de tempo de compilacao que informa exatamente o que esta errado.
 * 
 * */
public class Main {

	public static void main(String[] args) {

	}

}
