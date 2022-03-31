public class Libro {
    String isbn;
    String nombre;
    String autor;
    int precio;
    int edadMin;

    public Libro(String isbn, String nombre, String autor, int precio, int edadMin) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
        this.edadMin = edadMin;
    }

    @Override
    public String toString() {
        return isbn + ", " + nombre + ", " + autor + ", " + precio + ", " + edadMin;
    }
}
