package dao.instance;

import model.UserModelBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by arthurveys on 27/05/15.
 */
public class UserDao {
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public UserDao(String DB_HOST, String DB_PORT, String DB_NAME, String DB_USER, String
			DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}

	public void addUser(UserModelBean user) {
		// Création de la requête
		java.sql.Statement query;
		try {
			/* create connection */
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			//TODO A l’image de DB.java créer une réquète permettant d’ajout l’utilisateur à la base de données
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<UserModelBean> getAllUser() {
		//return value
		ArrayList<UserModelBean> userList = new ArrayList<UserModelBean>();
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			//TODO A l’image de DB.java créer une réquète permettant de récupérer l’ensemble des utilisateurs contenu dans la base et de les placer dans unliste
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
}