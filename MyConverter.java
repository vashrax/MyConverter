/**
* <h2>Program - konwerter jednostek miary.<h2>
* @author Grzegorz Ciosek - Sem. 4 INF Niestacjonarne
* @version 1.4.1 
* <ul>
* <li>Dodano 2 wątki do obsługi zegara oraz obracającej się monety [ikony].</li>
* <li>Dodano możliwość zmiany języka na angielski i spowrotem [locale].</li>
* <li>Poprawiono błędy związane z tłumaczeniem niektórych komponentów.</li>
* </ul>
* 
* <p> Zmieniono logikę aplikacji - przeliczanie i zapis historii za pomocą przycisku "Konwertuj"</p>
*
*/

package application;

class MyConverter {

/**
 * <p>Main - wywołanie metody wyświetlenia graficznego interfejsu.</p> 
 */
	
	public static void main(String[] args) {
		ConverterGui converterGui = new ConverterGui();
		converterGui.showGui();
		}
		
}
