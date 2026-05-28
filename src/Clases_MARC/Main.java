package Clases_MARC;

public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente("Marc", "marc@email.com", "600123");
        Repartidor r = new Repartidor("Juan", "juan@email.com", "611222", "Zona Norte");
        Producto p1 = new Producto("Burger", 9.90, "comida");

        Pedido ped = new Pedido(1, c);
        
        ped.asignarRepartidor(r);
        ped.añadirProducto(p1);
        ped.añadirProducto(p1);
        ped.asignarRepartidor(r);
        ped.entregarPedido();
    }
}