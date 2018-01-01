package model;

import java.sql.ResultSet;
import java.util.List;

import dao.DAOException;
import dao.EquipmentDao;

public class GetEquipmentLogic {
	
	EquipmentDao equipmentDao = new EquipmentDao();
	
	public List<Equipment> excute() {
		List<Equipment> res = null;
		// 取得処理
		try {
			res = equipmentDao.selectAllEquipment();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
