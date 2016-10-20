package br.com.effectivejava.item8;

public final class CaseInsensitveString {
	
	private final String s;
	
	public CaseInsensitveString(final String s){
		super();
		if (s == null) throw new NullPointerException();
		this.s = s;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o instanceof CaseInsensitveString) 
			return s.equalsIgnoreCase(((CaseInsensitveString) o).s);
		if (o instanceof String)
			return s.equalsIgnoreCase((String) o);
		return false;
	}
	
	
	
}
