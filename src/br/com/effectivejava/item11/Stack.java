package br.com.effectivejava.item11;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable {
	
	/**
	 * A interface <code>Cloneable</code> � uma marker interface que anuncia que o objeto pode ser clonado.
	 * Ela determina o comportamento da implementa��o protegida do m�todo clone de Object: se uma classe
	 * implementar Cloneable, o m�todo clone de Object retornar� uma c�pia campo a campo do objeto; caso
	 * contrario lancara uma CloneNotSupportedException.
	 * 
	 * O m�todo clone funciona como um construtor; voc� deve assegurar que ele nao prejudique o objeto
	 * original e que estabeleca invariaveis apropriadamente no clone.
	 * 
	 * */
	
	private Object[] elements;
	private int size = 0;
	private final static int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack(){
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(final Object e){
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop(){
		if(size == 0)
			throw new EmptyStackException();
		Object result = elements[--size]; 
		elements[size] = null;
		return result;
	}
	
	/**
	 * Assegura espaço para pelo menos mais um elemento, dobrando subitamente a capacidade
	 * sempre que a matriz precisa crescer.
	 * */
	private void ensureCapacity(){
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	@Override
	protected Stack clone() throws CloneNotSupportedException  {
		Stack result = (Stack) super.clone();
		result.elements = elements.clone();
		return result;
	}
	
}
