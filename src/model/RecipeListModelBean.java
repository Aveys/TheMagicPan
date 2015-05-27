package model;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by arthurveys on 27/05/15.
 */
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
