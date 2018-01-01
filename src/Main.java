import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Equipment;
import model.GetEquipmentLogic;

public class Main {

	private final static String STRENGTH = "攻撃力:";
	private final static String AGILITY = "素早さ:";
	private final static String HP = "HP:";

	public static void main(String[] args) {
		// 装備品取得処理の呼び出し
		GetEquipmentLogic logic = new GetEquipmentLogic();
		List<Equipment> res = logic.excute();

		// 取得した装備品情報の表示
		printEquipments(res);
	}

	private static void printEquipments(List<Equipment> equipmentList) {
		boolean initWpFlg = true;
		boolean initAmFlg = true;
		for (Equipment equipment : equipmentList) {
			// 見出し表示
			if (initWpFlg == true) {
				if (equipment.getCategory().equals("01")) {
					System.out.println();
					System.out.println("*** 武器一覧 ***");
					initWpFlg = false;
				}
			}
			if (initAmFlg == true) {
				if (equipment.getCategory().equals("02")) {
					System.out.println();
					System.out.println("*** 防具一覧 ***");
					initAmFlg = false;
				}
			}
			// 装備情報表示
			System.out.println(equipment.getName());
			System.out.println(" " + STRENGTH + equipment.getStrength());
			System.out.println(" " + AGILITY + equipment.getAgility());
			System.out.println(" " + HP + equipment.getHp());
			System.out.println("--------------");
		}
	}
}
