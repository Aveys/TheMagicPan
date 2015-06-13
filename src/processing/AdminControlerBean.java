package processing;

import dao.fabric.DaoFabric;
import dao.instance.AdminDao;
import dao.instance.UserDao;
import model.AdminStatsBean;
import model.UserListModelBean;
import model.UserModelBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by arthurveys on 11/06/15 for TheMagicPan.
 */
@ManagedBean
@RequestScoped
public class AdminControlerBean implements Serializable {
	public AdminStatsBean appStats;
	public UserListModelBean listUsers;
	private AdminDao adminDAO;
	private UserDao userDao;

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

	public AdminControlerBean() {
		adminDAO = DaoFabric.getInstance().createAdminDao();
		userDao = DaoFabric.getInstance().createUserDao();
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
		System.out.println("Suppression de l'utilisateur avec l'id  :"+id);
		userDao.deleteUser(id);
		return getAdminUserPage();
	}
	public String updUser(int id, UserModelBean umb){
		userDao.updUser(id,umb);
		return getAdminUserPage();
	}

}
