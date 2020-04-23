package application;

import java.text.DecimalFormat;
/**
 * Surface - konwersja powierzchni.
 * @author VashRaX
 *
 */
class Surface {
	
	Surface() {} 
	
	String sf2m_kw(double sf) { // Square foot = 0,093 m2
		return new DecimalFormat("#0.00").format(sf*Conversions.sf2mkw);
	}
	
	String akres2m_kw(double akr) { //1 akr = 4046,86 m2
		return new DecimalFormat("#0.00").format(akr*Conversions.akres2mkw);
	}

}
