import java.util.Scanner;

public class CrearProducto {
    
    public static Scanner sc = new Scanner(System.in);
    public static void crearLibro() {
        System.out.println("Ingrese ISBN");
        String isbn = sc.next();
        System.out.println("Ingrese Nombre de Libro");
        String nombre = sc.next();
        System.out.println("Ingrese Nombre de Autor");
        String autor = sc.next();
        System.out.println("Ingrese Precio (CLP)");
        int precio = sc.nextInt();
        System.out.println("Ingrese edad minima recomendada");
        int edad = sc.nextInt();
        Libro libro = new Libro(isbn,nombre,autor,precio,edad);
        gestorArchivo.agregarLinea("archivos/libros/libros.txt", libro.toString());
    }

    public static void crearRevista() {
        System.out.println("Ingrese ISBN");
        String isbn = sc.next();
        System.out.println("Ingrese Nombre de Revista");
        String nombre = sc.next();
        System.out.println("Ingrese Nombre de Autor");
        String autor = sc.next();
        System.out.println("Ingrese Precio (CLP)");
        int precio = sc.nextInt();
        System.out.println("Ingrese Temática");
        String tema = sc.next();
        Revista revista = new Revista(isbn, nombre,autor,precio,tema);
        gestorArchivo.agregarLinea("archivos/revistas/revistas.txt", revista.toString());
    }

    public static void crearManual() {
        System.out.println("Ingrese ISBN");
        String isbn = sc.next();
        System.out.println("Ingrese Nombre de Manual");
        String nombre = sc.next();
        System.out.println("Ingrese Nombre de Autor");
        String autor = sc.next();
        System.out.println("Ingrese Precio (CLP)");
        int precio = sc.nextInt();
        System.out.println("Ingrese area de aplicación");
        String area = sc.next();
        Manual manual = new Manual(isbn,nombre,autor,precio,area);
        gestorArchivo.agregarLinea("archivos/manuales/manuales.txt", manual.toString());
    }
}
