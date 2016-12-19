package br.com.effectivejava.item32;

/**
 * Constantes de enumercacao de campo de bits - OBSOLETO 
 * */
public class Text {
	
	private static final int STYLE_BOLD = 1 << 0; //1
	private static final int STYLE_ITALIC = 1 << 1; //2
	private static final int STYLE_UNDERLINE = 1 << 2; //4
	private static final int STYLE_STRIKETHROUGH = 1 << 3; //8
	
	public void applyStyles(final int styles) {}
	
}
