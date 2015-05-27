package processing;

import dao.fabric.DaoFabric;
import dao.instance.IngredientDao;
import dao.instance.RecipesDao;
import model.RecipeListModelBean;
import model.RecipeModelBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by arthurveys on 27/05/15.
 */
@ManagedBean
@ApplicationScoped
public class IngredientControlerBean {
	private IngredientDao ingredientDAO;


	public IngredientControlerBean() {
		this.ingredientDAO = DaoFabric.getInstance().createIngredientDao();
	}

	public void loadAllRecipe(){

		ArrayList<RecipeModelBean> list = this.ingredientDAO.getAllIngredient();

		RecipeListModelBean recipeList = new RecipeListModelBean();
		for(RecipeModelBean recipe:list){
			recipeList.addRecipe(recipe);
		}
		//récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		//place la liste de recette dans l'espace de mémoire de JSF
		sessionMap.put("recipeList" , recipeList);
	}
}
