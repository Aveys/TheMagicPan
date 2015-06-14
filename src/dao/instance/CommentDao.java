package dao.instance;

import model.CommentAdminModelBean;
import model.CommentListModelBean;
import model.CommentModelBean;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Paul on 27/05/2015.
 */
public class CommentDao {
    private Connection connection;
    private String dB_HOST;
    private String dB_PORT;
    private String dB_NAME;
    private String dB_USER;
    private String dB_PWD;

    public CommentDao(String DB_HOST, String DB_PORT, String DB_NAME, String DB_USER, String
            DB_PWD) {
        dB_HOST = DB_HOST;
        dB_PORT = DB_PORT;
        dB_NAME = DB_NAME;
        dB_USER = DB_USER;
        dB_PWD = DB_PWD;
    }

    public void addComment(int idRecipe, int idUser, String titre, String contenu, int note){

        try {
			/* create connection*/
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO commentaire (id_user,id_recette,titre,contenu,note) " +
                    "VALUES (?,?,?,?,?)" );
            PreparedStatement query = connection.prepareStatement(sql.toString());
            query.setInt(1, idUser);
            query.setInt(2, idRecipe);
            query.setString(3, titre);
            query.setString(4, contenu);
            query.setInt(5, note);
            query.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<CommentAdminModelBean> getAllComments() {
        ArrayList<CommentAdminModelBean> listComment = new ArrayList<>();
        String query= "SELECT c.id_commentaire,c.titre,c.contenu,c.note,r.titre as \"recipeName\",u.login from commentaire c join recette r on c.id_recette=r.id_recette join user u on c.id_user=u.id_user;";
        CommentAdminModelBean com ;
        try {
            // create connection
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                com= new CommentAdminModelBean(rs.getInt("note"),rs.getString("titre"),rs.getString("contenu"),rs.getString("login"),rs.getString("recipeName"));
                com.setIdCommentaire(rs.getInt("id_commentaire"));
                listComment.add(com);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listComment;
    }
    public int updComment(CommentAdminModelBean camb){
        String updQuery = "UPDATE commentaire SET titre=?, contenu=?, note=? WHERE id_commentaire=?";
        int res=-1;
        try {
			/* create connection */
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
                    + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
            PreparedStatement statement = connection.prepareStatement(updQuery);
            statement.setString(1,camb.getTitle());
            statement.setString(2,camb.getContent());
            statement.setInt(3, camb.getNote());
            statement.setInt(4,camb.getIdCommentaire());
            res=statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public int delComment(int id){
        String DeleteQuery = "delete from commentaire where id_commentaire="+id;
        int res=-1;
        try {
			/* create connection */
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
                    + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
            Statement statement = connection.createStatement();
            res=statement.executeUpdate(DeleteQuery);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
