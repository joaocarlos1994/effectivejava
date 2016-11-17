package br.com.effectivejava.item26;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Nao sera possivel criar a seguiente matriz generica pois sao tipos
 * reificavel, como E:
 * 					private E[] elements;
 * 					elements = new E[DEFAULT_INITIAL_CAPACITY];
 * 
 * A primeira solucao para burla diretamente a proibicao de criacao de
 * matrizes genericas: crie uma matriz de tipos Object e converta-a
 * para o tipo de matriz generica, assim o compilador emitira um aviso:
 * 
 * 
 * 
 * */
public class PilhaGenerica<E> {
	
	private E[] elements;
	private int size = 0;
	private final static int DEFAULT_INITIAL_CAPACITY = 16;
	
	public PilhaGenerica(){
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
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
	
	
	private void ensureCapacity(){
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	
}
