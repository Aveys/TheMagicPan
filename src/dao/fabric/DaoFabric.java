package dao.fabric;


import dao.instance.*;

public class DaoFabric {

		// L'utilisation du mot clé volatile permet, en Java version 5 et supérieur,
	// permet d'éviter le cas où "Singleton.instance" est non-nul,
	// mais pas encore "réellement" instancié.
	// De Java version 1.2 à 1.4, il est possible d'utiliser la classe
	// ThreadLocal.
	private static volatile DaoFabric instance = null;
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "49916";
	private static final String DB_NAME = "themagicpanbd";
	private static final String DB_USER = "root";
	private static final String DB_PWD = "";


	private DaoFabric() {
		super();
		try {
		// Chargement du Driver, puis établissement de la connexion
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode permettant de renvoyer une instance de la classe Singleton
	 *
	 * @return Retourne l'instance du singleton.
	 */
	public final static DaoFabric getInstance() {
		// Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet
		// d'éviter un appel coûteux à synchronized,
		// une fois que l'instanciation est faite.
		if (DaoFabric.instance == null) {
			// Le mot-clé synchronized sur ce bloc empêche toute instanciation
			// multiple même par différents "threads".
			synchronized (DaoFabric.class) {
				if (DaoFabric.instance == null) {
					DaoFabric.instance = new DaoFabric();
				}
			}
		}
		return DaoFabric.instance;
	}

	public UserDao createUserDao() {
		return new
				UserDao(ConfMysql.DB_HOST, ConfMysql.DB_PORT, ConfMysql.DB_NAME, ConfMysql.DB_USER, ConfMysql.DB_PWD);
	}

	public RecipeDao createRecipeDao() {
		return new
				RecipeDao(ConfMysql.DB_HOST, ConfMysql.DB_PORT, ConfMysql.DB_NAME, ConfMysql.DB_USER, ConfMysql.DB_PWD);
	}
	public IngredientDao createIngredientDao(){
		return new IngredientDao(ConfMysql.DB_HOST, ConfMysql.DB_PORT, ConfMysql.DB_NAME, ConfMysql.DB_USER, ConfMysql.DB_PWD);
	}
	public AdminDao createAdminDao(){
		return new AdminDao(ConfMysql.DB_HOST, ConfMysql.DB_PORT, ConfMysql.DB_NAME, ConfMysql.DB_USER, ConfMysql.DB_PWD);
	}
	public CommentDao createCommentDao() {
		return new
				CommentDao(ConfMysql.DB_HOST, ConfMysql.DB_PORT, ConfMysql.DB_NAME, ConfMysql.DB_USER, ConfMysql.DB_PWD);
	}
}