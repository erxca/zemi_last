package makeDeck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MakeDeck {
	private static final String SONGS = "C:\\Users\\cs13055\\Documents\\zemi\\t7s_songs.csv";
	private static final String ATK = "C:\\Users\\cs13055\\Documents\\zemi\\t7s_data.csv";
	/* ボーカリスト：1　プレイヤー：2　バラドル：3　ダンサー：4　モデル：5 */
	public static List<String[]> input(String filename) {
		File file = new File(filename);
		List<String[]> data = new ArrayList<String[]>();
		try (FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr)) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] cols = line.split(",");
				data.add(cols);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static List<String[]> csvinput() {
		List<String[]> songs_data = input(SONGS);

		for (String[] csvdata : songs_data) {
			System.out.println("title　: " + csvdata[0]);
			System.out.println("type　: " + csvdata[1]);
			System.out.println();
		}
		return songs_data;
	}

	public static List<String[]> datainput() {
		List<String[]> atk_data = input(ATK);

		// 読み込みデータの表示
		for (String[] inputdata : atk_data) {
			System.out.println("ATK　: " + inputdata[0]);
			System.out.println("type　: " + inputdata[1]);
			System.out.println();
		}
		return atk_data;
	}

	public static void calc() {

	}
}
