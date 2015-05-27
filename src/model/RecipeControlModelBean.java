package model;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by arthurveys on 27/05/15.
 */
public class RecipeControlModelBean extends RecipeModelBean{
	ArrayList<RecipeModelBean> list;

	public RecipeControlModelBean() {
		list = new ArrayList<>();
	}
	public void addRecipe(RecipeModelBean rmb){
		list.add(rmb);
	}
	public ArrayList<RecipeModelBean> getList(){
		return list;
	}
}
