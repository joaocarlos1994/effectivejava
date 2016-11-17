package br.com.effectivejava.item25;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * */
public class MatrizSincronizada {
	
	/**
	 * Obtencao do resumo sem genericos e com falha na concorrencia!
	 * 
	 * "Métodos" aleatorios nao devem ser chamados em uma regiao
	 * sincronizada.
	 * */
	static Object reduce(final List list, Function f, Object initVal) {
		synchronized (list) {
			Object result = initVal;
			for (final Object o : list)
				result = f.apply(result, o);
			return result;
		}
	}
	
	/**
	 * Devido a nao poder ter metodos aleatorios em metodos sincronizados,
	 * devemos modificar o metodo reduce para copiar o conteudo da lista
	 * ao mesmo tempo que mantem o bloqueio, o que lhe permitira obter o
	 * resumo na copia.
	 * */
	static Object reduce2(final List list, Function f, Object initVal) {
		synchronized (list) {
			Object[] snapshot = list.toArray();//Bloqueia a lista internamente
			Object result = initVal;
			for (final Object o : snapshot)
				result = f.apply(result, o);
			return result;
		}
	}
	
	/**
	 * Aqui esta uma tentativa ingenua de aplicar a versao revisada do metodo
	 * reduce usando o <code>Function2</code>. Trata-se de um metodo generico,
	 * onde sera necessario fazer um cast para (E[]) eliminando assim o erro.
	 * Porem agora voce vera um aviso: Warning: [unchecked] unchecked cast - 
	 * lembre-se que informacoes sobre tipo dos elementos genericos sao 
	 * apagas dos genericos no tempo de execucao. Esse programa ira funcionar,
	 * mas nao sera seguro. O tipo de snapshot no tempo de compilcao e E[]
	 * que poderia ser String[], Integer[] ou qualquer outra especie de matriz.
	 * O tipo no tempo de execucao e Object[] e isso e perigoso. Conversao para
	 * matrizes de tipos nao reificaveis so devem ser usadas sob circunstancias
	 * especiais.
	 * */
	static <E> E reduce3(final List<E> list, Function2<E> f, E initVal) {
		synchronized (list) {
			E[] snapshot = (E[]) list.toArray();//Bloqueia a lista internamente
			E result = initVal;
			for (final E e : snapshot)
				result = f.apply(result, e);
			return result;
		}
	}
	
	
	/**
	 * Essa versao e um pouco mais verbosa de usar, mas vale apena usar pois
	 * nao havera um ClassCastException no tempo de execucao.
	 * */
	static <E> E reduce4(final List<E> list, Function2<E> f, E initVal) {
		List<E> snapshot;
		synchronized (list) {
			snapshot = new ArrayList<E>(list);
		}
		E result = initVal;
		for (final E e : snapshot)
			result = f.apply(result, e);
		return result;
	}
	
	public static void main(String[] args) {
		
	}
	
}
