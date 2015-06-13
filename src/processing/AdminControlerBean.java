package processing;

import dao.fabric.DaoFabric;
import dao.instance.AdminDao;
import dao.instance.RecipeDao;
import dao.instance.UserDao;
import model.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by arthurveys on 11/06/15 for TheMagicPan.
 */
@ManagedBean
@SessionScoped
public class AdminControlerBean implements Serializable {

	public AdminStatsBean appStats;

	public UserListModelBean listUsers;
	public UserModelBean selectedUser;

	public RecipeListModelBean listRecipe;
	public RecipeModelBean selectedRecipe;

	private final AdminDao adminDAO;
	private final UserDao userDao;
	private final RecipeDao recipeDao;

	public UserModelBean getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserModelBean selectedUser) {
		this.selectedUser = selectedUser;
	}

	public AdminStatsBean getAppStats() {
		return appStats;
	}

	public void setAppStats(AdminStatsBean appStats) {
		this.appStats = appStats;
	}

	public UserListModelBean getListUsers() {
		return listUsers;
	}

	public void setListUsers(UserListModelBean listUsers) {
		this.listUsers = listUsers;
	}

	public RecipeModelBean getSelectedRecipe() {
		return selectedRecipe;
	}

	public void setSelectedRecipe(RecipeModelBean selectedRecipe) {
		this.selectedRecipe = selectedRecipe;
	}

	public RecipeListModelBean getListRecipe() {
		return listRecipe;
	}

	public void setListRecipe(RecipeListModelBean listRecipe) {
		this.listRecipe = listRecipe;
	}

	public AdminControlerBean() {
		adminDAO = DaoFabric.getInstance().createAdminDao();
		userDao = DaoFabric.getInstance().createUserDao();
		recipeDao = DaoFabric.getInstance().createRecipeDao();
	}

	public String getStats(){
		appStats = this.adminDAO.getStats();
		return "admin";
	}


	public String getAdminUserPage(){
		listUsers = userDao.getAllUser();
		return "adminUsers";
	}
	public String delUser(int id){
		//System.out.println("Suppression de l'utilisateur avec l'id  :"+id);
		userDao.deleteUser(id);
		return getAdminUserPage();
	}
	public String updUser(int id, UserModelBean umb){
		//System.out.println("ID à modifier : "+id+"\nObjet sauvegardé :"+selectedUser.toString());
		if(umb.getLastname().equals("")){
			umb.setLastname(selectedUser.getLastname());
		}
		if(umb.getSurname().equals("")){
			umb.setSurname(selectedUser.getSurname());
		}
		if(umb.getAge()==0){
			umb.setAge(selectedUser.getAge());
		}
		if(umb.getMail().equals("")){
			umb.setMail(selectedUser.getMail());
		}
		if(umb.getLogin().equals("")){
			umb.setLogin(selectedUser.getLogin());
		}
		if(umb.getPwd().equals("")){
			umb.setPwd(selectedUser.getPwd());
		}
		//System.out.println("envoi de UMB : ");
		userDao.updUser(id,umb);
		return getAdminUserPage();
	}
	public String addUser(UserModelBean umb){
		userDao.addUser(umb);
		return getAdminUserPage();
	}



	public String getAdminRecipePage(){
		listRecipe = recipeDao.getAllRecipes();
		return "adminRecipe";
	}
	public String delRecipe(int id){
		recipeDao.delRecipe(id);
		return getAdminUserPage();
	}
	public String updRecipe(int id, RecipeModelBean rmb){
		//System.out.println("ID à modifier : "+id+"\nObjet sauvegardé :"+selectedRecipe.toString());
		if(rmb.getTitle().equals(""))
			rmb.setTitle(selectedRecipe.getTitle());

		if(rmb.getDescription().equals(""))
			rmb.setDescription(selectedRecipe.getDescription());

		if(rmb.getNote()<=0)
			rmb.setNote(selectedRecipe.getNote());

		if(rmb.getType().equals(""))
			rmb.setType(selectedRecipe.getType());

		if(rmb.getTime()<=0)
			rmb.setTime(selectedRecipe.getTime());

		if (rmb.getNbServings()<=0)
			rmb.setNbServings(selectedRecipe.getNbServings());

		recipeDao.updRecipe(id, rmb);
		return getAdminRecipePage();
	}



}
