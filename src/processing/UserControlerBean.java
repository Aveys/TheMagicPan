package processing;

/**
 * Created by Paul on 27/05/2015.
 */

import dao.fabric.DaoFabric;
import dao.instance.UserDao;
import model.UserModelBean;
import model.UserSubmissionModelBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.print.attribute.standard.Severity;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successful", "Welcome " + user.getSurname() + " " + user.getLastname()));
            return "";
        }
        else
        {
            //redirect the current page
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Cannot connect."));
            return "";
        }
    }

    public String checkAndAddUser(UserSubmissionModelBean userSubmitted){

        if(Pattern.compile("^[0-9]+").matcher(userSubmitted.getAge()).matches() &&
                Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$").matcher(userSubmitted.getMail()).matches() &&
                Pattern.compile("^[A-Za-z]+").matcher(userSubmitted.getPwd()).matches() &&
                Pattern.compile("^[A-Za-z]+").matcher(userSubmitted.getPwd2()).matches() &&
                Pattern.compile("^[A-Za-z]+").matcher(userSubmitted.getLastname()).matches() &&
                Pattern.compile("^[A-Za-z]+").matcher(userSubmitted.getSurname()).matches() &&
                Pattern.compile("^[A-Za-z]+").matcher(userSubmitted.getLogin()).matches() && userSubmitted.getPwd().equals(userSubmitted.getPwd2())
                )
        {

            this.userDao.addUser(new UserModelBean(userSubmitted.getLastname(), userSubmitted.getSurname(), userSubmitted.getAgeInt(), userSubmitted.getMail(), userSubmitted.getLogin(), userSubmitted.getPwd(), userSubmitted.isAdmin()));
            LoginBean lb = new LoginBean();
            lb.setLogin(userSubmitted.getLogin());
            lb.setPwd(userSubmitted.getPwd());
            this.checkUser(lb);
            return "";
        }

        return "";
    }

    public void logout()
    {
        //récupère l'espace de mémoire de JSF
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        //place l'utilisateur dans l' espace  de mémoire de JSF
        sessionMap.remove("loggedUser");
        //redirect the current page
    }
}
