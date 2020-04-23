package application;
/**
 * Klasa przechowująca zmienne językowe angielskie dla programu.
 * @author VashRaX
 *
 */

class EnglishLanguage {
	
	static final String title = "Program - Measurement Unit Converter";

	static final String[] historyTableColumnTitles = {"From", "To", "Multiplier", "Value", "Result", "Date", "Time"};

	static final String[] comboBoxItems = {"Pounds - Polish Zloty","Euro - Polish Zloty","Square feets - Square meters","Akres - Square meters","Pounds - Kilograms"};
	
	static final String labelHistory = "Conversion history";	
	static final String labelValueLeft = "Pounds";
	static final String labelValueRight = "Polish Zloty";
	static final String labelInform1 = "Choose conversion option.\r\n";		
	static final String labelInform2 = "Push button convert to count.";
	static final String labelInform3 = "Number format = *XX.XX* : X = digit - [0-9].";
	static final String labelLanguage = "Language :";
	
	static final String btnConvert ="Convert";

	static final String illegalArgumentError_1 = "Value 0 always count as 0.";
	static final String numberFormatError = "Bad number format.";
	static final String ioError_1 = "Unknown file error occured.\n(It may be problem with access to directory or file.)\nProgram will continue without Conversion History.";
	static final String ioError_2 = "In case of saving history - restart program.";
	static final String ioError_3 = "In case of saving history - restart program.";
	static final String illegalArgumentError_2 = "Program doesn't working with non positiv values. Doesn't count debts";
	static final String illegalArgumentError_3 = "Program doesn't working with non positiv values. - It's just impossible.";
	static final String badFormatError = "<--Bad number format.";
	static final String ioError_4 = "Unknown error during starting occured.";

	static final String gbp = "Pounds";
	static final String eur = "Euro";
	static final String pln = "Polish Zloty";
	static final String surf_akr = "Akres";
	static final String surf_mk2 = "Square meters";
	static final String surf_sf = "Square feets";
	static final String weiPound = "Pounds";
	static final String weiKg = "Kilograms";

}
