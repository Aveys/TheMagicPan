package processing;

import dao.fabric.DaoFabric;
import dao.instance.RecipeDao;
import model.*;

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

    public RecipeListModelBean loadAllRecipe(){
        listRecipe = this.recipeDao.getAllRecipes().getList();

        RecipeListModelBean recipeList = new RecipeListModelBean();
        for(RecipeModelBean recipe:listRecipe){
            recipeList.addRecipe(recipe);
        }

        return recipeList;
    }

    public String loadFilteredRecipe(RecipeRequestBean rrb) {
        listRecipe = this.recipeDao.getFilteredRecipe(rrb.getTitle(), rrb.getNote(), rrb.getType(), rrb.getTime(), rrb.getNbServings());

        RecipeListModelBean recipeList = new RecipeListModelBean();
        if (listRecipe!=null){
            for (RecipeModelBean recipe : listRecipe) {
                recipeList.addRecipe(recipe);
            }
        }
        else {
            recipeList.getList().clear();
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

        return "recipe";
    }

    public String getRecipeById(int idRecipe){
        recipe = this.recipeDao.getRecipeById(idRecipe);

        return "recipe";
    }

    public void addComment(CommentSubmissionModelBean subBean, int idUser,String username){
        CommentControlerBean commentControlerBean = new CommentControlerBean();
        commentControlerBean.addComment(subBean, idUser, this.getRecipe().getIdRecipe());
        this.getRecipe().getListComment().getCommentList().add(new CommentModelBean(username, subBean.getNote(), subBean.getTitle(), subBean.getContent()));
    }

}