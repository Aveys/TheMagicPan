package model;

/**
 * Created by Paul on 27/05/2015.
 */
public class CommentModelBean {

    private String title;
    private String content;

    public CommentModelBean() {}

    public CommentModelBean(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
