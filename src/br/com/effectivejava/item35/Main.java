package br.com.effectivejava.item35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	/**
	 * Item 35: Prefira anotacoes a padroes de nomeacao.
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws Exception {

		int tests = 0;
		int passed = 0;

		@SuppressWarnings("rawtypes")
		final Class testClass = Class.forName("br.com.effectivejava.item35.Sample");
		for (final Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException e) {
					final Throwable exc = e.getCause();
					System.out.println(m + " failed " + exc);
				} catch (Exception ex) {
					System.out.println("INVALID @TEST: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);

		@SuppressWarnings("rawtypes")
		final Class testClassException = Class.forName("br.com.effectivejava.item35.Sample2");
		for (final Method m : testClassException.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ExceptionTest.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (InvocationTargetException e) {
					final Throwable exc = e.getCause();
					final Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
					int oldPassed = passed;
					for (Class<? extends Exception> excType : excTypes) {
						if (excType.isInstance(exc)) {
							passed++;
							break;
						}
					}
					
					if (passed == oldPassed) {
						System.out.printf("Test %s failed: %s, got %s%n", m, exc);
					}

					System.out.println(m + " failed " + exc);
				} catch (Exception ex) {
					System.out.println("INVALID @TEST: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}

}
