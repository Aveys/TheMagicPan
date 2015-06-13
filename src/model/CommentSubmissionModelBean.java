package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by Paul on 27/05/2015.
 */
@ManagedBean
@RequestScoped
public class CommentSubmissionModelBean implements Serializable{

    private int idRecipe;
    private int idUser;
    private int note;
    private String title;
    private String content;

    public CommentSubmissionModelBean() {}

    public CommentSubmissionModelBean(int idRecipe, int idUser, int note, String title, String content) {
        this.idRecipe = idRecipe;
        this.idUser = idUser;
        this.note = note;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    @Override
    public String toString() {
        return "CommentSubmissionModelBean{" +
                "idRecipe=" + idRecipe +
                ", idUser=" + idUser +
                ", note=" + note +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
