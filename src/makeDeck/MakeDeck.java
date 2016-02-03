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

	public static AtkData[] party = new AtkData[9];

	/* ボーカリスト：1　プレイヤー：2　バラドル：3　ダンサー：4　モデル：5 */
	public static List<String[]> Input(String filename) {
		File file = new File(filename);
		List<String[]> data = new ArrayList<String[]>();
		try (FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "SJIS");
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

	public static List<SongData> Csvinput() {
		List<String[]> songs_data = Input(SONGS);
		List<SongData> sdatalist = new ArrayList<SongData>();

		for (String[] csvdata : songs_data) {
			SongData data = new SongData(csvdata[0], csvdata[1],csvdata[2],csvdata[3],csvdata[4]);
			sdatalist.add(data);
//			System.out.println("title　: " + data.title);
//			System.out.println("type　: " + data.type);
//			System.out.println();
		}
		return sdatalist;
	}

	static class SongData {
		String title;
		int type;
		int part1;
		int part2;
		int part3;

		public SongData(String title, String type, String part1, String part2, String part3) {
			this.title = title;
			this.type = Integer.parseInt(type);
			this.part1 = Integer.parseInt(part1);
			this.part2 = Integer.parseInt(part2);
			this.part3 = Integer.parseInt(part3);
		}
	}

	public static List<AtkData> datainput() {
		List<String[]> atk_data = Input(ATK);
		List<AtkData> adatalist = new ArrayList<AtkData>();

		for (String[] inputdata : atk_data) {
			AtkData data = new AtkData(inputdata[0], inputdata[1],
					inputdata[2], inputdata[3], inputdata[4]);
			adatalist.add(data);
//			System.out.print("name : " + data.name);
//			System.out.print(" cardName : " + data.cardName);
//			System.out.print(" ATK　: " + data.atk);
//			System.out.print(" type　: " + data.type);
//			System.out.println(" rarity : " + data.rarity);
//			System.out.println();
		}
		return adatalist;
	}

	static class AtkData {
		String name;
		String cardName;
		int atk;
		int type;
		String rarity;

		public AtkData(String name, String cardName, String atk, String type,
				String rarity) {
			this.name = name;
			this.cardName = cardName;
			this.atk = Integer.parseInt(atk);
			this.type = Integer.parseInt(type);
			this.rarity = rarity;
		}

		public AtkData(String name, String cardName, int atk, int type,
				String rarity) {
			this.name = name;
			this.cardName = cardName;
			this.atk = atk;
			this.type = type;
			this.rarity = rarity;
		}
	}

//	public static void Calc(String[] args) throws IOException {
//		List<AtkData> atkdata = datainput();
//		InputStreamReader is = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(is);
//		List<AtkData> vocalist = new ArrayList<AtkData>();
//		List<AtkData> player = new ArrayList<AtkData>();
//		List<AtkData> vardol = new ArrayList<AtkData>();
//		List<AtkData> dancer = new ArrayList<AtkData>();
//		List<AtkData> model = new ArrayList<AtkData>();
//
//		System.out.println("Please enter the song type.");
//		String str = br.readLine();
//		int inputType = Integer.parseInt(str);
//
//		System.out.println("初期データ");
//		for (AtkData data : atkdata) {
//			System.out.print(data.atk);
//			System.out.println(" " + data.type);
//		}
//
//		for (AtkData data : atkdata) {
//			if (data.type == inputType) {
//				atkdata.set(atkdata.indexOf(data), new AtkData(data.name,
//						data.cardName, (int) (data.atk * 1.4), data.type,
//						data.rarity));
//			}
//		}
//
//		Collections.sort(atkdata, new Comparator<AtkData>() {
//			@Override
//			public int compare(AtkData o1, AtkData o2) {
//				return o2.atk - o1.atk;
//			}
//		});
//
//		System.out.println("\nソート済みデータ");
//		for (AtkData data : atkdata) {
//			switch (data.type) {
//			case 1:
//				vocalist.add(data);
//				break;
//			case 2:
//				player.add(data);
//				break;
//			case 3:
//				vardol.add(data);
//				break;
//			case 4:
//				dancer.add(data);
//				break;
//			case 5:
//				model.add(data);
//				break;
//			}
//			System.out.print(data.atk);
//			System.out.println(" " + data.type);
//		}
//
//		Print(vocalist);
//		Print(player);
//		Print(vardol);
//		Print(dancer);
//		Print(model);
//
//		for (int part = 3; part >= 1; part--) {
//			System.out.println("part : " + part);
//			PartySetting(vocalist, player, vardol, dancer, model, part);
//		}
//
//		int total = 0;
//		for (int i = 0; i < 9; i++) {
//			if (i == 0) {
//				System.out.println("\n1st | Total : " + (party[i].atk + party[i+1].atk + party[i+2].atk));
//			} else if (i == 3) {
//				System.out.println("\n2nd | Total : " + (party[i].atk + party[i+1].atk + party[i+2].atk));
//			} else if (i == 6) {
//				System.out.println("\n3rd | Total : " + (party[i].atk + party[i+1].atk + party[i+2].atk));
//			}
//			System.out.println("name : " + party[i].name + " cardName : " + party[i].cardName + " ATK : " + party[i].atk + " Type : "
//					+ party[i].type + " rarity : " + party[i].rarity);
//			total += party[i].atk;
//		}
//		System.out.println("Total : " + total);
//	}

	public static void Calc2(String args) throws IOException {
		List<AtkData> atkdata = datainput();
		List<SongData> songdata = Csvinput();
		List<AtkData> vocalist = new ArrayList<AtkData>();
		List<AtkData> player = new ArrayList<AtkData>();
		List<AtkData> vardol = new ArrayList<AtkData>();
		List<AtkData> dancer = new ArrayList<AtkData>();
		List<AtkData> model = new ArrayList<AtkData>();
		int inputType = 0;
		int[] part = new int[3];

//		System.out.println("Please enter the song type.");
//		String str = br.readLine();
//		int inputType = Integer.parseInt(str);

		for(SongData data: songdata){
			if(args.equals(data.title)){
				inputType = data.type;
				part[0] = data.part1;
				part[1] = data.part2;
				part[2] = data.part3;
			}
		}
		
//		System.out.println("初期データ");
//		for (AtkData data : atkdata) {
//			System.out.print(data.atk);
//			System.out.println(" " + data.type);
//		}

		for (AtkData data : atkdata) {
			if (data.type == inputType) {
				atkdata.set(atkdata.indexOf(data), new AtkData(data.name,
						data.cardName, (int) (data.atk * 1.4), data.type,
						data.rarity));
			}
		}

		Collections.sort(atkdata, new Comparator<AtkData>() {
			@Override
			public int compare(AtkData o1, AtkData o2) {
				return o2.atk - o1.atk;
			}
		});

//		System.out.println("\nソート済みデータ");
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
//			System.out.print(data.atk);
//			System.out.println(" " + data.type);
		}

//		Print(vocalist);
//		Print(player);
//		Print(vardol);
//		Print(dancer);
//		Print(model);

		for (int i = 0; i < 3; i++) {
//			System.out.println("part : " + part);
			PartySetting(vocalist, player, vardol, dancer, model, part[i]);
		}

		int total = 0;
		for (int i = 0; i < 9; i++) {
			if (i == 0) {
				System.out.println("\n1st | Total : " + (party[i].atk + party[i+1].atk + party[i+2].atk));
			} else if (i == 3) {
				System.out.println("\n2nd | Total : " + (party[i].atk + party[i+1].atk + party[i+2].atk));
			} else if (i == 6) {
				System.out.println("\n3rd | Total : " + (party[i].atk + party[i+1].atk + party[i+2].atk));
			}
			System.out.println("name : " + party[i].name + " cardName : " + party[i].cardName + " ATK : " + party[i].atk + " Type : "
					+ party[i].type + " rarity : " + party[i].rarity);
			total += party[i].atk;
		}
		System.out.println("Total : " + total);
	}
	
	public static void Print(List<AtkData> list) {
		System.out.println(" ");
		for (AtkData data : list) {
			System.out.print(data.atk);
			System.out.println(" " + data.type);
		}
	}

	public static List<AtkData> Total(List<AtkData> list1, List<AtkData> list2) {
		int total1 = 0;
		int total2 = 0;
		int l1size = list1.size();
		int l2size = list2.size();

		
		if (l1size == 0) {
			total1 = 0;
		} else if (l1size == 1) {
			total1 = list1.get(0).atk;
		} else if (l1size == 2) {
			total1 = list1.get(0).atk + list1.get(1).atk;
		} else {
			total1 = list1.get(0).atk + list1.get(1).atk + list1.get(2).atk;
		}

		if (l2size == 0) {
			total2 = 0;
		} else if (l2size == 1) {
			total2 = list2.get(0).atk;
		} else if (l2size == 2) {
			total2 = list2.get(0).atk + list2.get(1).atk;
		} else {
			total2 = list2.get(0).atk + list2.get(1).atk + list2.get(2).atk;
		}

		int comp = total1 - total2;
		return (comp >= 0) ? list1 : list2;
	}

	public static void Setting(List<AtkData> list, int part) {
		String[] rare = { "PS", "P", "GS", "G", "SS", "S" };
		double[] x = { 1.11, 1.1, 1.08, 1.07, 1.05, 1.04 };
		int num = (part - 1) * 3;

		block: for (int j = 0; j < rare.length; j++) {
			for (int i = 2; i >= 0; i--) {
				if (list.get(i).rarity.equals(rare[j])) {
					party[num] = new AtkData(list.get(i).name,
							list.get(i).cardName,
							(int) (list.get(i).atk * x[j]), list.get(i).type,
							list.get(i).rarity);
					list.remove(i);
					party[num + 1] = new AtkData(list.get(0).name,
							list.get(0).cardName,
							(int) (list.get(0).atk * x[j]), list.get(0).type,
							list.get(0).rarity);
					list.remove(0);
					party[num + 2] = new AtkData(list.get(0).name,
							list.get(0).cardName,
							(int) (list.get(0).atk * x[j]), list.get(0).type,
							list.get(0).rarity);
					list.remove(0);
					
					break block;
				}
			}
		}
	}

	public static void PartySetting(List<AtkData> vocalist,
			List<AtkData> player, List<AtkData> vardol, List<AtkData> dancer,
			List<AtkData> model, int part) {
		List<AtkData> comp;
		comp = Total(vocalist, player);
		comp = Total(comp, vardol);
		comp = Total(comp, dancer);
		comp = Total(comp, model);

		Setting(comp, part);
	}
}
