import java.util.Scanner;

public class MenuPr {
    public static void mainMenu() {
        int temp;
        boolean stay = true;
        while(stay){
            System.out.println("Bienvenido, elija una opción\n1- Venta\n2- Registrar Cliente\n3- Registrar Vendedor\n4- Menú de Vendedor\n5- Salir");
            Scanner sc = new Scanner(System.in);

            temp = sc.nextInt();
            switch (temp){
                case 1:
                    venta();
                    break;
                case 2:
                    nuevoCliente();
                    break;
                case 3:
                    nuevoVendedor();
                    break;
                case 4:
                    menuVendedor();
                    break;
                case 5:
                    stay = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }

    }

    private static void menuVendedor() {
        int temp;
        boolean stay = true;
        while(stay){
            Scanner sc = new Scanner(System.in);
            System.out.println("Menú de Vendedor\n1- Agregar Inventario\n2- Generar archivos\n3- Volver");
            temp = sc.nextInt();
            switch (temp){
                case 1:
                    agregarInventario();
                    break;
                case 2:
                    generarArchivos();
                    break;
                case 3:
                    System.out.println("Volviendo...");
                    stay = false;
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }



    }

    private static void generarArchivos(){
        System.out.println("Se crearan todos los archivos necesarios desde cero, ¿Desea continuar? Y/N");
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        switch (temp){
            case "Y":
                gestorArchivo.crearArchivo("archivos/clientes.txt","");
                gestorArchivo.crearArchivo("archivos/vendedores.txt", "");
                gestorArchivo.crearArchivo("archivos/libros/libros.txt", "");
                gestorArchivo.crearArchivo("archivos/revistas/revistas.txt", "");
                gestorArchivo.crearArchivo("archivos/manuales/manuales.txt", "");
                break;
            case "N":
                System.out.println("Volviendo...");
                break;
            default:
                System.out.println("Opción inválida, volviendo...");
                break;
        }
    }

    private static void agregarInventario() {
        boolean stay = true;
        Scanner sc = new Scanner(System.in);
        int temp;
        while(stay){
            System.out.println("¿Que desea agregar?\n1- Libro\n2- Revista\n3- Manual\n4- Volver");
            temp = sc.nextInt();
            switch (temp){
                case 1:
                    CrearProducto.crearLibro();
                    break;
                case 2:
                    CrearProducto.crearRevista();
                    break;
                case 3:
                    CrearProducto.crearManual();
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    stay = false;
                    break;
                default:
                    System.out.println("Opción Inválida");
                    break;
            }
        }
    }

    private static void nuevoVendedor() {
        Scanner sc = new Scanner(System.in);
        boolean stay = true;
        while(stay){
            System.out.println("Ingrese nombre Vendedor");
            String nombre = sc.next();
            System.out.println("Ingrese RUT vendedor");
            String rut = sc.next();
            if(validarRut(rut)){
                System.out.println("Ingrese fecha de Contrato (YYYY/MM/DD)");
                String fechaCont = sc.next();
                stay = false;
                Vendedor vendedor = new Vendedor(nombre, rut, fechaCont);
                gestorArchivo.agregarLinea("archivos/vendedores.txt", vendedor.toString());
            }else{
                System.out.println("Rut invalido");
            }
        }
    }

    private static void nuevoCliente() {
        Scanner sc = new Scanner(System.in);
        boolean stay = true;
        while(stay){
            System.out.println("Ingrese nombre Cliente");
            String nombre = sc.next();
            System.out.println("Ingrese RUT Cliente");
            String rut = sc.next();
            if(validarRut(rut)){
                System.out.println("Ingrese fecha de Cumpleaños (YYYY/MM/DD)");
                String fechaCump = sc.next();
                stay = false;
                Cliente cliente = new Cliente(nombre, rut, fechaCump);
                gestorArchivo.agregarLinea("archivos/vendedores.txt", cliente.toString());
            }else{
                System.out.println("Rut invalido");
            }
        }
    }

    private static void venta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre Vendedor");
        String nomVend = sc.next();
        System.out.println("Ingrese nombre Cliente");
        String nomClient = sc.next();
        elegirVendedor(nomVend);
        elegirCliente(nomClient);
        System.out.println("Venta incompleta");
    }

    private static void elegirCliente(String nomClient) {
        String[][] clientes = separarLineas(gestorArchivo.leerArchivo("archivos/clientes.txt"));
    }

    private static void elegirVendedor(String nomVend) {
        String[][] vendedores = separarLineas(gestorArchivo.leerArchivo("archivos/vendedores.txt"));

    }

    private static String[][] separarLineas(String lineas) {
        String[][] retorno;
        char[] linChar = lineas.toCharArray();
        for (int i = 0; i < lineas.length(); i++){
            if(linChar[i] == ','){
                int j = 0;
                while(linChar[i+1] != ','){
                    j++;
                }
                char[] temp = new char[j];
                for (int k = 0; k < j; k++) {
                    temp[k] = linChar[i+k];
                }

            }
        }
        retorno = new String[][]{{"fallo"}, {"fallo2"}};
        return retorno;
    }

    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
}