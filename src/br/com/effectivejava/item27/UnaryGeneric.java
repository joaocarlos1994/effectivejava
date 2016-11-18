package br.com.effectivejava.item27;

public class UnaryGeneric  {
	
	//Padrao de fabrica de singleton generico
	private static UnaryFunction<Object> IDENTITY_FUNCTION = 
			new UnaryFunction<Object>() {
				
				@Override
				public Object apply(Object arg) {	
					return arg;
				}
			};
	
	//IDENTITY_FUNCTION nao tem monitoracao de estado e seu parametro
	//de tipo e irrestrito, portando, e seguro compartilhar uma instancia
	//com todos os tipos.
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}
	
}
