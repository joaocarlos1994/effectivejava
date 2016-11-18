package br.com.effectivejava.item26;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * A segunda maneira de eliminar o erro de criacao de matriz
 * generica em Stack e alterar o tipo do campo de E[] para
 * Object[] fazendo havera uma mensagem de erro diferente:
 * 
 * 					E result = elements[--size] //Unchecked cast
 * 
 * Ja que E e um tipo nao reificavel, nao ha como o compilador
 * verificar a conversao no tempo de execucao. Mais uma vez, voce
 * pode provar facilmente que a conversao nao verificada e segura.
 * 
 * */
public class PilhaGenerica2<E> {

	private Object[] elements;
	private int size = 0;
	private final static int DEFAULT_INITIAL_CAPACITY = 16;

	// A matriz elements so tera instancias de E provenientes de push (E)
	// Isso e suficiente para assegurar a consistencia de tipos, mas o
	// Tipo da matriz no tempo de execucao sera E[]; sera sempre Object[]!
	@SuppressWarnings("unchecked")
	public PilhaGenerica2(){
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(final E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	//Push requer que um elements seja do tipo E, portanto, a conversao
	//esta correta.
	@SuppressWarnings("unchecked")
	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		E result = (E) elements[--size];
		elements[size] = null;
		return result;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

}
