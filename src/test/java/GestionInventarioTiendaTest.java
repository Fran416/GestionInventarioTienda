import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestionInventarioTiendaTest {
    Object[][] productos = new Object[10][3];
    @BeforeAll
    static void setUpBeforeClass() {
        Object[][] productos = new Object[10][3];
        GestionInventarioTienda.agregarProductos(productos,-1, "Arroz", 10, false);
        GestionInventarioTienda.agregarProductos(productos,-1, "Zapallo", 20, false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Manzanas", 200, false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Platino", 300, false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Televisores", 4, false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Papel", 20,false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Camas", 5,false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Mesas", 40,false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Sillas", 90,false);
    }

    @BeforeEach
    void setUp() {
        GestionInventarioTienda.agregarProductos(productos,-1, "Arroz", 10, false);
        GestionInventarioTienda.agregarProductos(productos,-1, "Zapallo", 20, false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Manzanas", 200, false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Platino", 300, false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Televisores", 4, false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Papel", 20,false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Camas", 5,false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Mesas", 40,false);
        GestionInventarioTienda.agregarProductos(productos, -1,"Sillas", 90,false);
    }

    @Test
    void agregarProductos1(){
        assert GestionInventarioTienda.agregarProductos(productos, -1, "Servilletas", 100, false) == "Producto agregado";
    }

    @Test
    void agregarProductos2(){
        assert GestionInventarioTienda.agregarProductos(productos, 3, "", 100, true) == "Aumento de stock exitoso";
    }

    @Test
    void buscadorFilaTest1(){
        assert GestionInventarioTienda.buscarFilaProducto(productos, 1) == 0;
    }

    @Test
    void buscadorFilaTest2(){
        assert GestionInventarioTienda.buscarFilaProducto(productos, 10) == -1;
    }

    @Test
    void existeProductoTest(){
        assert !GestionInventarioTienda.existeProducto(productos, 11);
    }

    @Test
    void existeProductoTest2(){
        assert GestionInventarioTienda.existeProducto(productos, 2);
    }

    @Test
    void restarProductosTest1(){
        assert GestionInventarioTienda.restarProductos(productos, 1, 10) == "Sin Stock restante, producto eliminado del inventario";
    }


    @Test
    void restarProductosTest2(){
        GestionInventarioTienda.restarProductos(productos, 1, 10);
        assert  productos[0][0] == null;
    }

    @Test
    void restarProductosTest3(){
        GestionInventarioTienda.restarProductos(productos, 1, 5);
        assert  (int) productos[0][2] == 5;
    }

    @Test
    void consultarDisponibilidadTest1(){
        assert GestionInventarioTienda.consultarDisponibilidad(productos, 5) == 4;
    }

    @Test
    void consultarDisponibilidadTest2(){
        assert GestionInventarioTienda.consultarDisponibilidad(productos, 8) == 40;
    }
}