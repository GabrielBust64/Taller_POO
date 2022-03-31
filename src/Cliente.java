public class Cliente {
    static String nombre;
    static String rut;
    static String fechaCump;

    public Cliente(String nombre, String rut, String fechaCump) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaCump = fechaCump;
    }

    @Override
    public String toString() {
        return nombre + ", " + rut + ", " + fechaCump;
    }
}
