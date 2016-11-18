package br.com.effectivejava.item27;

/**
 * Interface que descreve uma funcao que aceita e retorna
 * algum valor de algum tipo T
 * */
public interface UnaryFunction<T> {
	T apply(final T arg);
}
