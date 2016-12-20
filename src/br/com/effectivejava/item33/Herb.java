package br.com.effectivejava.item33;

public class Herb {
	public enum Type {ANNUAL, PERENNIAL, BIENNIAL}
	
	private final String name;
	private final Type type;
	
	public Herb(final String name, final Type type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
