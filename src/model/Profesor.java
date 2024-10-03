package model;

public class Profesor {
    private String codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String materia;

    public Profesor(String codigo, String nombre, String apellido, String correo, String telefono, String materia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.materia = materia;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMateria() {
        return materia;
    }
}
