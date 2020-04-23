package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Klasa odpowiedzialna za działanie na plikach.
 * @author VashRaX
 * 
 */

class FileOperations{
	
	static void createFile(String filename) {
		File file = new File(filename);
		if (!file.exists())
			try {
				file.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Metoda wczytująca dane do tabeli - Historia konwersji. </br>
	 * Nazwa pliku pobierana przez metodę.
	 * @param table
	 * @param filename
	 */
	
	static boolean loadHistory(JTable table, String filename) {
		boolean allRight = true;
		try {	
			File file = new File(filename);
			BufferedReader fr = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String row;
			int i=0;
			String [] datas = new String [7];
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			while((row = fr.readLine()) != null) {
				datas[i] = row;
				i++;
				if (i==7) {
					i=0;
				model.addRow(new Object[] {datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[6]});
				}
			}
			fr.close();
		}catch (IOException e2) {
			allRight = false;
		}
		return allRight;
	}
	
	/**
	 * Metoda zapisująca dane z tabeli do pliku txt.</br>
	 * Nazwa pliku pobierana przez metodę.
	 * @param table
	 * @param filename
	 */
	
	static void saveHistory(JTable table, String filename) throws IOException{
			File fout = new File(filename);
			if (!fout.exists())
					FileOperations.createFile(filename);
			FileOutputStream fos = new FileOutputStream(fout);			 
			BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(fos));
				for(int i=0; i<table.getRowCount();i++) {			
					for(int j=0;j<=6;j++) {
						fw.write(table.getModel().getValueAt(i, j).toString());
						fw.newLine();
						}
				}
			fw.close();
	}
}
