package processing;

import dao.fabric.DaoFabric;
import dao.instance.AdminDao;
import model.AdminStatsBean;

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
	public AdminStatsBean stats;
	private AdminDao adminDAO;


	public void setStats(AdminStatsBean stats) {
		this.stats = stats;
	}

	public AdminControlerBean() {
		adminDAO = DaoFabric.getInstance().createAdminDao();
	}

	public String getStats(){
		stats = this.adminDAO.getStats();
		System.out.println(stats.toString());
		return "admin";
	}

}
