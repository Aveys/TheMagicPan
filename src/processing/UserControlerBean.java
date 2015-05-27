package processing;

/**
 * Created by Paul on 27/05/2015.
 */

import dao.fabric.DaoFabric;
import dao.instance.UserDao;
import model.UserModelBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.Map;

@ManagedBean
@ApplicationScoped

public class UserControlerBean {
    private UserDao userDao;
    public UserControlerBean() {
        this.userDao = DaoFabric.getInstance().createUserDao();
    }

    public String checkUser(LoginBean loginBean){
        UserModelBean user = this.userDao.checkUser(loginBean.getLogin(), loginBean.getPwd());
        if(user!=null){
        //récupère l'espace de mémoire de JSF
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        //place l'utilisateur dans l' espace  de mémoire de JSF
        sessionMap.put("loggedUser", user);
//redirect the current page
            return "userdisplay.xhtml";
        }
        else
        {
//redirect the current page
            return "userLogin.xhtml";
        }
    }

    public void checkAndAddUser(UserSubmissionModelBean userSubmitted){
    //Vérifier les propriétés de l'utilisateur
    // TODO ajout de l'utilisateur à la base de données
        this.userDao.addUser(userSubmitted);
    }
}
