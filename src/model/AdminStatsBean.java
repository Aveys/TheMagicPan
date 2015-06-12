package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by arthurveys on 12/06/15 for TheMagicPan.
 */
@ManagedBean
@RequestScoped
public class AdminStatsBean {
	public int cptUsers;
	public int cptRecipe;
	public int cptCom;

	public AdminStatsBean() {
	}

	public int getCptUsers() {
		return cptUsers;
	}

	public void setCptUsers(int cptUsers) {
		this.cptUsers = cptUsers;
	}

	public int getCptRecipe() {
		return cptRecipe;
	}

	public void setCptRecipe(int cptRecipe) {
		this.cptRecipe = cptRecipe;
	}

	public int getCptCom() {
		return cptCom;
	}

	public void setCptCom(int cptCom) {
		this.cptCom = cptCom;
	}

	@Override
	public String toString() {
		return "AdminStatsBean{" +
				"cptUsers=" + cptUsers +
				", cptRecipe=" + cptRecipe +
				", cptCom=" + cptCom +
				'}';
	}
}
