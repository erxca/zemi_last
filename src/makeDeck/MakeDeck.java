package makeDeck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
			SongData data = new SongData(csvdata[0], csvdata[1]);
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

		public SongData(String title, String type) {
			this.title = title;
			this.type = Integer.parseInt(type);
		}
	}

	public static List<AtkData> datainput() {
		List<String[]> atk_data = input(ATK);
		List<AtkData> adatalist = new ArrayList<AtkData>();

		for (String[] inputdata : atk_data) {
			AtkData data = new AtkData(inputdata[0], inputdata[1], inputdata[2]);
			adatalist.add(data);
			System.out.println("ATK　: " + data.atk);
			System.out.println("type　: " + data.type);
			System.out.println("rarity : " + data.rarity);
			System.out.println();
		}
		return adatalist;
	}

	static class AtkData {
		int atk;
		int type;
		String rarity;

		public AtkData(String atk, String type, String rarity) {
			this.atk = Integer.parseInt(atk);
			this.type = Integer.parseInt(type);
			this.rarity = rarity;
		}

		public AtkData(int atk, int type, String rarity) {
			this.atk = atk;
			this.type = type;
			this.rarity = rarity;
		}
	}

	public static void calc(String[] args) throws IOException {
		List<AtkData> atkdata = datainput();
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		List<AtkData> vocalist = new ArrayList<AtkData>();
		List<AtkData> player = new ArrayList<AtkData>();
		List<AtkData> vardol = new ArrayList<AtkData>();
		List<AtkData> dancer = new ArrayList<AtkData>();
		List<AtkData> model = new ArrayList<AtkData>();

		System.out.println("Please enter the song type.");
		String str = br.readLine();
		int inputType = Integer.parseInt(str);

		System.out.println("初期データ");
		for (AtkData data : atkdata) {
			System.out.print(data.atk);
			System.out.println(" " + data.type);
		}

		for (AtkData data : atkdata) {
			if (data.type == inputType) {
				atkdata.set(atkdata.indexOf(data), new AtkData(
						(int) (data.atk * 1.4), data.type, data.rarity));
				// if (data.rarity.equals("PS")) {
				// atkdata.set(atkdata.indexOf(data), new AtkData(
				// (int) (data.atk * 1.11), data.type, data.rarity));
				// } else if (data.rarity.equals("P")) {
				// atkdata.set(atkdata.indexOf(data), new AtkData(
				// (int) (data.atk * 1.1), data.type, data.rarity));
				// } else if (data.rarity.equals("GS")) {
				// atkdata.set(atkdata.indexOf(data), new AtkData(
				// (int) (data.atk * 1.08), data.type, data.rarity));
				// } else if (data.rarity.equals("G")) {
				// atkdata.set(atkdata.indexOf(data), new AtkData(
				// (int) (data.atk * 1.07), data.type, data.rarity));
				// } else if (data.rarity.equals("SS")) {
				// atkdata.set(atkdata.indexOf(data), new AtkData(
				// (int) (data.atk * 1.05), data.type, data.rarity));
				// } else if (data.rarity.equals("S")) {
				// atkdata.set(atkdata.indexOf(data), new AtkData(
				// (int) (data.atk * 1.04), data.type, data.rarity));
				// }
			}
		}

		Collections.sort(atkdata, new Comparator<AtkData>() {
			@Override
			public int compare(AtkData o1, AtkData o2) {
				return o2.atk - o1.atk;
			}
		});

		System.out.println("\nソート済みデータ");
		for (AtkData data : atkdata) {
			switch (data.type) {
			case 1:
				vocalist.add(data);
				break;
			case 2:
				player.add(data);
				break;
			case 3:
				vardol.add(data);
				break;
			case 4:
				dancer.add(data);
				break;
			case 5:
				model.add(data);
				break;
			}
			System.out.print(data.atk);
			System.out.println(" " + data.type);
		}

		Print(vocalist);
		Print(player);
		Print(vardol);
		Print(dancer);
		Print(model);

	}

	public static void Print(List<AtkData> list) {
		System.out.println(" ");
		for (AtkData data : list) {
			System.out.print(data.atk);
			System.out.println(" " + data.type);
		}
	}

	public static int Total(List<AtkData> list1, List<AtkData> list2) {
		int total1 = list1.get(0).atk + list1.get(1).atk + list1.get(2).atk;
		int total2 = list2.get(0).atk + list2.get(1).atk + list2.get(2).atk;
		int comp = total1 - total2;

		return comp;
	}

	public static void Sorting(List<AtkData> list) {
		for (int i = 0; i < 3; i++) {
			if (list.get(i).rarity.equals("PS")) {
				
			}
		}
	}
}
