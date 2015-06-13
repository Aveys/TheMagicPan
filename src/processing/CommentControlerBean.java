package processing;

import dao.fabric.DaoFabric;
import dao.instance.CommentDao;
import model.CommentModelBean;
import model.CommentSubmissionModelBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created by Paul on 27/05/2015.
 */
@ManagedBean(name = "commentControlerBean")
@ApplicationScoped
public class CommentControlerBean {
    private CommentDao commentDao;
    private CommentModelBean comment;

    public CommentControlerBean() {
        this.commentDao = DaoFabric.getInstance().createCommentDao();
    }

    public CommentModelBean getComment() {
        return comment;
    }

    public void setComment(CommentModelBean comment) {
        this.comment = comment;
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void addComment(CommentSubmissionModelBean subBean){
        String value = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("hidden1");
        commentDao.addComment(subBean.getIdRecipe(),subBean.getIdUser(),subBean.getTitle(), subBean.getContent(),subBean.getNote());
    }
}
