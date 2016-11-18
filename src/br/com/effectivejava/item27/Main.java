package br.com.effectivejava.item27;

import static br.com.effectivejava.item27.UnaryGeneric.identityFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Item 27: Prefira metodos genericos.
 * 
 * Metodos utilitarios estaticos sao particulamente bons candidatos
 * a generificacao.
 * 
 * A criacaoo de metodos genericos e semelhante a criacao de tipos
 * genericos. Considere o metodo numero 1 desta classe.
 * 
 * O metodo sera compilado, mas tera dois avisos, um quando o Hashet
 * e criado, outro quando usamos o metodo addAll.
 * 
 * Para eliminar esses avisos e dar ao codigo tipos consistentes,
 * vamos modificar a declaracao do metodo para que declare um parametro
 * de tipo representando o tipo de elemento dos tres conjuntos (dois 
 * argumento e o valor de retorno) e use o parametro de tipo no metodo.
 * 
 * A LISTA DE PARAMETROS DE TIPO, QUE DECLARA O PARAMETRO DE TIPO, E
 * INSERIDA ENTRE OS MODIFICADORES DO METODO E SEU TIPO DE RETORNO.
 * Nesse exemplo, a lista de parametros de tipo e <E> e o tipo de
 * retorno é Set<E>. Veja o metodo 2 desta classe.
 * 
 * Agora o metodo numero 2 sera compilado sem gerar nenhum aviso e
 * fornecera consistencia de tipos assim como facilidade de uso.
 * 
 * Uma limitacao do metodo union e que os tres tipos precisam ser
 * iguais, para tornar o metodo mais flexivel considere o uso de 
 * tipos de curinga restrito.
 * 
 * Um recurso dos metodos genericos digno de nota e que voce nao
 * precisa especificar o valor do parametro de tipo explicitamente
 * como e necessario na chamada a construtores genericos. O
 * compilador descobre o valor dos parametros de tipo examinando
 * os tipos dos argumentos do metodo. No caso do programa acima,
 * o compilador ve que os dois argumentos de union sao de tipo
 * Set<String>, e portanto, sabe que o parametro de tipo E deve
 * ser String. Esse processo e chamado de INFERENCIA DE TIPO.
 * 
 * Como discutido no Item 1, voce pode explorar a inferencia de
 * tipo fornecida pela chamada de metodo generico para facilitar
 * o processo de criacao de instancia de parametrizados. Como deve
 * lembrar, a necessidade de passar os valores de parametros de
 * tipo explicitamente na chamada a construtores genericos pode ser
 * incomoda. Os parametros de tipo aparecem redundatemente nos lados
 * esquerdo e direito das declaracoes de variaveis.
 * ATENCAO: ISSO JA ESTA DISPONIVEL AUTOMATICAMENTE NO JAVA 7.
 * 
 * 			//Criacao de instancias de tipo parametrizado em
 * 			Map<String, List<String>> anagrams = 
 * 							new HashMap<List, List<String>>();
 * 
 * 			//Metodo de fabricacao estatico generico
 * 			public static <K,V> HashMap<K,V> newHashMap() {
 * 				return new HashMap(K,V);
 * 			}
 * 
 * Com esse metodo de fabricacao estatico generico, voce pode
 * substituir a declaracao repetitiva acima por essa mais consisa.
 * 
 * 			Map<String, List<String>> anagrams = newHashMap();
 * 
 * Um padrão relacionado a esse tipo e a fabrica de singleton generico.
 * 
 * 
 * Considere o <code>UnaryGeneric</code>: A conversao de 
 * IDENTITY_FUNCTION para (UnaryFunction <T>) gera um aviso de conversao
 * nao verificada, ja que UnaryFunction<Object> nao e um objeto
 * UnaryFunction<T> para qualquer T. Mas a funcao identidade e especial
 * pois retorna seu argumento inalterado, portanto, sabemos que ela tem
 * tipos consistentes para usa-la como um objeto UnaryFunction<T>
 * independente do valor de T.
 * 
 * E permitido, embora relativamente raro, um parametro de tipo ser
 * limitado por alguma expressao que envolva esse mesmo parametro de
 * tipo Isso e conhecido como LIMITE DE TIPO RECURSIVO. O uso mais
 * comum dos limites de tipo recursivo e na conexacao da interface
 * Comparable, que define uma ordem natural de tipos. Exemplo:
 * 
 * 		public static <T extends Comparable<T>> T max(List<T> list){}
 * 
 * O limite de tipo <T extends Comparable> pode ser lido como "para
 * cada tipo T que possa ser comparado a ele proprio", o que 
 * corresponde a mais ou menos a mesma coisa que a nocao de 
 * compatibilidade mutua.
 * 
 * Veja o metodo numero 3 para calcular o valor maximo de uma lista
 * de acordo com a ordem natural de seus elementos e e compilado sem
 * erros ou avisos.
 * 
 * Resumindo: Os metodos genericos, como os tipos genericos, sao mais
 * seguros e faceis de usar do que os metodos que demandam que seus
 * clientes convertam parametros de entrada e valores de retorno. Como
 * ocorre com os tipos, voce deve se certificar de que seus novos
 * metodos possam ser usados sem conversoes, o que geralmente significa
 * torna-los genericos. E como tambem ocorre com os tipos, voce deve
 * generificar os metodos existentes para tornar a vida mais facil
 * para os novos usuarios sem prejudicar clientes existentes.
 * 
 * */
public class Main {
	
	//Numero 1
	public static Set union(Set s1, Set s2) {
		Set result = new HashSet();
		result.addAll(s2);
		return result;
	}
	
	//Metodo generico Numero 2
	public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
	
	//Metodo 3
	//Retorna o valor maximo de uma lista - usa o limite de tipo recursivo
	public static <T extends Comparable<T>> T max(List<T> list){
		Iterator<T> i = list.iterator();
		T result = i.next();
		while (i.hasNext()) {
			T t = i.next();
			if (t.compareTo(result) > 0)
				result = t;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		Set<String> guys = new HashSet<>(
				Arrays.asList("Tom", "Dick", "Harry"));
		Set<String> stooges = new HashSet<>(
				Arrays.asList("Larry", "Moe", "Curl"));
		
		Set<String> aflCio = union2(guys, stooges);
		System.out.println(aflCio);
		
		///////////////////////////////////////////////////
		
		String[] strings = {"jute", "hemp", "nylon"};
		UnaryFunction<String> sameString = identityFunction();
		for (final String s : strings) {
			sameString.apply(s);
		}
		
	}

}
