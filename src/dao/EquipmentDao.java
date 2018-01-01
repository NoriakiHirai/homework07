package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Equipment;

public class EquipmentDao {

	private Connection con = null; // コネクションオブジェクト
	private Statement stmt = null; // ステートメントオブジェクト
	private ConnectionManager cm = null; // コネクションマネージャー

	// Connectionの取得
	private void getConnection() throws DAOException {
		if (this.con != null) {
			return;
		}
		cm = ConnectionManager.getInstance();
		con = cm.getConnection(); // データベースへの接続の取得
	}

	// Statementの取得
	private void createStmt() throws DAOException {
		if (this.stmt != null) {
			return;
		}
		try {
			stmt = con.createStatement();
		} catch (SQLException e) { // SQLに関する例外処理
			throw new DAOException("[createStmt]異常", e);
		}
	}

	// データを取得
	public List<Equipment> selectAllEquipment() throws DAOException {
		getConnection();
		String sql = "SELECT * FROM equipment ORDER BY id, category";
		ResultSet rs = null;
		
		List<Equipment> eqList = new ArrayList<>();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			rs = pstmt.executeQuery(sql);
		// 取得した情報から装備品インスタンスを作成する。
		while (rs.next()) {
			Equipment equipment = new Equipment(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			// 作成したアイテムインスタンスをマップに格納する
			eqList.add(equipment);
		}
		} catch (SQLException e) {
			throw new DAOException("[EquipmentDAO#selectAllEquipment]異常", e);
		} finally {
			close();
		}
		return eqList;
	}

	private void close() throws DAOException {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DAOException("[closeStatement]異常", e);
		} finally {
			this.stmt = null;
			this.cm = null;
		}
	}
}
