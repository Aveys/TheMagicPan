package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.lang.String;
import java.sql.Time;
@ManagedBean
@RequestScoped
public class RecipeModelBean {

	private int idRecipe;
	private String title;
	private String description;
	private int note;
	private String type;
	private Time time;
	private int nbPeople;
	private String image;

	public RecipeModelBean() {
	}

	public RecipeModelBean(String title, String description, String type,int note, Time time, int nbPeople, String image) {
		this.title = title;
		this.description = description;
		this.note = note;
		this.type = type;
		this.time = time;
		this.nbPeople = nbPeople;
		this.image = image;
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

	public Time getTime() {
		return time;
	}

	public int getNbPeople() {
		return nbPeople;
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

	public void setTime(Time time) {
		this.time = time;
	}

	public void setNbPeople(int nbPeople) {
		this.nbPeople = nbPeople;
	}

	public void setImage(String image) {
		this.image = image;
	}
}