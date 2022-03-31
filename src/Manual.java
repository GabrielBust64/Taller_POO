public class Manual {
    String isbn;
    String nombre;
    String autor;
    int precio;
    String tematica;

    public Manual(String isbn, String nombre, String autor, int precio, String tematica) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        return isbn + ", " + nombre + ", " + autor + ", " + precio + ", " + tematica;
    }
}
