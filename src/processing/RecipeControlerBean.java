package processing;

import dao.fabric.DaoFabric;
import dao.instance.RecipesDao;
import model.RecipeControlModelBean;
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

    private RecipesDao recipeDao;

    public RecipeControlerBean() {
        this.recipeDao = DaoFabric.getInstance().createRecipesDao();
    }

    public void loadAllRecipe(){

        //TODO
    }
}