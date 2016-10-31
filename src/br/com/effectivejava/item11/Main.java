package br.com.effectivejava.item11;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Stack stack = new Stack();
		Stack stc = stack.clone();
		
		System.out.println(stack);
		System.out.println(stc);
	}

}
