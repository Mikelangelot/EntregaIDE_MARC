package Clases_MARC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Date fechaPedido;
    private String estado;
    private Cliente cliente;
    private Repartidor repartidorAsignado;
    private List<Producto> productos;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.fechaPedido = new Date();
        this.estado = "pendiente";
        this.cliente = cliente;
        this.repartidorAsignado = null;
        this.productos = new ArrayList<>();
        cliente.registrarPedido(this);
    }

    public boolean añadirProducto(Producto p) {
        if (productos.contains(p)) {
            System.out.println("El producto '" + p.getNombre() + "' ya está en el pedido.");
            return false;
        }
        productos.add(p);
        return true;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public boolean asignarRepartidor(Repartidor r) {
        if (productos.isEmpty()) {
            System.out.println("No se puede asignar repartidor si no hay productos.");
            return false;
        }
        if (r == null || !r.getEstado().equalsIgnoreCase("disponible")) {
            System.out.println("El repartidor no está disponible.");
            return false;
        }
        
        this.repartidorAsignado = r;
        this.estado = "en reparto";
        r.setEstado("ocupado");
        System.out.println("Pedido " + id + " en reparto con " + r.getNombre());
        return true;
    }

    public boolean entregarPedido() {
        if (!this.estado.equalsIgnoreCase("en reparto")) {
            System.out.println("No se puede entregar un pedido si no está en reparto.");
            return false;
        }
        
        this.estado = "entregado";
        if (this.repartidorAsignado != null) {
            this.repartidorAsignado.setEstado("disponible");
        }
        System.out.println("Pedido " + id + " entregado. Repartidor liberado.");
        return true;
    }

    public int getId() { return id; }
    public String getEstado() { return estado; }
}