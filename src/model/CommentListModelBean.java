package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 27/05/2015.
 */
@ManagedBean
@RequestScoped
public class CommentListModelBean {

    private List<CommentModelBean> commentList;
    public CommentListModelBean() {
        commentList = new ArrayList<CommentModelBean>();
    }
    public void addCommentList(CommentModelBean comment){
        this.commentList.add(comment);
    }
    public List<CommentModelBean> getCommentList() {
        return commentList;
    }

}
