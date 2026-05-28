package Clases_MARC;

public abstract class Usuario {
    protected String nombre;
    protected String email;
    protected String telefono;

    public Usuario(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
}