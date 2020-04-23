package application;

import java.text.DecimalFormat;
/**
 * Weight - konwersja wagi.
 * @author VashRaX
 *
 */
class Weight {
	
	Weight() {} 
	
	String pound2kg(double poundWeight) { //1 pound = 0,454 kg ( funt )	
		return new DecimalFormat("#0.00").format(poundWeight*Conversions.pound2kg);
	}

}
