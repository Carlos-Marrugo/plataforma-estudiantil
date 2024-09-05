package model;

public class User {

    //Atributos de User
    private int idUser;
    private String name;
    private String email;
    private String password;
    private String rol;
    private String fecha;

    public User() {
    }

    public User(int idUser, String name, String password, String rol, String fecha) {
        this.idUser = 0;
        this.name = "";
        this.password = "";
        this.rol = "";
        this.fecha = "";
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
