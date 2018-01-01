package dao;

/**
 * データアクセスオブジェクト 例外
 */
public class DAOException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param str
	 * @param th
	 */
	public DAOException(String str, Throwable th) {
		super(str, th);
	}
}
