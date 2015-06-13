package processing;

import dao.fabric.DaoFabric;
import dao.instance.CommentDao;
import model.CommentModelBean;
import model.CommentSubmissionModelBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Paul on 27/05/2015.
 */
@ManagedBean(name = "commentControlerBean")
@RequestScoped
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

    public void addComment(CommentSubmissionModelBean subBean, int idUser, int idRecipe){
        System.out.println("#################" + subBean.toString() + "idUser : " + idUser + "idRecipe : " + idRecipe);
        commentDao.addComment(idRecipe, idUser, subBean.getTitle(), subBean.getContent(), subBean.getNote());
    }
}
