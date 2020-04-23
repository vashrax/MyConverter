package application;
/**
 * Klasa przechowująca zmienne językowe polskie dla programu.
 * @author VashRaX
 *
 */
class PolishLanguage {
	
	static final String title = "Program - Konwerter Jednostek Miary";

	static final String[] historyTableColumnTitles = {"Z", "NA", "Przelicznik", "Wartość", "Wynik", "Data", "Czas"};

	static final String[] comboBoxItems = {"Funty - Złotówki","Euro - Złotówki","Stopy kwadratowe - Metry kwadratowe","Akry - Metry kwadratowe","Funty - Kilogramy"};	
	
	static final String labelHistory = "Historia Konwersji";	
	static final String labelValueLeft = "Funty";
	static final String labelValueRight = "Złotówki";
	static final String labelInform1 = "Wybierz jedną z opcji konwersji.\r\n";		
	static final String labelInform2 = "Naciśnij Konwertuj w celu przeliczenia.";
	static final String labelInform3 = "Format Liczby = *XX.XX* : X = cyfra - [0-9].";
	static final String labelLanguage = "Język :";
	
	static final String btnConvert ="Konwertuj";

	static final String illegalArgumentError_1 = "Wartość 0 zawsze da wynik 0.";
	static final String numberFormatError = "Zły format liczby, podaj format zgodny z szablonem \n *XX.XX* : X = cyfra - [0-9]";
	static final String ioError_1 = "Wystąpił nieznany błąd związany z plikiem\n(jednym z nich może być brak dostępu do pliku lub katalogu)\nProgram będzie dalej działał, jednak bez zapisywania historii konwersji.";
	static final String ioError_2 = "W celu ponownego zapisu historii należy ponownie uruchomić program.";
	static final String ioError_3 = "W celu zapisu historii należy ponownie uruchomić program.";
	static final String illegalArgumentError_2 = "Program nie obsługuje wartości niedodatnich. Nie przelicza długów.";
	static final String illegalArgumentError_3 = "Program nie obsługuje wartości niedodatnich. - W fizyce jest to niemożliwe.";
	static final String badFormatError = "<--Zły format.";
	static final String ioError_4 = "Wystąpił nieznany błąd podczas uruchamiania aplikacji!.";

	static final String gbp = "Funty";
	static final String eur = "Euro";
	static final String pln = "Złotówki";
	static final String surf_akr = "Akry";
	static final String surf_mk2 = "Metry kwadratowe";
	static final String surf_sf = "Stopy kwadratowe";
	static final String weiPound = "Funty";
	static final String weiKg = "Kilogramy";

}
