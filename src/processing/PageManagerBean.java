package processing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class PageManagerBean implements Serializable {
    private String stylesheet;
    private String category;
    private String activePage;
    private String title;

    public PageManagerBean()
    {
        this.title = "The Magic Pan";

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public String setCategory(String category)
    {
        System.out.println(category);
        if(category.equals("emergency") || category.equals("recipes") || category.equals("shop"))
        {
            this.category = category;
            this.stylesheet = category + ".css";
            this.activePage = category + ".xhtml";
            return "template.xhtml";
        }else{
            return "splash.xhtml";
        }
    }

    public String getCategory()
    {
        return this.category;
    }

    public String getStylesheet() {
        return stylesheet;
    }

    public void setStylesheet(String stylesheet) {
        this.stylesheet = stylesheet;
    }

    public String getActivePage() {
        return activePage;
    }

    public void setActivePage(String activePage) {
        this.activePage = activePage;
    }
    public void setActivePageWithExtension(String activePage) {
        this.activePage = activePage+".xhtml";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
