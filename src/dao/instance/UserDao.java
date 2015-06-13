package dao.instance;

import model.UserListModelBean;
import model.UserModelBean;

import java.sql.*;
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
		java.sql.PreparedStatement query;
		String strQuery = "INSERT INTO user(lastname, surname, age, mail, login, password, admin) VALUES (?,?,?,?,?,?,?);";
		try {
			/* create connection */
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			query = connection.prepareStatement(strQuery);
			query.setString(1, user.getLastname());
			query.setString(2, user.getSurname());
			query.setInt(3, user.getAge());
			query.setString(4, user.getMail());
			query.setString(5, user.getLogin());
			query.setString(6, user.getPwd());
			query.setBoolean(7, user.isAdmin());

			query.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UserListModelBean getAllUser() {
		//return value
		ArrayList<UserModelBean> userList = new ArrayList<UserModelBean>();
		String sqlQuery = "Select * from user";
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			Statement query = connection.createStatement();
			ResultSet rs = query.executeQuery(sqlQuery);
			while(rs.next()){
				userList.add(new UserModelBean(rs.getInt("id_user"),rs.getString("lastname"),rs.getString("surname"),rs.getInt("age"),rs.getString("mail"),rs.getString("login"),rs.getString("password"),rs.getBoolean("admin")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new UserListModelBean(userList);
	}

	public UserModelBean checkUser(String login, String password)
	{
		UserModelBean user = null;
		String strQuery = "SELECT lastname, surname, age, mail, login, password, admin from user WHERE login = ? AND password = ?";
		java.sql.PreparedStatement query;

		try {
			/* create connection */
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			query = connection.prepareStatement(strQuery);
			query.setString(1, login);
			query.setString(2, password);

			ResultSet rs = query.executeQuery();

			if(rs.next())
			{
				user = new UserModelBean(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public int deleteUser(int id){
		String DeleteQuery = "delete from user where id_user="+id;
		int res=-1;
		try {
			/* create connection */
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			Statement statement = connection.createStatement();
			res=statement.executeUpdate(DeleteQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int updUser(int id, UserModelBean umb) {

		String updQuery = "update user SET lastname=?, surname=?, age=?, mail=?, login=?, password=?, admin=? WHERE id_user = ?";
		int res=-1;
		try {
			/* create connection */
			System.out.println("Modification avec cet objet :"+umb.toString() );
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			PreparedStatement statement = connection.prepareStatement(updQuery);
			statement.setString(1,umb.getLastname());
			statement.setString(2,umb.getSurname());
			statement.setInt(3, umb.getAge());
			statement.setString(4,umb.getMail());
			statement.setString(5,umb.getLogin());
			statement.setString(6,umb.getPwd());
			statement.setBoolean(7,umb.isAdmin());
			statement.setInt(8,id);
			System.out.println("Requête d'update : "+statement.toString());
			res=statement.executeUpdate(updQuery);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}