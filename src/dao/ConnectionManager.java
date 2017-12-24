package dao;

import java.sql.Connection;

public class ConnectionManager {

	// URL・ユーザ名・パスワードの設定
	private final static String URL = "jdbc:mysql://localhost:3306/webdb?useSSL=false";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	// コネクションオブジェクト
	private Connection connection = null;
	
	
}
