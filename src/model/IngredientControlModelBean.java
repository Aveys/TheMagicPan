package model;

import java.util.ArrayList;

/**
 * Created by arthurveys on 27/05/15.
 */
public class IngredientControlModelBean extends IngredientModelBean{
	private ArrayList<IngredientModelBean> list ;

	public IngredientControlModelBean() {
		list = new ArrayList<>();
	}

	public ArrayList<IngredientModelBean> getList() {
		return list;
	}

}
