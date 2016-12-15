package br.com.effectivejava.item29;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

/**
 * O objeto Class desempenhara o papel da chave parametrizada. O
 * tipo de um literal de classe nao e mai simplesmente Class, mas
 * Class<T>. Por exemplo. String.class e de tipo Class<String> e
 * Integer.class e de tipo Class<Integer>. Quando um literal de 
 * classe e passado entre metodos para comunicar informacoes de
 * tipo tanto de tempo de compilacao quanto de tempo execucao, e
 * chamado de token de tipo.
 * */
public class Favorites {
	
	private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();
	
	public <T> void putFavorite(final Class<T> type, final T instance) {
		if (type == null)
			throw new NullPointerException("Type is null");
		favorites.put(type, instance);
	}
	
	public <T> T getFavorite(final Class<T> type) {
		return type.cast(favorites.get(type));
	}
	
	/**
	 * Faz o uso asSubclass na conversao segura para um token de tipo restrito
	 * */
	static Annotation getAnnotation(final AnnotatedElement element,
									final String annotationTypeName) {
		Class<?> annotationType = null; // Token de tipo irrestrito
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex);
		}
		return element.getAnnotation(
				annotationType.asSubclass(Annotation.class));
	}
	
}
