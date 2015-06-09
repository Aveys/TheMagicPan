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

@ManagedBean(name = "recipeControlerBean")
@ApplicationScoped
    public class RecipeControlerBean {

    private RecipeDao recipeDao;
    private ArrayList<RecipeModelBean> listRecipe;

    public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public ArrayList<RecipeModelBean> getListRecipe() {
        return listRecipe;
    }

    public void setListRecipe(ArrayList<RecipeModelBean> listRecipe) {
        this.listRecipe = listRecipe;
    }

    public RecipeControlerBean() {
        this.recipeDao = DaoFabric.getInstance().createRecipeDao();
        loadAllRecipe();
    }

    public String loadAllRecipe(){
        listRecipe = this.recipeDao.getFilteredRecipe();

        RecipeListModelBean recipeList = new RecipeListModelBean();
        for(RecipeModelBean recipe:listRecipe){
            recipeList.addRecipe(recipe);
        }
        /* récupère l'espace de mémoire de JSF
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        //place la liste de recette dans l'espace de mémoire de JSF
        sessionMap.put("recipeList" , recipeList);*/
        return "";
    }

}