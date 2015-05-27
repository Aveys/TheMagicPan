package model;

import java.util.ArrayList;

/**
 * Created by arthurveys on 27/05/15.
 */
public class IngredientListModelBean extends IngredientModelBean{
	private ArrayList<IngredientModelBean> list ;

	public IngredientListModelBean() {
		list = new ArrayList<>();
	}

	public ArrayList<IngredientModelBean> getList() {
		return list;
	}

}
