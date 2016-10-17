package br.com.effectivejava.item6;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
	
	/**
	 * Elimine referências de objetos obsoletas
	 * 
	 * Se uma pilha cresce e depois diminui, os objetos que foram retirados dela não
	 * serão coletados como lixo, mesmo se o programa que estiver usando a pilha não
	 * tiver mais referências deles. Isso ocorre porque a pilha mantém referência 
	 * obsoletas desses objetos
	 * 
	 * Para corrigir está obsolência basta anular as referências quando elas tornarem
	 * obsoletas no método pop: elements[size] = null.
	 * 
	 * Dica: Sempre que uma classe gerenciar sua própria memória, o programador deve ficar
	 * alerta a vazamentos de memória.
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
	
}
