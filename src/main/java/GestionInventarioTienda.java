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
        if (fila == -1){
            System.out.println("Error: No existe el producto");
        } else {
            int cantidadActual = (int) productos[fila][2];
            productos[fila][2] = cantidad + cantidadActual;
            System.out.println("Aumento de stock exitoso");
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
}
