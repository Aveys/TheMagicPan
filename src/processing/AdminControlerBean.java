package processing;

import dao.fabric.DaoFabric;
import dao.instance.AdminDao;
import model.AdminStatsBean;
import model.UserListModelBean;

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
	}

	public String getStats(){
		appStats = this.adminDAO.getStats();
		//System.out.println(appStats.toString());
		return "admin";
	}
	public String getAdminUserPage(){
		listUsers = DaoFabric.getInstance().createUserDao().getAllUser();
		return "adminUsers";
	}

}
