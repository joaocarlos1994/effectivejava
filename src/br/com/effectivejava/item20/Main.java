package br.com.effectivejava.item20;

/**
 * Item 20: Prefira hierarquia de classes a classes marcadas
 * 
 * Voce pode se deparar com uma classe cujas as instancias tenhan duas ou mais
 * versoes e possuam um campo marcador indicando a versao da instancia. Por
 * exemplo a <code>Figure</code> que pode representar um circulo ou retangulo.
 * 
 * Para transformar uma classe marcada em um hierarquia de classes, primeiro
 * defina uma classe abstrata contendo um metodo abstrato para cada metodo
 * da classe marcada cujo compartamento dependa do valor da marcacao. Na
 * <code>Figure</code> ha apenas um metodo assim, que e area. Essa classe
 * abstrata e a raiz da hierarquia de classes. Se houver algum metodo cujo
 * comportamento nao dependa do valor da marcacao, insira-o nessa classe. Da 
 * mesma forma, se houver algum campo de dado usado por todas versoes, inisira-o
 * nessa classe.
 * 
 * Em seguida, defina uma subclasse concreta da classe raiz para cada versao da
 * classe marcada original (CIRCLE e RECTANGLE) assim inclua em cada subclasse
 * os campos especificos de sua versao. Inclua tambem em cada subclasses a
 * implementacao apropriada de cada metodo abstrato raiz.
 * 
 * Essa hierarquia de classes corrige todas as deficiencias das classes marcadas
 * observadas. O Codigo e simples e claro, sem conter o texto padronizado e
 * encontrado no original. A implementacao recebe sua propria classe e nenhuma
 * dessas classes e sobrecarregadas com campos de dados irrelevantes. Todos campos
 * sao finais. O compilador assegura que o construtor de cada classe inicialize seus
 * campos de dados e que cada classe tenha uma implementacao para cada metodo
 * abstrato declarado na classe raiz.
 * 
 * Resumindo, raramente as classes marcadas sao apropriadas. Se ficar tentado a criar
 * uma classe com um campo de marcacao explicito, verifique se a marcacao poderia ser
 * elimininada e a classe substituida por uma hierarquia.
 * 
 */
public class Main {

	public static void main(String[] args) {

	}

}
