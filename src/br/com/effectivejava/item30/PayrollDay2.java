package br.com.effectivejava.item30;

/**
 * A enum <code>PayrollDay2</code> e uma enum extremamente foda,
 * pois ela transfere o codigo de horas para uma segunda enum
 * aninhada, passando assim a instancia da enum para o constructor
 * da enum PayrollDay2, assim ela delegara o calculo de pagamento
 * de hora extra para o enum estrategico, eleminando a necessidade
 * de uma instrucao switch ou  uma implementacao do metodo
 * especifica de constante em PayrollDay.
 * */
public enum PayrollDay2 {
	
	MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY),
	FRIDAY(PayType.WEEKDAY), SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);	
	
	private final PayType payType;
	
	private PayrollDay2(final PayType payType) {
		this.payType = payType;
	}
	
	double pay(final double hoursWorked, final double payRate) {
		return payType.pay(hoursWorked, payRate);
	}
	
	private enum PayType {
		WEEKDAY {
			@Override
			double overtimePay(final double hours, final double payRate) {
				return hours <= HOURS_PER_SHIFT ? 0 :
					(hours - HOURS_PER_SHIFT) * payRate / 2;
			}
		},
		WEEKEND {
			@Override
			double overtimePay(final double hours, final double payRate) {
				return hours * payRate / 2;
			}
		};
		
		private static final int HOURS_PER_SHIFT = 8;
		
		abstract double overtimePay(final double hrs, final double payRate);
		
		double pay(final double hoursWorked, final double payRate) {
			double basePay = hoursWorked * payRate;
			return basePay + overtimePay(hoursWorked, payRate);
		}
		
	}
	
}
