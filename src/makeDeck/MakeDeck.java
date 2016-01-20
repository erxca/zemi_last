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

	public static List<SongData> csvinput() {
		List<String[]> songs_data = input(SONGS);
		List<SongData> sdatalist = new ArrayList<SongData>(); 

		for (String[] csvdata : songs_data) {
			SongData data = new SongData(csvdata[0],csvdata[1]);
			sdatalist.add(data);
			System.out.println("title　: " + data.title);
			System.out.println("type　: " + data.type);
			System.out.println();
		}
		return sdatalist;
	}
	
	static class SongData {
		String title;
		int type;
		public SongData(String title,String type) {
			this.title = title;
			this.type = Integer.parseInt(type);
		}
	}

	public static List<AtkData> datainput() {
		List<String[]> atk_data = input(ATK);
		List<AtkData> adatalist = new ArrayList<AtkData>();

		for (String[] inputdata : atk_data) {
			AtkData data = new AtkData(inputdata[0],inputdata[1]);
			adatalist.add(data);
			System.out.println("ATK　: " + data.atk);
			System.out.println("type　: " + data.type);
			System.out.println();
		}
		return adatalist;
	}
	
	static class AtkData {
		int atk;
		int type;
		public AtkData(String atk,String type) {
			this.atk = Integer.parseInt(atk);
			this.type = Integer.parseInt(type);
		}
		
	}

	public static void calc() {
		List<AtkData> atkdata = datainput();
		int songtype = 5;
		
		for(AtkData data: atkdata){
			if(data.type == songtype ){
				
			}
			System.out.println(data.atk);
		}
		
		Collections.sort(atkdata,new Comparator<AtkData>(){
			@Override
			public int compare(AtkData o1, AtkData o2) {
				return o2.atk - o1.atk;
			}
		});
		for(AtkData data: atkdata){
			System.out.println(data.atk);
		}
	}
}
