import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestionInventarioTiendaTest {
    Object[][] productos = new Object[10][3];
    @BeforeAll
    static void setUpBeforeClass() {
        Object[][] productos = new Object[10][3];
        GestionInventarioTienda.agregarProductos(productos,-1, "Arroz", 10);
        GestionInventarioTienda.agregarProductos(productos,-1, "Zapallo", 20);
        GestionInventarioTienda.agregarProductos(productos, -1,"Manzanas", 200);
        GestionInventarioTienda.agregarProductos(productos, -1,"Platino", 300);
        GestionInventarioTienda.agregarProductos(productos, -1,"Televisores", 4);
        GestionInventarioTienda.agregarProductos(productos, -1,"Papel", 20);
        GestionInventarioTienda.agregarProductos(productos, -1,"Camas", 5);
        GestionInventarioTienda.agregarProductos(productos, -1,"Mesas", 40);
        GestionInventarioTienda.agregarProductos(productos, -1,"Sillas", 90);
    }

    @BeforeEach
    void setUp() {
        GestionInventarioTienda.agregarProductos(productos,-1, "Arroz", 10);
        GestionInventarioTienda.agregarProductos(productos,-1, "Zapallo", 20);
        GestionInventarioTienda.agregarProductos(productos, -1,"Manzanas", 200);
        GestionInventarioTienda.agregarProductos(productos, -1,"Platino", 300);
        GestionInventarioTienda.agregarProductos(productos, -1,"Televisores", 4);
        GestionInventarioTienda.agregarProductos(productos, -1,"Papel", 20);
        GestionInventarioTienda.agregarProductos(productos, -1,"Camas", 5);
        GestionInventarioTienda.agregarProductos(productos, -1,"Mesas", 40);
        GestionInventarioTienda.agregarProductos(productos, -1,"Sillas", 90);
    }

    @Test
    void agregarProductos1(){
        assert GestionInventarioTienda.agregarProductos(productos, -1, "Servilletas", 100) == "Producto agregado";
    }

    @Test
    void agregarProductos2(){
        assert GestionInventarioTienda.agregarProductos(productos, 3, "", 100) == "Aumento de stock exitoso";
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



}