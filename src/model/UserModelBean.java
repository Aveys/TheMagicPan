package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class UserModelBean implements Serializable{

    private int idUser;
    private String lastname;
    private String surname;
    private int age;
    private String mail;
    private String login;
    private String pwd;
    private boolean admin;

    public UserModelBean(String lastname, String surname, int age, String mail, String login, String pwd, boolean admin) {
        this.lastname = lastname;
        this.surname = surname;
        this.age = age;
        this.mail = mail;
        this.login = login;
        this.pwd = pwd;
        this.admin = admin;
    }
    public UserModelBean(int idUser,String lastname, String surname, int age, String mail, String login, String pwd, boolean admin) {
        this.idUser=idUser;
        this.lastname = lastname;
        this.surname = surname;
        this.age = age;
        this.mail = mail;
        this.login = login;
        this.pwd = pwd;
        this.admin = admin;
    }

	public UserModelBean() {
	}

	public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname; }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;}
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
    @Override
    public String toString() {
        return  "[SURNAME]:" + this.getSurname()+
                ",[LASTNAME]:"+this.getLastname()+
                ",[AGE]:"+this.getAge()+
                ",[LOGIN]:"+this.getLogin()+
                ",[PWD]:"+this.getPwd();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}