package processing;

import dao.fabric.DaoFabric;
import dao.instance.RecipeDao;
import model.RecipeListModelBean;
import model.RecipeModelBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Map;

@ManagedBean
@ApplicationScoped
    public class RecipeControlerBean {

    private RecipeDao recipeDao;

    public RecipeControlerBean() {
        this.recipeDao = DaoFabric.getInstance().createRecipesDao();
    }

    public void loadAllRecipe(){

        ArrayList<RecipeModelBean> list = this.recipeDao.getAllRecipes();

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