package br.com.effectivejava.item17;


/**
 * Item 17: Projete e documente para a heranca ou proiba-a.
 * 
 * Uma classe projetada para heranca deve comentar os metodos que ela chamam, assim
 * evitando nao causa tantos efeitos colaterais, ou seja, a classe deve documentar
 * seu uso exclusivo de metodos substituiveis.
 * 
 * A unica maneira de testar uma classe projetada para heranca e criar subclasses.
 * 
 * A melhor solucao para esse problema e proibir subclasses em classes que nao tenham sido
 * projetadas e documentadas para criacao segura de subclasses.
 * 
 * Você deve expor a menor quantidade de membros protegidos possivel, porque cada um representa
 * um compromemtimento com um detalhe da implementacao.
 * 
 * Obs.:Se achaar que deve permitir a heranca a partir de um classe concreta, uma abordagem
 * aceitavel e assegurar que a classe nunca chame nenhum de seus metodos substituiveis e
 * documentar esse fato. Em outras palavras, elimine totalmente o uso exclusivo que a classe
 * faz de metodos substituiveis.
 * 
 * 
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
