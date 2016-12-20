package br.com.effectivejava.item33;

import java.util.EnumMap;
import java.util.Map;

/**
 * 
 * */
public enum Phase2 {
	
	SOLID, LIQUID, GAS;
	
	public enum Transition {
		
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
		BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
		SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
		
		final Phase2 src;
		final Phase2 dst;
		
		private Transition(final Phase2 src, final Phase2 dst) {
			this.src = src;
			this.dst = dst;
		}
		
		// Inicializa o mapa de transicao de fases
		private static final Map<Phase2, Map<Phase2, Transition>> m =
				new EnumMap<>(Phase2.class);
		static {
			for (final Phase2 p : Phase2.values())
				m.put(p, new EnumMap<>(Phase2.class));
			for (final Transition trans : Transition.values())
				m.get(trans.src).put(trans.dst, trans);
		}
		
		public static Transition from(final Phase2 src, final Phase2 dst) {
			return m.get(src).get(dst);
		}
		
	}
}
