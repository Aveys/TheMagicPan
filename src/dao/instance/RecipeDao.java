package dao.instance;

import model.*;

import java.sql.*;
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

    public RecipeListModelBean getAllRecipes() {
	    ArrayList<RecipeModelBean> listResult=null;
	    try {
		    String sql = "select * from recette;";

		    Statement query = connection.createStatement();
		    ResultSet result =  query.executeQuery(sql);
		    listResult=new ArrayList<>();
		    while (result.next()){
			    listResult.add(new RecipeModelBean(result.getInt("id_recette"),result.getString("titre"),result.getString("description"),result.getString("type"),
					    result.getInt("note"),result.getInt("temps"),result.getInt("personnes"),result.getString("image")));
		    }
		    if(listResult.isEmpty())
			    listResult=null;
	    } catch (SQLException e) {
		    e.printStackTrace();
	    }
	    /*if (listResult != null) {
		    System.out.println( "retour de la liste des recettes : "+listResult.toString());
	    }
	    else
		    System.out.println("Liste nulle !");*/
	    return new RecipeListModelBean(listResult);
    }

	public ArrayList<RecipeModelBean> getFilteredRecipe(String title, int note, String type, int time, int nbPeople){
        ArrayList<RecipeModelBean> listResult = null;
        try {
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
            StringBuilder sql=new StringBuilder();
            sql.append("SELECT * FROM recette r WHERE 1=1 ");

            if(!title.equals("")) {sql.append("AND titre = ? ");}

            if(note > 0 ) {sql.append("AND note = ? ");}

            if(!type.equals("")) {sql.append("AND type = ? ");}

            if(time>0) {sql.append("AND temps = ? ");}

            if(nbPeople > 0) {sql.append("AND personnes = ? ");}

            System.out.println(sql.toString());

            PreparedStatement query = connection.prepareStatement(sql.toString());
            int i = 1;
            if(!title.equals("")){query.setString(i,title);i++;}

            if(note > 0 ){query.setInt(i, note);i++;}

            if(!type.equals("")){query.setString(i,type);i++;}

            if(time > 0){query.setInt(i, time);i++;}

            if(nbPeople > 0){query.setInt(i, nbPeople);i++;}

            System.out.println(query.toString());

            ResultSet result =  query.executeQuery();
            System.out.println(result);
            listResult = new ArrayList<>();
            while (result.next()) {
                listResult.add(new RecipeModelBean(result.getInt("id_recette"),result.getString("titre"),result.getString("description"),result.getString("type"),
                        result.getInt("note"),result.getInt("temps"),result.getInt("personnes"),result.getString("image")));
            }
            /*if(listResult.isEmpty())
                listResult=null;*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    public RecipeModelBean getRecipeByTitle(String title){

        RecipeModelBean recipe = new RecipeModelBean();

        try {
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
            StringBuilder sql=new StringBuilder();
            sql.append("SELECT * FROM recette WHERE titre = ? ");

            PreparedStatement query = connection.prepareStatement(sql.toString());
            query.setString(1,title);
            ResultSet result =  query.executeQuery();
            System.out.println(result);

            result.next();
            recipe.setIdRecipe(result.getInt("id_recette"));
            recipe.setTitle(result.getString("titre"));
            recipe.setDescription(result.getString("description"));
            recipe.setType(result.getString("type"));
            recipe.setNote(result.getInt("note"));
            recipe.setTime(result.getInt("temps"));
            recipe.setNbServings(result.getInt("personnes"));
            recipe.setImage(result.getString("image"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    public RecipeModelBean getRecipeById(int idRecipe){

        RecipeModelBean recipe = new RecipeModelBean();

        CommentListModelBean commentList = new CommentListModelBean();

        try {
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM recette r " +
                    "JOIN commentaire c ON r.id_recette = c.id_recette " +
                    "JOIN user u ON u.id_user = c.id_user" +
                    "WHERE c.id_recette = ? ;");
            System.out.println(sql.toString());
            PreparedStatement query = connection.prepareStatement(sql.toString());
            query.setInt(1, idRecipe);
            ResultSet result =  query.executeQuery();
            System.out.println(result);

            result.next();
            recipe.setIdRecipe(result.getInt("id_recette"));
            recipe.setTitle(result.getString("titre"));
            recipe.setDescription(result.getString("description"));
            recipe.setType(result.getString("type"));
            recipe.setNote(result.getInt("note"));
            recipe.setTime(result.getInt("temps"));
            recipe.setNbServings(result.getInt("personnes"));
            recipe.setImage(result.getString("image"));
            CommentModelBean comment = new CommentModelBean();
                comment.setTitle(result.getString("u.login"));
                comment.setContent(result.getString("c.note"));
                comment.setTitle(result.getString("c.titre"));
                comment.setContent(result.getString("contenu"));
                    commentList.addComment(comment);
            while(result.next()) {
                    CommentModelBean comment2 = new CommentModelBean();
                comment2.setTitle(result.getString("u.login"));
                comment2.setContent(result.getString("c.note"));
                comment2.setTitle(result.getString("c.titre"));
                comment2.setContent(result.getString("contenu"));
                        commentList.addComment(comment2);
            }
            recipe.setListComment(commentList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    public int delRecipe(int id){
        String DeleteQuery = "delete from recette where id_user="+id;
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

    public int updRecipe(int id, RecipeModelBean umb) {

        String updQuery = "UPDATE user SET lastname=?, surname=?, age=?, mail=?, login=?, password=?, admin=? WHERE id_user=?";
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
            res=statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
