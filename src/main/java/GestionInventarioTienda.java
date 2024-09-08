import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionInventarioTienda {


//Funciones que debian implementarse en el sistema

    public static String agregarProductos(Object[][] productos, int idProducto, String nombreProducto, int cantidad){
        if (nombreProducto == ""){
            int fila = buscarFilaProducto(productos, idProducto);
            int cantidadActual = (int) productos[fila][2];
            productos[fila][2] = sumarNumeros(cantidadActual, cantidad);
            return "Aumento de stock exitoso";
        } else if (idProducto ==  -1){
            for (int fila = 0 ; fila < productos.length ; fila++){
                if (productos[fila][0] == null){
                    productos[fila][0] = fila+1;
                    productos[fila][1] = nombreProducto;
                    productos[fila][2] = cantidad;
                    return "Producto agregado";
                }
            }
        }
        return "Error : No se pudieron agregar más productos ";
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

    public static void mostrarMenu(){
        System.out.println("---------------------- Menu Principal ----------------------");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Restar Stock de un Producto");
        System.out.println("3. Consultar Stock de un Producto");
        System.out.println("4. Listar Productos");
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
        String texto = sc.nextLine();
        sc.close();
        return texto;
    }

    public static int leerNumeroTeclado(){
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        sc.close();
        return numero;
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
