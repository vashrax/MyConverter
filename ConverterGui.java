package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings({ "unchecked", "rawtypes" })
class ConverterGui extends JFrame{
	
	/**
	 * Klasa reprezentująca wątek odpowiedzialny za animację.
	 * Obrazek zmienia się co 1/4 sekundy.
	 */
	
	class AnimatedIcon extends Thread{
		AnimatedIcon(){
		}
		public void run() {
				   System.out.println(this.toString());
				   while(allowAnimate){
		               try {	
		            	   lblCoinImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("coin1.png")));
		            	   sleep(250);
		            	   lblCoinImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("coin2.png")));
		            	   sleep(250);
		            	   lblCoinImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("coin3.png")));
		            	   sleep(250);
		            	   lblCoinImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("coin4.png")));
		            	   sleep(250);
		            	   synchronized(this) {
		            		   while(suspended) {
		            			   		System.out.println(this.toString() + " SUSPENDED.");
			                    		this.wait();
				                	}		            		   				            	   				          
		            		   }
		            } catch (Exception e) {
		                    e.printStackTrace();
		            }
		            		               
				}
			}			
		}
	
	/**
	 * Klasa reprezentująca wątek odpowiedzialny za zegar.
	 * Co sekundę ustala czas.
	 */

	class TimeChanger extends Thread{
		TimeChanger(){
		}
		public void run(){
        	System.out.println(this.toString());
        	while(clockSet){
        	   LocalTime localTime = LocalTime.now();
        	   DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
                lblClock.setText(localTime.format(timeFormat));
               try {
              sleep(1000);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }		
	}
	
	private static final long serialVersionUID = -6105562795450120998L;
	private JPanel contentPane;
	private JTextField textFieldValue;
	private JTextField textField_1;
	private JLabel lblValueLeft;
	private JLabel lblValueRight;
	private JLabel lblBottom;
	private JTable table;
	private String filename = "ConvertHistory.txt";
	private boolean enableHistory = true;
	private JLabel lblClock;
	private JLabel lblCoinImage;
	private JLabel lblhistory;
	private JLabel lblInform1;
	private JLabel lblInform2;
	private JLabel lblInform3;
	private JLabel lblLanguage;
	private JLabel lblBTW;
	private JButton btnConvert;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JComboBox comboBox;
	private JComboBox languageComboBox;
	private boolean clockSet = true;
	private boolean allowAnimate = true;
	private boolean suspended = false;
	private Locale pl = new Locale("pl","PL");
	private Locale en = new Locale("en","EN");
	private int locale = 0;
	private AnimatedIcon animatedIcon = new AnimatedIcon();
	private TimeChanger timeChanger = new TimeChanger();
	
	private String title = "";
	
	private String [] historyTableColumnTitles = {"","","","","","",""};
	private String[] comboBoxItems = {"","","","",""};
	
	private String gbp = "";
	private String eur = "";
	private String pln = "";
	private String surf_akr = "";
	private String surf_mk2 = "";
	private String surf_sf = "";
	private String weiPound = "";
	private String weiKg = "";
	
	private String illegalArgumentError_1 = "";
	private String illegalArgumentError_2 = "";
	private String illegalArgumentError_3 = "";
	private String ioError_1 = "";
	private String ioError_2 = "";
	private String ioError_3 = "";
	private String ioError_4 = "";
	private String badFormatError = "";
	private String numberFormatError = "";
	
	private String lblHistoryText = "";
	private String lblValueLeftText = "";
	private String lblValueRightText = "";
	private String lblInform1Text = "";
	private String lblInform2Text = "";
	private String lblInform3Text = "";		
	private String btnConvertText = "";
	private String lblLanguageText = "";
	private String[] languageComboBoxItems = {"PL","EN"};

	/**
	 * Konstruktor odowiedzialny za wizualny wygląd aplikacji.
	 */
		
	ConverterGui() {
		
		languageComboBox = new JComboBox(languageComboBoxItems);
		
		if(Locale.getDefault() == Locale.UK | Locale.getDefault() == Locale.US) {
			setTextLocalesEN();
			locale = 1;
		}else {
			setTextLocalesPL();			
			locale = 0;
		}
		
		languageComboBox.setSelectedIndex(locale);

		setType(Type.UTILITY);
		setTitle(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 37, 608, 303);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		TableModel model = new DefaultTableModel(
				null,
				historyTableColumnTitles
			);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.setEnabled(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		lblhistory = new JLabel(lblHistoryText);	
		lblhistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblhistory.setBounds(301, 11, 608, 14);
		panel.add(lblhistory);
		
		lblInform1 = new JLabel(lblInform1Text);
		lblInform1.setBounds(10, 11, 281, 14);
		panel.add(lblInform1);
		
		/**
		 * ComboBox zawiera metodę actionPerformed, zmieniającą w tym przypadku wartości etykiet GUI.
		 */
		
		
		comboBox = new JComboBox(comboBoxItems);
		comboBox.setBounds(10, 65, 281, 36);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	suspend();
		    	switch(comboBox.getSelectedIndex()) {
		    	case 0:
		    		lblValueLeft.setText(gbp);
		    		lblValueRight.setText(pln);
		    		break;
		    	case 1:
		    		lblValueLeft.setText(eur);
		    		lblValueRight.setText(pln);
		    		break;
		    	case 2:
		    		lblValueLeft.setText(surf_sf);
		    		lblValueRight.setText(surf_mk2);
		    		break;
		    	case 3:
		    		lblValueLeft.setText(surf_akr);
		    		lblValueRight.setText(surf_mk2);
		    		break;
		    	case 4:
		    		lblValueLeft.setText(weiPound);
		    		lblValueRight.setText(weiKg);
		    		break;
		    	default:
		    		break;
		    	}

		    }
		});
		panel.add(comboBox);
		
		lblLanguage = new JLabel(lblLanguageText);
		lblLanguage.setBounds(10, 300, 100, 14);
		panel.add(lblLanguage);
		
		languageComboBox.setBounds(10, 325, 100, 20);
		languageComboBox.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(languageComboBox.getSelectedIndex()) {
				case 0:
					locale = 0;
					setTextLocalesPL();
					setComponents();
					getLocale().setDefault(pl);					
					break;
				case 1:
					locale = 1;
					setTextLocalesEN();
					setComponents();
					getLocale().setDefault(en);
					break;
				default:
				}
			}
		});
		panel.add(languageComboBox);
		
		lblValueLeft = new JLabel(lblValueLeftText);
		lblValueLeft.setBounds(10, 112, 124, 14);
		panel.add(lblValueLeft);
		
		lblBTW = new JLabel("=");
		lblBTW.setHorizontalAlignment(SwingConstants.CENTER);
		lblBTW.setBounds(134, 144, 22, 14);
		panel.add(lblBTW);
		
		lblValueRight = new JLabel(lblValueRightText);
		lblValueRight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValueRight.setBounds(153, 112, 138, 14);
		panel.add(lblValueRight);		
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		textField_1.setBounds(167, 137, 124, 29);
		panel.add(textField_1);
		
		/**
		 * Na textFieldValue został narzucony "changeListener" odpowiedzialny za automatyczne przeliczanie wartości.
		 */
		
		textFieldValue = new JTextField();
		textFieldValue.setText("100");
		textFieldValue.setBounds(10, 137, 114, 29);
		textFieldValue.getDocument().addDocumentListener(new DocumentListener() {			
			@Override
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				textField_1.setText("");
				suspend();
			}
			@Override
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				textField_1.setText("");
				suspend();
			}
			@Override
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				textField_1.setText("");
				suspend();
			}						
		});
		panel.add(textFieldValue);
		textFieldValue.setColumns(10);
		
		btnConvert = new JButton();
		btnConvert.setText(btnConvertText);
		btnConvert.setBounds(130, 190, 160, 40);
		btnConvert.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
		    	convert(textField_1, comboBox, table);
		    	resume(animatedIcon);
		    }
		});
		panel.add(btnConvert);
		TitledBorder title;
		title = BorderFactory.createTitledBorder("");
		title.setTitlePosition(TitledBorder.DEFAULT_POSITION);
		
		lblClock = new JLabel();
		lblClock.setBounds(130, 240, 160, 60);
		lblClock.setText("00:00:00");
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblClock.setBorder(title);
		panel.add(lblClock);
		
		lblCoinImage = new JLabel();
		lblCoinImage.setBounds(10, 190, 100, 100);
		lblCoinImage.setText("");
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCoinImage);
				
		lblInform2 = new JLabel(lblInform2Text);
		lblInform2.setBounds(10, 26, 281, 14);
		panel.add(lblInform2);
		
		lblInform3 = new JLabel(lblInform3Text);
		lblInform3.setForeground(Color.red);
		lblInform3.setBounds(10, 40, 281, 14);
		panel.add(lblInform3);
		
		lblBottom = new JLabel("Grzegorz Ciosek - INF Niest. SEM IV");
		lblBottom.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBottom, BorderLayout.SOUTH);
			
		
		/**
		 * Tworzenie nowego pliku, jeżeli nie istnieje.
		 */
		
		FileOperations.createFile(filename);
		
		/**
		 * Wczytywanie danych z pliku do tabeli.
		 */
		
		if(!FileOperations.loadHistory(table, filename, locale)) {
			JOptionPane.showMessageDialog(null, ioError_1);
			JOptionPane.showMessageDialog(null, ioError_2);
			enableHistory = false;
			lblBottom.setText(ioError_3);
			lblBottom.setForeground(Color.red);
		}
			
		timeChanger.start();

		animatedIcon.start();
		

	}
	
	/**
	 * <h3>Metoda odpowiedzialna za działanie programu, zawierająca większą część kontroli błędów.</h3>
	 * Pobiera wartość z lewego pola tekstowego i za pomocą metody Menu ustala odpowiedni wynik, który jest wyświetlany w prawym polu tekstowym.
	 *
	 * @param textField
	 * @param comboBox
	 * @param table
	 * @throws NumberFormatException
	 */
		
	private void convert(JTextField textField, JComboBox comboBox, JTable table) throws NumberFormatException{
			try{
				if(textFieldValue.getText().isEmpty())
					throw new NullPointerException();
				Double value = Double.parseDouble(textFieldValue.getText());
				if(value < 0){
					throw new IllegalArgumentException();
				}else if(value == 0){
					JOptionPane.showMessageDialog(null, illegalArgumentError_1);				
				}else {
					textField.setText(Menu.menu(comboBox.getSelectedIndex(), value));
					if(enableHistory) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						LocalDate date = LocalDate.now();
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
						String time = LocalTime.now().format(dtf);
						double counter = getCounter(comboBox);		
						model.insertRow(0, new Object[]{lblValueLeft.getText(), lblValueRight.getText(), counter, textFieldValue.getText(), textField_1.getText(), date, time});
						FileOperations.saveHistory(table, filename);
					}
				}
			}
			catch(NumberFormatException e) {
				textField.setText(badFormatError);
				JOptionPane.showMessageDialog(null, numberFormatError);
			}catch(IOException e) {
				JOptionPane.showMessageDialog(null, ioError_1);
				JOptionPane.showMessageDialog(null, ioError_2);
				enableHistory = false;
				lblBottom.setText(ioError_3);
				lblBottom.setForeground(Color.red);
			}catch(IllegalArgumentException e) {
				textField.setText("0");
				
				if(comboBox.getSelectedIndex() == 0 || comboBox.getSelectedIndex() == 1)
					JOptionPane.showMessageDialog(null, illegalArgumentError_2);
				else
					JOptionPane.showMessageDialog(null, illegalArgumentError_3);
			}catch(NullPointerException e) {
				textField.setText(badFormatError);
					
			}
			
		}	
	
	/**
	 * Metoda zwracająca wartość przelicznika konwertera za pomocą wybranej opcji w comboBoxie.
	 * 
	 * @param comboBox
	 * @return wartość przelicznika konwertera
	 */
	
	double getCounter(JComboBox comboBox) {
		double counter = 0;
		switch(comboBox.getSelectedIndex()) {
		case 0:
			counter = Conversions.pound2zl;
			break;
		case 1:
			counter = Conversions.euro2zl;
			break;
		case 2:
			counter = Conversions.sf2mkw;
			break;
		case 3:
			counter = Conversions.akres2mkw;
			break;
		case 4:
			counter = Conversions.pound2kg;
			break;
		}
		return counter;
	}

	/**
	 * Metoda odpowiadająca za wyświetlanie aplikacji okienkowej.
	 */
	
	void showGui(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, ioError_4);
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Metoda zawieszająca wątek AnimatedIcon.
	 */
	
	void suspend() {
		suspended = true;
	}
	
	/**
	 * Metoda wznawiająca wątek AnimatedIcon
	 * @param konstruktor AnimatedIcon.
	 */
	
	void resume(Thread t) {
		suspended = false;
		synchronized(t) {
			t.notify();	
		}	
	}
	
	/**
	 * Metoda odpowiadająca za wczytywanie tekstów komponentów w języku polskim.
	 */
	
	void setTextLocalesPL() {
		
		title = PolishLanguage.title;
		historyTableColumnTitles = PolishLanguage.historyTableColumnTitles; 
		comboBoxItems = PolishLanguage.comboBoxItems;
			
		gbp = PolishLanguage.gbp;
		eur = PolishLanguage.eur;
		pln = PolishLanguage.pln;
		surf_akr = PolishLanguage.surf_akr;
		surf_mk2 = PolishLanguage.surf_mk2;
		surf_sf = PolishLanguage.surf_sf;
		weiPound = PolishLanguage.weiPound;
		weiKg = PolishLanguage.weiKg;
			
		illegalArgumentError_1 = PolishLanguage.illegalArgumentError_1;
		illegalArgumentError_2 = PolishLanguage.illegalArgumentError_2;
		illegalArgumentError_3 = PolishLanguage.illegalArgumentError_3;
		ioError_1 = PolishLanguage.ioError_1;
		ioError_2 = PolishLanguage.ioError_2;
		ioError_3 = PolishLanguage.ioError_3;
		ioError_4 = PolishLanguage.ioError_4;
		badFormatError = PolishLanguage.badFormatError;
		numberFormatError = PolishLanguage.numberFormatError;
		
		lblHistoryText = PolishLanguage.labelHistory;
		lblValueLeftText = PolishLanguage.labelValueLeft;
		lblValueRightText = PolishLanguage.labelValueRight;
		lblInform1Text = PolishLanguage.labelInform1;
		lblInform2Text = PolishLanguage.labelInform2;
		lblInform3Text = PolishLanguage.labelInform3;	
		lblLanguageText = PolishLanguage.labelLanguage;
		btnConvertText = PolishLanguage.btnConvert;				
	}
	
	/**
	 * Metoda odpowiadająca za wczytywanie tekstów komponentów w języku angielskim.
	 */
	void setTextLocalesEN() {
		
		title = EnglishLanguage.title;
		historyTableColumnTitles = EnglishLanguage.historyTableColumnTitles; 
		comboBoxItems = EnglishLanguage.comboBoxItems;
			
		gbp = EnglishLanguage.gbp;
		eur = EnglishLanguage.eur;
		pln = EnglishLanguage.pln;
		surf_akr = EnglishLanguage.surf_akr;
		surf_mk2 = EnglishLanguage.surf_mk2;
		surf_sf = EnglishLanguage.surf_sf;
		weiPound = EnglishLanguage.weiPound;
		weiKg = EnglishLanguage.weiKg;
			
		illegalArgumentError_1 = EnglishLanguage.illegalArgumentError_1;
		illegalArgumentError_2 = EnglishLanguage.illegalArgumentError_2;
		illegalArgumentError_3 = EnglishLanguage.illegalArgumentError_3;
		ioError_1 = EnglishLanguage.ioError_1;
		ioError_2 = EnglishLanguage.ioError_2;
		ioError_3 = EnglishLanguage.ioError_3;
		ioError_4 = EnglishLanguage.ioError_4;
		badFormatError = EnglishLanguage.badFormatError;
		numberFormatError = EnglishLanguage.numberFormatError;
		
		lblHistoryText = EnglishLanguage.labelHistory;
		lblValueLeftText = EnglishLanguage.labelValueLeft;
		lblValueRightText = EnglishLanguage.labelValueRight;
		lblInform1Text = EnglishLanguage.labelInform1;
		lblInform2Text = EnglishLanguage.labelInform2;
		lblInform3Text = EnglishLanguage.labelInform3;	
		lblLanguageText = EnglishLanguage.labelLanguage;
		btnConvertText = EnglishLanguage.btnConvert;
	}
	
	/**
	 * Ustawianie/resetowanie tekstów komponentów - wywoływane zwykle przy zmianie języka (locale)
	 */
	
	void setComponents() {
		
		this.setTitle(title);
		comboBox.removeAllItems();
		comboBox.addItem(comboBoxItems[0]);
		comboBox.addItem(comboBoxItems[1]);
		comboBox.addItem(comboBoxItems[2]);
		comboBox.addItem(comboBoxItems[3]);
		comboBox.addItem(comboBoxItems[4]);
		
		table.setModel(new DefaultTableModel(
				null,
				historyTableColumnTitles
			));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.setEnabled(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		FileOperations.loadHistory(table, filename, locale);
		resume(animatedIcon);
		
		lblhistory.setText(lblHistoryText);
		lblValueLeft.setText(lblValueLeftText);
		lblValueRight.setText(lblValueRightText);
		lblInform1.setText(lblInform1Text);
		lblInform2.setText(lblInform2Text);
		lblInform3.setText(lblInform3Text);
		lblLanguage.setText(lblLanguageText);
		btnConvert.setText(btnConvertText);
			
	}	
}
	
	
