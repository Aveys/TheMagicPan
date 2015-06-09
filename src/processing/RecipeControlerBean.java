package processing;

import dao.fabric.DaoFabric;
import dao.instance.RecipeDao;
import model.RecipeListModelBean;
import model.RecipeModelBean;
import model.RecipeRequestBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean(name = "recipeControlerBean")
@ApplicationScoped
    public class RecipeControlerBean {

    private RecipeDao recipeDao;
    private RecipeModelBean recipe;
    private ArrayList<RecipeModelBean> listRecipe;

    public RecipeControlerBean() {
        this.recipeDao = DaoFabric.getInstance().createRecipeDao();
    }

    public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public RecipeModelBean getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeModelBean recipe) {
        this.recipe = recipe;
    }

    public ArrayList<RecipeModelBean> getListRecipe() {
        return listRecipe;
    }

    public void setListRecipe(ArrayList<RecipeModelBean> listRecipe) {
        this.listRecipe = listRecipe;
    }

    public String loadAllRecipe(){
        listRecipe = this.recipeDao.getAllRecipes();

        RecipeListModelBean recipeList = new RecipeListModelBean();
        for(RecipeModelBean recipe:listRecipe){
            recipeList.addRecipe(recipe);
        }

        return "";
    }

    public String loadFilteredRecipe(RecipeRequestBean rrb){
        System.out.println(rrb.getType().equals(""));
        System.out.println(rrb);
        listRecipe = this.recipeDao.getFilteredRecipe(rrb.getTitle(), rrb.getNote(), rrb.getType(), rrb.getTime(), rrb.getNbServings());

        RecipeListModelBean recipeList = new RecipeListModelBean();
        for(RecipeModelBean recipe:listRecipe){
            System.out.println("recette ajoutée : "+recipe);
            recipeList.addRecipe(recipe);
        }
        /* récupère l'espace de mémoire de JSF
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        //place la liste de recette dans l'espace de mémoire de JSF
        sessionMap.put("recipeList" , recipeList);*/
        return "recipesList";
    }

    public String getRecipeByTitle(String title){
        recipe = this.recipeDao.getRecipeByTitle(title);
        System.out.println(recipe.toString());
        return "recipe";
    }

}