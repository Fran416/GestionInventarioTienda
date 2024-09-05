public class GestionInventarioTienda {

    public static void ingresarNuevoProducto(Object[][] productos, String nombre, int cantidad){
        for (int fila = 0; fila < productos.length; fila++){
            if (productos[fila][0] == null){
                productos[fila][0] = fila+1;
                productos[fila][1] = nombre;
                productos[fila][2] = cantidad;
                return;
            }
        }
        System.out.println("Inventario lleno");
    }

    public static void agregarProductos(Object[][] productos, int idProducto, int cantidad){
        int fila = buscarFilaProducto(productos, idProducto);
        int cantidadActual = (int) productos[fila][2];
        productos[fila][2] = cantidad + cantidadActual;
        System.out.println("Aumento de stock exitoso");
    }

    public static void restarProductos(Object[][] productos, int idProducto, int cantidad){
        int fila = buscarFilaProducto(productos, idProducto);
        int cantidadActual = (int) productos[fila][2];
        int resta = restarNumeros(cantidadActual, cantidad);
        if (resta >= 0){
            productos[fila][2] = resta;
            System.out.print("Resta de stock exitoso, nueva cantidad: ");
            System.out.println(resta);
        } else {
            System.out.println("Error: No pueden haber productos en negativo");
        }
    }

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

    public static boolean existeProducto(Object[][] productos, int idProducto){
        return buscarFilaProducto(productos, idProducto) != -1;
    }

    public static int sumarNumeros(int numero1, int numero2){
        return numero1 + numero2;
    }

    public static int restarNumeros(int numero1, int numero2){
        return numero1 - numero2;
    }
}
