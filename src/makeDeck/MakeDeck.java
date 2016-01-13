package makeDeck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MakeDeck {
	/*ボーカリスト：1　プレイヤー：2　バラドル：3　ダンサー：4　モデル：5*/
	public static void csvinput() {
		String filename = "C:\\Users\\cs13055\\Documents\\zemi\\t7s_songs.csv";
		File file = new File(filename);
		try(FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr)) {
			String line;
			ArrayList<String[]> data = new ArrayList<String[]>();
			while ((line = br.readLine()) != null) {
				String[] cols = line.split(",");
				data.add(cols);
			}

			// 読み込みデータの表示
			for (String[] csvdata : data) {
				System.out.println("title　: " + csvdata[0]);
				System.out.println("type　: " + csvdata[1]);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void datainput() {
		String filename2 = "C:\\Users\\cs13055\\Documents\\zemi\\t7s_data.csv";
		File file2 = new File(filename2);
		try(FileInputStream fis2 = new FileInputStream(file2);
				InputStreamReader isr2 = new InputStreamReader(fis2);
				BufferedReader br2 = new BufferedReader(isr2)) {
			String line;
			ArrayList<String[]> data2 = new ArrayList<String[]>();
			while ((line = br2.readLine()) != null) {
				String[] cols = line.split(",");
				data2.add(cols);
			}

			// 読み込みデータの表示
			for (String[] inputdata : data2) {
				System.out.println("ATK　: " + inputdata[0]);
				System.out.println("type　: " + inputdata[1]);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void calc() {
		
	}
}
