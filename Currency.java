package application;

import java.text.DecimalFormat;
/**
 * Currency - Konwersja walut.
 * @author VashRaX
 *
 */
class Currency {
	
	Currency() {} 
	

	String pound2PLN(double pound) { //funt 5,04
		return new DecimalFormat("#0.00").format(pound*Conversions.pound2zl);
	}
	
	String euro2PLN(double euro) { // euro 4,33
		return new DecimalFormat("#0.00").format(euro*Conversions.euro2zl); 
	}
}
