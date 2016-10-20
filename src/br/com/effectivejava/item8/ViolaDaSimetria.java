package br.com.effectivejava.item8;

public class ViolaDaSimetria {

	public static void main(String[] args) {
		
		/**
		 * A violão da simetria ocorre no quando a classe CaseInsensitiveString
		 * sobreescreve o método equals dizendo que a igualdade lógiga não leve em 
		 * consideração letra Maíuscula e Mínusculas, pois o método equals da classe String
		 * leva em consideração essas letras.
		 * 
		 * Para resolução do problema deve ser removido a seguinte instrução:
		 * if (o instanceof String)
			return s.equalsIgnoreCase((String) o);
		 * 
		 * */
		
		CaseInsensitveString cis = new CaseInsensitveString("Polish");
		String s = "polish";
		
		System.out.println(cis.equals(s));
		System.out.println(s.equals(cis));
		
	}

}
