package br.com.effectivejava.item25;

/**
 * Se voce tentar fazer isso com genericos, enfrentara
 * problemas do tipo que discutimos acima.
 * */
public interface Function2<T> {
	
	T apply(T arg1, T arg2);
	
}
