package br.com.effectivejava.item16;

import java.util.Collection;
import java.util.HashSet;

/**
 * A <code>InstrumentedHashSet</code> possui um erro de API pois internamente, o
 * metodo addAll de HashSet e implementado acima do metodo add. O metodo addAll
 * de instrumentedHashSet adicionou tres a addCount e, em seguida, chamou a
 * implementacao de addAll de HashSet usando super.addAll. Esse metodo, por sua
 * vez, chamou o metodo add, como sobreposto em InstrumentedHashset, uma para
 * cada elemento. Cada uma dessas tres chamadas adicionou mais uma unidade a
 * addCount, o que gera um aumento total de seis.
 * 
 * 
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

	private static final long serialVersionUID = 1L;

	private int addCount = 0;

	public InstrumentedHashSet() {
	}

	public InstrumentedHashSet(final int initCap, final float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}

}
