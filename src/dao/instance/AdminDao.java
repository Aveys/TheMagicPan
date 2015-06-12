package dao.instance;

import model.AdminStatsBean;
import model.UserModelBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by arthurveys on 27/05/15.
 */
public class AdminDao {
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public AdminDao(String DB_HOST, String DB_PORT, String DB_NAME, String DB_USER, String
			DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}

	public AdminStatsBean getStats(){
		AdminStatsBean asb=null;
		String cptUserQuery = "select count(*) from user;";
		String cptComQuery = "select count(*) from commentaire;";
		String cptRecipeQuery = "select count(*) from recette;";
		try {
			asb = new AdminStatsBean();
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			ResultSet r;
			Statement state= (connection.createStatement());
			r=state.executeQuery(cptUserQuery);
			if(r.next())
				asb.setCptUsers(r.getInt(1));
			r=state.executeQuery(cptComQuery);
			if(r.next())
				asb.setCptCom(r.getInt(1));
			r=state.executeQuery(cptRecipeQuery);
			if(r.next())
				asb.setCptRecipe(r.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asb;
	}

}