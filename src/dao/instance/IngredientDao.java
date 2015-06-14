package dao.instance;

import model.RecipeModelBean;
import model.UserModelBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by arthurveys on 27/05/15.
 */
public class IngredientDao {
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public IngredientDao(String dB_HOST, String dB_PORT, String dB_NAME, String dB_USER, String dB_PWD) {
		this.dB_HOST = dB_HOST;
		this.dB_PORT = dB_PORT;
		this.dB_NAME = dB_NAME;
		this.dB_USER = dB_USER;
		this.dB_PWD = dB_PWD;
	}
	public void addIngredient(RecipeModelBean recipe) {
		// Création de la requête
		java.sql.Statement query;
		try {
			/* create connection */
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<RecipeModelBean> getAllIngredient() {
		return null;
	}
}
