package br.com.effectivejava.item16;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Em vez de estender uma classe existente, forneca a sua classe um campo
 * privado que referencie uma instancia da classe existente. Esse projeto e
 * chamado de composicao porque a classe existente passa a ser um componente da
 * novo classe. Cada metodo de instancia da nova clase chama o metodo
 * correspondente na instancia da classe existente e retornar os resultados.
 * Cada metodo de instancia da nova classe chama o metodo correspondente na
 * instancia e retorna os resultados. Isso é chamado de encaminhamento e os
 * metodos da nova classe sao chamados de metodos de encaminhamento.
 */
public class ForwardingSet<E> implements Set<E> {

	private final Set<E> s;

	public ForwardingSet(final Set<E> s) {
		super();
		this.s = s;
	}

	@Override
	public int size() {
		return s.size();
	}

	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return s.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}

	@Override
	public Object[] toArray() {
		return s.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return s.toArray(a);
	}

	@Override
	public boolean add(E e) {
		return s.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return s.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return s.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return s.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return s.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return s.removeAll(c);
	}

	@Override
	public void clear() {
		s.clear();
	}

	@Override
	public boolean equals(Object o) {
		return s.equals(o);
	}

	@Override
	public int hashCode() {
		return s.hashCode();
	}

	@Override
	public String toString() {
		return s.toString();
	}

}
