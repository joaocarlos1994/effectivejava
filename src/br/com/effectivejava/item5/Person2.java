package br.com.effectivejava.item5;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person2 {
	
	/**
	 * A <code>Person2</code> cria instâncias de Calendar, TimeZone e Date apenas uma
	 * vez quando é inicializada, em vez de criá-las sempre que isBabyBoomer é chamado.
	 * */
	
	private final Date birthDate;

	public Person2(Date birthDate) {
		super();
		this.birthDate = birthDate;
	}
	
	private static final Date BOOM_START;
	private static final Date BOOM_END;
	
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}
	
	public boolean isBabyBommer(){
		return birthDate.compareTo(BOOM_START) > 0 && birthDate.compareTo(BOOM_END) < 0;
	}
	
}
