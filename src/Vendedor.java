public class Vendedor {
    String nombre;
    String rut;
    String fechaContrato;

    public Vendedor(String nombre, String rut, String fechaContrato) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaContrato = fechaContrato;
    }

    @Override
    public String toString() {
        return nombre + ", " + rut + ", " + fechaContrato;
    }
}
