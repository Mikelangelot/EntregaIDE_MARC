package Clases_MARC;

public class Repartidor extends Usuario {
    private String zonaReparto;
    private String estado;

    public Repartidor(String nombre, String email, String telefono, String zonaReparto) {
        super(nombre, email, telefono);
        this.zonaReparto = zonaReparto;
        this.estado = "disponible";
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getZonaReparto() { return zonaReparto; }
}