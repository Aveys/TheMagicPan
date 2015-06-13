package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by arthurveys on 13/06/15 for TheMagicPan.
 */
@ManagedBean
@SessionScoped
public class CommentAdminModelBean extends CommentModelBean implements Serializable{

	public String author;
	public String recetteTitle;
	public int idCommentaire;

	public CommentAdminModelBean() {
	}

	public CommentAdminModelBean(int note, String title, String content, String author, String recetteTitle) {
		super(note, title, content);
		this.author = author;
		this.recetteTitle = recetteTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRecetteTitle() {
		return recetteTitle;
	}

	public void setRecetteTitle(String recetteTitle) {
		this.recetteTitle = recetteTitle;
	}

	public int getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	@Override
	public String toString() {
		return "CommentAdminModelBean{" +
				"author='" + author + '\'' +
				", recetteTitle='" + recetteTitle + '\'' +
				", idCommentaire=" + idCommentaire +
				'}'+super.toString();
	}
}
