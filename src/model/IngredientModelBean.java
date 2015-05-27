package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by arthurveys on 27/05/15.
 */
@ManagedBean
@RequestScoped
public class IngredientModelBean {
	int id;
	String nom;

	public IngredientModelBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "IngredientModelBean{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				'}';
	}
}
