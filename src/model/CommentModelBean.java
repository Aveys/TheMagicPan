package model;

/**
 * Created by Paul on 27/05/2015.
 */
public class CommentModelBean {

    private String user;
    private int note;
    private String title;
    private String content;

    public CommentModelBean() {}

    public CommentModelBean(String user, String title, String content) {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "CommentModelBean{" +
                "user='" + user + '\'' +
                ", note=" + note +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
