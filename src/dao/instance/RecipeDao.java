package dao.instance;

import model.RecipeModelBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Paul on 27/05/2015.
 */
public class RecipeDao{

    private Connection connection;
    private String dB_HOST;
    private String dB_PORT;
    private String dB_NAME;
    private String dB_USER;
    private String dB_PWD;

    public RecipeDao(String dB_HOST, String dB_PORT, String dB_NAME, String dB_USER, String dB_PWD) {
        this.dB_HOST = dB_HOST;
        this.dB_PORT = dB_PORT;
        this.dB_NAME = dB_NAME;
        this.dB_USER = dB_USER;
        this.dB_PWD = dB_PWD;
	    try {
		    this.connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
	    } catch (SQLException e) {
		    e.printStackTrace();
	    }
    }

    public ArrayList<RecipeModelBean> getAllRecipes() {
	    ArrayList<RecipeModelBean> listResult=null;
	    try {
		    String sql = "select * from recette;";

		    Statement query = connection.createStatement();
		    ResultSet result =  query.executeQuery(sql);
		    System.out.println(result);
		    listResult=new ArrayList<>();
		    do {
			    listResult.add(new RecipeModelBean(result.getString("titre"),result.getString("description"),result.getString("type"),
					    result.getInt("note"),result.getTime("temps"),result.getInt("personnes"),result.getString("image")));
		    }while (result.next());
		    if(listResult.isEmpty())
			    listResult=null;
	    } catch (SQLException e) {
		    e.printStackTrace();
	    }
	    if (listResult != null) {
		    System.out.println( "retour de la liste des recettes : "+listResult.toString());
	    }
	    else
		    System.out.println("Liste nulle !");
	    return listResult;
    }
	public ArrayList<RecipeModelBean> getFilteredRecipe(){
		//TODO
		return null;
	}
}
