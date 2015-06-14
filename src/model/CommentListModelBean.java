package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

/**
 * Created by Paul on 27/05/2015.
 */
@ManagedBean
@SessionScoped
public class CommentListModelBean {

    private ArrayList<CommentModelBean> commentList;
    public CommentListModelBean() {
        commentList = new ArrayList<CommentModelBean>();
    }


    public CommentListModelBean(ArrayList<CommentModelBean> commentList) {
        this.commentList = commentList;
    }

    public void addComment(CommentModelBean comment){

        this.commentList.add(comment);
    }
    public ArrayList<CommentModelBean> getCommentList() {
        return commentList;
    }

}
