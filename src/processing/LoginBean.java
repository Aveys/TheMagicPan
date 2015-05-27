package processing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by nicolas on 27/05/15.
 */

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean implements Serializable {
    private String login;
    private String pwd;

    public LoginBean()
    {

    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
