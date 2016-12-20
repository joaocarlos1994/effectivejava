package br.com.effectivejava.item33;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.com.effectivejava.item33.Herb.Type;

/**
 * Item 33: Use EnumMap em vez de indexacao ordinal
 * 
 * Ocosionalemente voce pode ver codigos que usam metodos
 * ordinal como <code>Herb</code> para a indexacao de uma
 * matriz. Para exemplificar suponhamos que voce tivesse
 * uma matriz de ervas representando as plantas de um
 * jardim e quisesse listar essas plantas organizados por
 * tipo (anul, perene ou bienal), assim serao construindo
 * tres conjuntos, um para cada tipo, e iterara pelo jardim,
 * inserindo cada erva no cojunto apropriado.
 * 
 * Esta tecnica existe varios problemas, matrizes nao sao
 * compativeis com os genericos, o programa requer uma 
 * conversao nao verificada e nao sera compilada
 * adequadamente. Como a matriz nao sabe o que
 * seu indice representa,  e preciso rotular a 
 * saida manualmente. Mas o problema mais serio
 * nessa tecnica e que quando voce acessar uma
 * matriz indexada por um ordinal de enumeracao,
 * tera que usar o valor int correto; os ints nao
 * nao fornecem a consistencia de tipos enums. Se
 * voce usar o valor errado, o programa fara
 * silenciosamente a coisa errada ou lancara
 * um ArrayIndexOutOfBoundsException.
 * 
 * Felizmente, ha uma maneira muito melhor de
 * obter o mesmo efeito. A matriz esta servindo
 * efetivamente como um mapeamento do enum para
 * um valor, portanto, voce tambem poderia usar
 * um objeto EnumMap.
 * 
 * O exemplo usando EnumMap e muito mais confia-
 * vel pois nao ha nenhuma conversao arriscada, 
 * nem necessidade de rotular a saida manualmente,
 * ja que as chaves do mapa sao enums que sabem
 * como converter a si proprios em strings exibi-
 * veis e nao ha possibilidade de erro no calculo
 * de indices de matriz.
 * 
 * Voce pode ver uma matriz de matrizes indexada
 * por ordinais usada para representar um 
 * mapeamento a partir de dois valores enumerados.
 * Por exemplo o <code>Phase</code> porem nao e 
 * aconselhado por usar ordinal para indexar
 * matriz de matrizes.
 * 
 * Para resolver este problema tambem podem usar
 * EnumMap, ja que cada transicao de fase e
 * indexada por um PAR de enumeracoes de fases,
 * voce se saira melhor representando o relaciona-
 * mento como um mapa de um enum (fase de origem)
 * para um mapa proveninente do segundo enum
 * (fase de destino) e dai para o resultado
 * (transicao de fases). Segue o seguinte o
 * <code>Phase2</code>.
 * 
 * Resumindo, RARAMENTE E APROPRIADO USAR ORDINAIS
 * NA INDEXACAO DE MATRIZES: EM VEZ DISSO USE
 * ENUMMAP.
 * 
 * */
public class Main {

	public static void main(String[] args) {
		
		final Herb herb1 = new Herb("ANNUAL", Type.ANNUAL);
		final Herb herb2 = new Herb("PERENNIAL", Type.PERENNIAL);
		final Herb herb3 = new Herb("BIENNIAL", Type.BIENNIAL);
		
		final Herb [] garden = {herb1, herb2, herb3};
		
		@SuppressWarnings("unchecked")
		Set<Herb>[] herbsByType = (Set<Herb>[]) new Set[Herb.Type.values().length];
		
		for (int i = 0; i < herbsByType.length; i++) {
			herbsByType[i] = new HashSet<>();
		}
		
		for (final Herb h : garden) {
			herbsByType[h.getType().ordinal()].add(h);
		} 
		
		// Exibe os resultados
		for (int i = 0; i < herbsByType.length; i++) {
			System.out.printf("%s: %s%n", Herb.Type.values()[i], herbsByType[i]);
		}
		
		//////////////////////////////////////////////////////////////////////////
		
		final Map<Herb.Type, Set<Herb>> herbsByType2 = new EnumMap<>(Herb.Type.class);
		for (final Herb.Type t : Herb.Type.values()) {
			herbsByType2.put(t, new HashSet<>());
		}
		
		for (final Herb h : garden) {
			herbsByType2.get(h.getType()).add(h);
		}
		
		
		System.out.println("\n" + herbsByType2);
		
	}

}
