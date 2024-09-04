import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestionInventarioTiendaTest {
    Object[][] productos = new Object[10][3];
    @BeforeAll
    static void setUpBeforeClass() {
        Object[][] productos = new Object[10][3];
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Arroz", 10);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Zapallo", 20);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Manzanas", 200);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Platino", 300);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Televisores", 4);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Papel", 20);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Camas", 5);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Mesas", 40);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Sillas", 90);
    }

    @BeforeEach
    void setUp() {
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Arroz", 10);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Zapallo", 20);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Manzanas", 200);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Platino", 300);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Televisores", 4);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Papel", 20);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Camas", 5);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Mesas", 40);
        GestionInventarioTienda.ingresarNuevoProducto(productos, "Sillas", 90);
    }

    @Test
    void buscadorFilaTest1(){
        assert GestionInventarioTienda.buscarFilaProducto(productos, 1) == 0;
    }

    @Test
    void buscadorFilaTest2(){
        assert GestionInventarioTienda.buscarFilaProducto(productos, 10) == -1;
    }


}