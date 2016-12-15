package br.com.effectivejava.item30;

/**
 * Enum que ativa seu valor para compartilhar codigo.
 * 
 * A enum contem os dias da semana, onde calcula o 
 * salario base e a quantidade de horas trabalhada
 * neste dia.
 * */
public enum PayrollDay {
	
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
	SATURDAY, SUNDAY;
	
	private final static int HOURS_PER_SHIFT = 8;
	
	double pay(final double hoursWorked, final double payRate) {
		
		double basePay = hoursWorked * payRate;
		
		double overtimePay; // Calcula pagamento de hora extra
		switch(this) {
			case SATURDAY: case SUNDAY:
				overtimePay = hoursWorked * payRate / 2;
			default: // Fins de semana
				overtimePay = hoursWorked <= HOURS_PER_SHIFT ? 
						0 : (hoursWorked - HOURS_PER_SHIFT) * payRate / 2;
				break;
		}
		return basePay + overtimePay;
	}
}
