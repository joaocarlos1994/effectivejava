package br.com.effectivejava.item12;

public class Pessoa implements Comparable<Pessoa> {
	
	private final String name;
	private final String lastName;
	
	public Pessoa(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public int compareTo(Pessoa pessoa) {
		return name.compareTo(pessoa.getName());
	}

	@Override
	public String toString() {
		return "Pessoa [name=" + name + "]";
	}
	
	
	
}
