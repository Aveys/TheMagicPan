package model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
@ManagedBean
@ApplicationScoped
public class RecipeModelBean {

	private int idRecipe;
	private String title;
	private String description;
	private int note;
	private String type;
	private int time;
	private int nbServings;
	private String image;
	private CommentListModelBean listComment;

	public RecipeModelBean() {
	}

	public RecipeModelBean(String title, String description, String type,int note, int time, int nbServings, String image) {
		this.title = title;
		this.description = description;
		this.note = note;
		this.type = type;
		this.time = time;
		this.nbServings = nbServings;
		this.image = image;
	}

	public RecipeModelBean(int idRecipe, String title, String description, String type,int note, int time, int nbServings, String image) {
		this.idRecipe = idRecipe;
		this.title = title;
		this.description = description;
		this.note = note;
		this.type = type;
		this.time = time;
		this.nbServings = nbServings;
		this.image = image;
	}

	public int getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(int idRecipe) {
		this.idRecipe = idRecipe;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getNote() {
		return note;
	}

	public String getType() {
		return type;
	}

	public int getTime() {
		return time;
	}

	public int getNbServings() {
		return nbServings;
	}

	public String getImage() {
		return image;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setNbServings(int nbServings) {
		this.nbServings = nbServings;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CommentListModelBean getListComment() {
		return listComment;
	}

	public void setListComment(CommentListModelBean listComment) {
		this.listComment = listComment;
	}

	@Override
	public String toString() {
		return "RecipeModelBean{" +
				"idRecipe=" + idRecipe +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", note=" + note +
				", type='" + type + '\'' +
				", time=" + time +
				", nbServings=" + nbServings +
				", image='" + image + '\'' +
				", listComment=" + listComment +
				'}';
	}
}