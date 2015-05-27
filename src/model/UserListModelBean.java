package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;

/**
 * Created by arthurveys on 27/05/15.
 */
@ManagedBean
@RequestScoped
public class UserListModelBean extends UserModelBean{
	ArrayList<UserModelBean> list;

	public UserListModelBean() {
		list = new ArrayList<>();
	}
	public void addUser(UserModelBean umb){
		list.add(umb);
	}
	public ArrayList<UserModelBean> getList(){
		return list;
	}
}
