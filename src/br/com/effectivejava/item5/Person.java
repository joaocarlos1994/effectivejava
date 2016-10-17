package br.com.effectivejava.item5;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
	
	private final Date birthDate;
	
	public Person(Date birthDate) {
		super();
		this.birthDate = birthDate;
	}

	/*
	 * O método isBabyBommer cria desnecessariamente uma nova instância de Calendar e 
	 * TimeZone e duas de Date sempre que é chamado.
	 * */
	public boolean isBabyBommer(){
		//Unnecessary allocation of expensive object
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();
		return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
	}
	
}
