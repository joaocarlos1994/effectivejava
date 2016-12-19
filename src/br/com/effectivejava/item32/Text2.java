package br.com.effectivejava.item32;

import java.util.Set;

public class Text2 {
	
	public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }
	
	// Qualquer objeto Set poderia ser passado, mas e calro que EnumSet e melhor
	public void applyStyles(final Set<Style> styles) {}
	
}
