package br.com.effectivejava.item16;

import java.util.Collection;
import java.util.Set;

/**
 * A <code>InstrumentedSet</code> implementa a interface Set e tem um unico construtor
 * cujo o argumento tambem e do tipo Set. Na verdade, a classe transforma um objeto Set
 * em outro, adicionando a funcionalidade de instrumentacao.
 * 
 * */
//Classe encapsuladora - Usa a composicao em vez da heranca
public class InstrumentedSet<E> extends ForwardingSet<E> {

	private int addCount = 0;

	public InstrumentedSet(final Set<E> s) {
		super(s);
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
