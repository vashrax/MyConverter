package application;

class Menu {
		
	/**
	 * Klasa menu służąca do wywoływania odpowiedniej metody za pomocą przesłanych do niej parametrów :
	 * @param int - wybrana opcja konwertowania, zmienna sterująca menu.
	 * @param double - wartość pobrana w celu przekonwertowania
	 * <p> Za pomocą wybranej opcji, do odpowiedniej funkcji jest wysyłana zmienna double.</p>
	 * @param String - wartość zwracana przez metodę. Oraz przekazywana do ActionListenera.
	 * @see Rezultat w dolnej części okienka programu.
	 */
		
	static String menu(int option, double count) {
		Currency currency = new Currency();
		Weight weight = new Weight();
		Surface surface = new Surface();
		String result = "";
		switch(option) {
		case 0:
			result = currency.pound2PLN(count);
			break;
		case 1:
			result = currency.euro2PLN(count);
			break;
		case 2:
			result = surface.sf2m_kw(count);
			break;
		case 3:
			result = surface.akres2m_kw(count);
			break;
		case 4:
			result = weight.pound2kg(count);
			break;
		default:
			break;
		}
		return result;
	}

}
