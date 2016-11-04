package br.com.effectivejava.item18;

import java.util.Map;
/**
 * A implementacao esqueleto fornece ajuda na implementacao de classes abstratas sem impor as severas
 * restricoes que essas impoem quando servem como definicoes de tipo (implementacao). Elas seguem a 
 * nomeclatura Abstract + NOME_INTERFACE (AbstractList). Para a maioria dos implementadores de uma
 * interface, a implementacao de um esqueleto e a escolha obvia.
 * 
 * A implementacao esqueleto, ainda pode ajudar na tarefa do implementador. A classe que implementa a
 * interface pode encaminhar chamadas de metodos da interface para uma instancia de uma classe interna
 * privada que estenda a implmentacao do esqueleto, essa tecnica e conhecida como heranca multipla
 * simulada
 * 
 * 
 * Para criar um esqueleto voce deve estudar a interface e decidir que metodos sao os primitivos 
 * (abstratos) em termos de outros que podem ser implementados. Esse primitivos serao os metodos
 * abstatos de sua implementacao esqueleto. Em seguida, você deve fornecer implementacoes concretas
 * de todos os outros metodos da interface.
 * 
 * */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
	
	public abstract K getKey();
	public abstract V getValue();
	
	public V setValue(final V value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Map.Entry))
			return false;
		Map.Entry<?, ?> arg = (Map.Entry) o;
		return equals(getKey(), arg.getKey()) && equals(getValue(), arg.getValue());
	}
	
	private static boolean equals(Object o1, Object o2) {
		return o1 == null ? o2 == null : o1.equals(o2);
	}
	
	@Override
	public int hashCode() {
		return hashCode(getKey()) ^ hashCode(getValue());
	}
	
	private static int hashCode(final Object obj) {
		return obj == null ? 0 : obj.hashCode();
	}
	
}
