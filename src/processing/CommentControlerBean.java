package processing;

import dao.fabric.DaoFabric;
import dao.instance.CommentDao;
import model.CommentListModelBean;
import model.CommentModelBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Paul on 27/05/2015.
 */
@ManagedBean
@ApplicationScoped
public class CommentControlerBean {
    private CommentDao commentDao;

    public CommentControlerBean() {
        this.commentDao = DaoFabric.getInstance().createCommentDao();
    }

    public void loadAllRecipe(){

        ArrayList<CommentModelBean> list = this.commentDao.getAllComments();

        CommentListModelBean commentList = new CommentListModelBean();
        for(CommentModelBean comment:list){
            commentList.addComment(comment);
        }
        //récupère l'espace de mémoire de JSF
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        //place la liste de recette dans l'espace de mémoire de JSF
        sessionMap.put("commentList" , commentList);
    }
}
