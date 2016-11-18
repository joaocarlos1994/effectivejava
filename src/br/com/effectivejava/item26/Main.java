package br.com.effectivejava.item26;

/**
 * 
 * Item 27: Prefira tipo genericos.
 * 
 * Ver primeiro <code>PilhaGenerica</code> e 
 * <code>PilhaGenerica2</code>
 * 
 * A segunda classe deve ser usada para manipulacao de dados.
 * Mas em uma classe generica mais realista do que Stack,
 * provalmente voce faria leituras de matriz em muitos pontos
 * do codigo, logo, selecionar a segunda solucao demandaria
 * varias conversoes para E em vez de uma unica conversao para
 * E[] e é por isso que a primeira solucao e mais usada.
 * 
 * Nem sempre e possivel ou desejavel usar listas dentro de tipos
 * genericos. A linguagem Java nao da suporte a lista nativamente,
 * portando, alguns tipos genericos, como ArrayList, devem ser 
 * implementados acima de matrizes devido ao desempenho.
 * 
 * O genericos nao tem restricoes: voce pode criar um objeto
 * Stack<Object>, c, Stack<List<String>> ou qualquer
 * outro tipo de referencia de objeto. Nao e possivel criar um 
 * objeto de tipo primitivos Stack<init> E Stack<double>, essa
 * e uma limitacao de tipos genericos.
 * 
 *  Resumindo, os tipos genericos sao mais seguros e faceis de
 *  usar do que tipos que requerem conversoes no codigo cliente.
 *  Quando projetar novos tipos, certifique-se de eles possam ser
 *  usados sem essas conversoes. Geralmente isso siginifica
 *  tornar tipos os tipos genericos.
 * 
 * */
public class Main {

	public static void main(String[] args) {
	}

}
