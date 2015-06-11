package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by arthurveys on 27/05/15.
 */
@ManagedBean
@RequestScoped
public class RecipeListModelBean extends RecipeModelBean{
	ArrayList<RecipeModelBean> list;

	public RecipeListModelBean() {
		list = new ArrayList<>();
	}
	public void addRecipe(RecipeModelBean rmb){
		list.add(rmb);
	}
	public ArrayList<RecipeModelBean> getList(){
		return list;
	}
}
