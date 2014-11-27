package com.isabel.coursera.potlatch;

/**
 * Created by Isabel on 11/23/2014.
 */
public class User {

    private String id;//autogenerado
    private String username;
    private String password;
    private String email;
   // private String datebirth;
   // private String sex;
    private String imagen;

    private int touchesCount;

    public int getTouchesCount() {
        return touchesCount;
    }

    public void setTouchesCount(int touchesCount) {
        this.touchesCount = touchesCount;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  /*  public String getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(String datebirth) {
        this.datebirth = datebirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }*/
}