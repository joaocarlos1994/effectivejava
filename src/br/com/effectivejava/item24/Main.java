package br.com.effectivejava.item24;

import java.util.HashSet;
import java.util.Set;

/**
 * Item 24: Elimine avisos de nao verificacao.
 * 
 * Quando mais experiencia com genericos adquirir com os genericos,
 * menos avisos de conversa vera, mas nao espere que codigos recem
 * escritos que usem genericos sejam compilados sem problemas. Por
 * exemplo a declaracao no metodo main abaixo Set<String> exaltation...
 * 
 * O compilador o lembrara gentilmente o que fez de errado: warning:
 * [unchecked] unckecked conversion found: HashSet, required: 
 * Set<String>
 * 
 * Alguns avisos sao mais dificeis de eliminar. MAS ELIMINE TODOS OS
 * AVISOS DE NAO VERIFICACAO QUE PUDER, assim eliminando todos tera
 * certeza que seu codigo tem tipos consistentes
 * 
 * Se nao conseguir eliminar um aviso e puder provar que o codigo que
 * provocou tem tipo consistentes, entao (e somente entao) surprima o
 * aviso com uma anotacao @SupressWarnings("unchecked"). SE SUPRIMIR
 * AVISOS SEM ANTES PROVAR QUE O CODIGO TEM TIPOS CONSISTENTES, ESTARA
 * APENAS SE ILUDINDO COM UM FALSA NOCAO DE SEGURANCA
 * 
 * Sempre usar a anotacao SupressWarnings no menor escopo possivel.
 * Normalmente ele uma declaracao de variavel ou um metodo contrutor
 * muito curto. NUNCA USE SURPRESSWARNING EM UMA CLASSE INTEIRA.
 * 
 * Se perceber que esta usando a anotacao SupressWarnings em um metodo
 * ou construtor com mais de uma linha, talvez voce possa move-la para
 * uma declaracao de variavel local. Voce pode ter que declarar uma
 * nova variavel local, mais vale a pena. Considere esse metodo toArray,
 * que vem de ArrayList da classe:
 * 			
 * Sempre que usar uma anotcao @SupressWarnings("unchecked"), adicione um
 * comentario dizendo porque e seguro faze-lo. Isso ajudara os outros a
 * entederem o codigo, e o que e mais importante, diminuira a chances de
 * alguem mexer no seu codigo.
 * 
 * */
public class Main {

	public static void main(String[] args) {
		
		//Set<String> exaltation = new HashSet();
		Set<String> exaltation = new HashSet<String>();
		
	}

}
