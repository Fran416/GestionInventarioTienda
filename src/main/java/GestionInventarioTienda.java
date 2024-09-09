import java.awt.*;
import java.util.DoubleSummaryStatistics;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionInventarioTienda {
    public static void main(String[] args) {
        Object[][] productos = new Object[10][3];
        menu(productos);
    }


//Funciones que debian implementarse en el sistema

    public static String agregarProductos(Object[][] productos, int idProducto, String nombreProducto, int cantidad, boolean existeProducto){
        if (existeProducto){
            int fila = buscarFilaProducto(productos, idProducto);
            int cantidadActual = (int) productos[fila][2];
            productos[fila][2] = sumarNumeros(cantidadActual, cantidad);
            return "Aumento de stock exitoso";
        } else {
            for (int fila = 0 ; fila < productos.length ; fila++){
                if (productos[fila][0] == null){
                    productos[fila][0] = fila+1;
                    productos[fila][1] = nombreProducto;
                    productos[fila][2] = cantidad;
                    return "Producto agregado";
                }
            }
        }
        return "Error";
    }

    public static String restarProductos(Object[][] productos, int idProducto, int cantidad){
        int fila = buscarFilaProducto(productos, idProducto);
        int cantidadActual = (int) productos[fila][2];
        int resta = restarNumeros(cantidadActual, cantidad);
        if (resta == 0){
            productos[fila][0] = null;
            productos[fila][1] = null;
            productos[fila][2] = null;
            return "Sin Stock restante, producto eliminado del inventario";
        }  else if (resta >= 0){
            productos[fila][2] = resta;
            return "Stock actualizado con exito";
        } else {
            return "Error: No pueden haber productos en negativo";
        }
    }

    public static int consultarDisponibilidad(Object[][] productos, int idProducto){
        int fila = buscarFilaProducto(productos, idProducto);
        return (int)productos[fila][2];
    }

    public static void listarProductos(Object[][] productos){
        System.out.println(" ID | Nombre del producto | Stock disponible");
        for (int fila = 0; fila < productos.length ; fila++){
            if (productos[fila][0] != null){
                System.out.print((int)productos[fila][0]);
                System.out.print(" | ");
                System.out.print((String)productos[fila][1]);
                System.out.print(" | ");
                System.out.println((int)productos[fila][2]);
            }
        }
    }

//Funciones para el funcionamiento del menu

    public static void menu(Object[][] productos){
        boolean noSalir = true;
        while (noSalir){
            mostrarMenu();
            noSalir = accionesMenu(productos);
        }
    }

    public static void mostrarMenu(){
        System.out.println("---------------------- Menu Principal ----------------------");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Restar Stock de un Producto");
        System.out.println("3. Consultar Stock de un Producto");
        System.out.println("4. Listar Productos");
        System.out.println("5. Salir");
        System.out.print("Su seleccion: ");
    }

    public static boolean accionesMenu(Object[][] productos){
        return switch (comprobarNumeroEntero()) {
            case 1 -> {
                accionAgregarProducto(productos);
                yield true;
            }
            case 2 -> {
                accionRestarProducto(productos);
                yield true;
            }
            case 3 -> {
                accionConsultarDisponiblidad(productos);
                yield true;
            }
            case 4 -> {
                listarProductos(productos);
                yield true;
            }
            case 5 -> false;
            default -> {
                System.out.println("Opcion no valida!");
                yield true;
            }
        };
    }

//Funciones para solicitar informacion y darles los datos necesarios a las funciones que debian implementarse

    public static void accionRestarProducto(Object[][] productos){
        System.out.print("Ingrese el ID del producto: ");
        int idProducto = comprobarNumeroEntero();
        if (existeProducto(productos, idProducto)){
            System.out.print("Ingrese la cantidad que desea restar al stock del producto: ");
            int cantidadRestar = comprobarNumeroEntero();
            String message = restarProductos(productos, idProducto, cantidadRestar);
            System.out.println(message);
        } else {
            System.out.println("Error : El producto no existe");
        }
    }

    public static void accionAgregarProducto(Object[][] productos){
        System.out.print("Introduzca el id del producto (en caso que sea uno nuevo ponga 0): ");
        int idProducto = comprobarNumeroEntero();
        boolean existeProducto = existeProducto(productos, idProducto);
        System.out.print("Introduzca el nombre de su producto (en caso que no sea uno nuevo no es necesario ingresar un nombre): ");
        String nombreProducto = leerTextoTeclado();
        System.out.print("Ingrese la cantidad del producto que desea agregar: ");
        int cantidadProducto = comprobarNumeroEntero();
        String message = agregarProductos(productos, idProducto, nombreProducto, cantidadProducto, existeProducto);
        System.out.println(message);
    }

    public static void accionConsultarDisponiblidad(Object[][] productos){
        System.out.print("Ingrese el ID del producto: ");
        int idProducto = comprobarNumeroEntero();
        if (existeProducto(productos, idProducto)){
            int cantidadProducto = consultarDisponibilidad(productos, idProducto);
            System.out.print("En inventario: ");
            System.out.println(cantidadProducto);
        } else {
            System.out.println("Error : El producto no existe");
        }
    }

    public static int comprobarNumeroEntero(){
        try {
            int seleccionUsuario = leerNumeroTeclado();
            return seleccionUsuario;
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    public static String leerTextoTeclado(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int leerNumeroTeclado(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

//Funcion para simplificar la busqueda de un producto en la matriz inventario

    public static int buscarFilaProducto(Object[][] productos, int idProducto){
        int filaDelProducto = -1;
        for (int fila = 0; fila < productos.length; fila++) {
            try {
                if ((int) productos[fila][0] == idProducto) {
                    filaDelProducto = fila;
                    fila = productos.length - 1;
                }
            } catch (java.lang.NullPointerException e) {
                filaDelProducto = -1;
            }
        }
        return filaDelProducto;
    }

//Funcion para evitar errores en las funciones principales

    public static boolean existeProducto(Object[][] productos, int idProducto){
        return buscarFilaProducto(productos, idProducto) != -1;
    }

// Funciones para operaciones basicas

    public static int sumarNumeros(int numero1, int numero2){
        return numero1 + numero2;
    }

    public static int restarNumeros(int numero1, int numero2){
        return numero1 - numero2;
    }
}
