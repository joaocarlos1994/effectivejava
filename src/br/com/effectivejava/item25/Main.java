package br.com.effectivejava.item25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Item 25: Prefira listas a matrizes
 * 
 * Palavars chaves: Covariante  -> Sub2 e um subtipo de Sub
 * 					Invariantes -> Sub2 nao e um subtipo de Sub
 * 					Supressao   -> Impor restricoes apenas em tempo de compilacao
 * 					Nao reificaveis -> Um tipo reificavel e aquele cuja
 * representacao no tempo de execucao contem menos informacoes do que sua
 * representacao no tempo de compilacao.
 * 
 * 
 * As matrizes diferem em dois aspectos importantes. Primeiro
 * matrizes sao covariantes, ou seja, siginifica simplesmente
 * que se Sub for um subtipo de Super, entao, o tipo de matriz
 * Sub[] sera um subtipo de Super[]. Os genericos, ao
 * contrario, sao invariaveis: para dois tipos distintos
 * quaisquer Type1 e Type2, List<Type1> nao sera subtipo nem
 * supertipo de List<Type2>. Voce pode pensar que genericos que
 * os genericos sao deficientes, mas e possivel que as matrizes
 * e que sejam.
 * 
 * 				//Falaha no tempo de execucao
 * 	Object[] objectArray = new Long[1];
 * 	objectArray[0] = "I don't fit in"	//Throws ArraysStoreException
 * 
 * 				//Nao sera compilado
 * 	List<Object> ol = new ArrayList<Long>(); Tipos incompativeis
 * 	ol.add("I dont't fir in")
 * 
 * De qualquer voce nao podera inserir um long em um matrizes de string
 * descobrindo o erro em tempo de execucao, com uma lista descobrira
 * em tempo de compilacao.
 * 
 * A segunda grande diferenca e que matrizes sao REIFICADAS, ou seja,
 * conhecem e impoem seus tipos de elementos em tempo de execucao,
 * como visto a cima. Ja o genericos impoem suas restricoes de tipo
 * apenas em tempo de compilacao e descartam (ou surprimem) as 
 * informacoes dos elementos no tempo de execucao. A supressao e o que
 * permite que os tipos genericos interoperem livremente com codigos 
 * herdados que nao usam genericos.
 * 
 * Devido a essas diferencas fundamentais, as matrizes e os genericos
 * nao combinam. Por exemplo, nao e valido criar uma matriz com um
 * tipo generico, um tipo parametrizado ou um parametro de tipo.
 * Nenhuma dessas expressoes de criacao de matrizes e valida: 
 * new List<E>[], new List<String>[], new E[]. Todas resultarao em
 * erros de CRIACAO DE MATRIZ GENERICA no tempo de compilacao.
 * 
 * Nao e valido criar matrizes genericas porque ela nao teria tipos
 * consistentes. Se fosse valido, as conversoes geradas pelo
 * compilador em um programa que de outra forma estaria correto
 * poderiam falhar no tempo de execucao com um ClassCastException.
 * Isso violaria a garantia basica fornecida pelo sistema de tipos
 * genericos. Segue o exemplo no metodo main.
 * 
 * Tipos como E, List<E> e List<String> sao tecnicamente conhecido
 * como tipo nao reificaveis, pois a representacao no tempo de
 * execucao contem menos informacoes do que sua representacao no
 * tempo de compilacao. Os unicos tipos parametrizados que sao
 * reificaveis sao os tipos de curinga irrestrito como List<?>
 * e Map<?,?>
 * 
 * Resumindo: Matrizes e genericos tem regas muito diferentes
 * referentes aos tipos. As matrizes sao covariantes e reificaveis;
 * os genericos sao invariaveis e suprimidos. Como consequencia, as
 * matrizes fornecem consistencia de tipos no tempo de execucao, mas
 * nao no de compilacao, e vice-versa para os genericos.
 * 
 * */
public class Main {

	public static void main(String[] args) {
		
		//Porque a criacao de matriz generica nao e valida - Nao sera compilado! 
		List<String> [] stringLists = new ArrayList<String>[1];
		List<Integer> intList = Arrays.asList(42);
		Object[] objects = stringLists;
		objects[0] = intList;
		String s = stringLists[0].get(0);

	}

}
