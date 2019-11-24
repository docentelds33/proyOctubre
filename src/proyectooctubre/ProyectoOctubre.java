/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooctubre;

import crud.DetalleVentaCRUD;
import crud.ProductoCRUD;
import crud.VentaCrud;
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class ProyectoOctubre {
//   static Producto_File hcfolio = new Producto_File(); 
   static Producto producto = null;
   static ProductoCRUD prodCrud = new ProductoCRUD();
   Producto vectorProducto [] = new Producto [100];
   static String opc = "S";
   static String opcVt = "N";
   static String fecha;
   
   static VentaCrud ventaCrud = new VentaCrud();
   static DetalleVentaCRUD detallVentCrud = new DetalleVentaCRUD();
   static DetalleVenta detalleVenta = null;
   
   static String menu = "1. Registrar\n"+
                        "2. Listar\n"+
                        "3. Buscar\n"+
                        "4. Modificar\n"+
                        "5. Eliminar\n"+
                        "6. Regresar\n"+
                        "Digite la opcion para continuar";
   
   static String menuVenta = "1. Registrar venta\n"+
                        "2. Listar ventas\n"+
                        "3. Regresar\n"+
                        "Digite la opcion para continuar";
           
   
    public static void main(String[] args) {
            int op = 0;
            do{
                try {
                    op = Integer.valueOf(JOptionPane.showInputDialog(null,"\t\t\t Menú Principal   \n\n"+
                                                                        "1. Maestro de Productos\n"+
                                                                        "2. Maestro de Categorias\n"+
                                                                        "3. Maestro de Clientes\n"+
                                                                        "4. Maestro de Ventas\n"+
                                                                        "5. Salir de la aplicación\n"+
                                                                        "Digite la opción para continuar",JOptionPane.INFORMATION_MESSAGE));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Debe digitar el número");
                }
           
            switch (op){
                case 1:
                    int op3 = 0;
                    do{
                        op3 = Integer.valueOf(JOptionPane.showInputDialog(menu));
                        switch (op3){
                            case 1: 
                               registrarProducto();
                                break;
                            case 2:
                                listarProductos();
                                break;
                            case 3:
                                buscarProducto();
                                break;
                            case 4:
                                modificarProductos();
                                break;
                            case 5:
                                eliminarProducto();
                                break;
//                            default:
//                                JOptionPane.showMessageDialog(null, "Opción no valida...!!!");
//                                break;
                        }
                    } while (op3 != 6);
                case 4:
                    int op4 = 0;
                    do{
                        op4 = Integer.valueOf(JOptionPane.showInputDialog(menuVenta));
                        switch (op4){
                            case 1: 
                               regitrarVenta();
                                break;
                            case 2:
                                listarVentas();
                                break;

                        }
                    } while (op4 != 3);
            }
         }while(op != 5);
//    }
    }
    

//Mostrar opciones principales
    private static void registrarProducto(){
        do{
            try {
                String codigo = JOptionPane.showInputDialog("Digite el código");
                String nombre = JOptionPane.showInputDialog("Digite el nombre");
                double precioCompra = Double.valueOf(JOptionPane.showInputDialog("Digite el precio de compra"));
                double precioVenta = Double.valueOf(JOptionPane.showInputDialog("Digite el precio de venta"));
                
                int estado = 0;
                do{
                   try{
                        estado = Integer.valueOf(JOptionPane.showInputDialog("Seleccione el estado\n\n"+
                                                                               "1. Activo\n"+
                                                                               "2. Inactivo\n"));
                   }
                   catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(null,"Debe digitar un valor numérico");
                   }
                }while((estado<1)||(estado>2));
                String valor="";
                switch (estado){
                        case 1: valor = "Activo";break;
                        case 2: valor = "Inactivo";break;
                        default: JOptionPane.showMessageDialog(null,"Opción inválida...!!!");break;       
                }
                
                //Creamos un producto
                producto = new Producto(codigo, nombre, precioCompra, precioVenta, valor);
                prodCrud.registrarProducto(producto);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al diligenciar el producto " + e);
            }
            String opc = JOptionPane.showInputDialog("Desea registrar otro producto? (S/N");
        }while((!opc.toUpperCase().equals("S")) && (!opc.toUpperCase().equals("N")));
        
    }
    
    private static void listarProductos(){
        prodCrud.listarProductos();
    }
    
    private static void modificarProductos(){
        String codigo = JOptionPane.showInputDialog("Digite el código del producto a consultar"); 
    	Producto prod = prodCrud.buscarProducto(codigo);
    	if (prod == null){
    		JOptionPane.showMessageDialog(null,"El producto no se encuentra registrado");
    	}else{
    		int op = Integer.valueOf(JOptionPane.showInputDialog(null,"Código: "+prod.getCodigo()+"\n"+
                                                                            "1. Nombre: "+prod.getNombre()+"\n"+
                                                                            "2. Precio compra: "+prod.getPrecioCompra()+"\n"+	
                                                                            "3. Precio venta: "+prod.getPrecioVenta()+"\n"+
                                                                            "4. Estado: "+prod.getEstado()+"\n"+
                                                                             "Digite la opción para continuar",JOptionPane.INFORMATION_MESSAGE));
                switch(op){
                    case 1:
                        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                        producto.setNombre(nombre);
                        break;
                    case 2:
                        double precioComp = Double.valueOf(JOptionPane.showInputDialog("Ingrese el nuevo precio de compra"));
                        producto.setPrecioCompra(precioComp);
                        break;
                    case 3:
                        double precioVent = Double.valueOf(JOptionPane.showInputDialog("Ingrese el nuevo precio de venta"));
                        producto.setPrecioVenta(precioVent);
                        break;
                    case 4:
                        String estad = JOptionPane.showInputDialog("Ingrese el nuevo estado");
                        producto.setEstado(estad);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no valida...!!!");
                        break; 
                }
    	}
    }
    
    private static void buscarProducto(){
        String codigo = JOptionPane.showInputDialog("Digite el código del producto a buscar"); 
        Producto prod = prodCrud.buscarProducto(codigo);
        if (prod == null){
                JOptionPane.showMessageDialog(null,"El producto no se encuentra registrado");
        }else{
                JOptionPane.showMessageDialog(null,"Código: "+prod.getCodigo()+"\n"+
                                            "1. Nombre: "+prod.getNombre()+"\n"+
                                            "2. Precio compra: "+prod.getPrecioCompra()+"\n"+	
                                            "3. Precio venta: "+prod.getPrecioVenta()+"\n"+
                                            "4. Estado: "+prod.getEstado()+"\n");

                
        }
    }
    
    private static void eliminarProducto(){
        String codigo = JOptionPane.showInputDialog("Digite el código del producto a eliminar"); 
    	prodCrud.eliminarProducto(codigo);
    }
    
    /*################### METODOS PARA REALIZAR OPERACIONES CON VENTAS ####################*/
    
    private static void regitrarVenta(){
       int cantidad = 0;
       String codigoProducto;
            try {
                //Llamamos al método generarNumeroVenta()
                int nroVenta = ventaCrud.generarNumeroVenta();
                String nombre = JOptionPane.showInputDialog("Digite el cliente");               
                
                do{ //La estructura DO{ }while (), para poder registrar varios productos de la venta
                    try {
                        codigoProducto = JOptionPane.showInputDialog("Digite el código del producto");
                        cantidad = Integer.valueOf(JOptionPane.showInputDialog("Digite la cantidad"));
                        
                        //Con el codigo de vena y la cantidad, creamos un detalle de venta
                        detalleVenta = new DetalleVenta(nroVenta, codigoProducto, cantidad);
                        
                        //llamamos al metodo registrarDetalleVenta() y le enviamos el detalle de venta creado
                        detallVentCrud.registrarDetalleVenta(detalleVenta);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al diligenciar el producto " + e);
                    }
                    opcVt = JOptionPane.showInputDialog("Desea registrar otro producto? (S/N");
                    System.out.println(opcVt.toUpperCase().equals("S"));
                }while(opcVt.toUpperCase().equals("S"));
                
                //Creamos la variable venta y le asignamos los valores.
                Venta venta = new Venta(nroVenta, nombre, Converciones.fecha, detallVentCrud.obtenerDetalleVenta(), cantidad, "Activo");
                
                //Llamamos al método registrarVenta(), y enviamos la venta creada
                ventaCrud.registrarVenta(venta);
                
                //Método que permite listar el contenido de la venta realizada
                listarVenta(venta);
                
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al diligenciar el producto " + e);
            }
            
    }
    
    private static void listarVentas(){
        ventaCrud.listarVentas();
        
    }
    
    //Este método lista el contenido de la venta que se esta realizando, recibe una variable de tipo venta
    public static void listarVenta(Venta venta){
        producto = new Producto();
        int c = 0; // Variable para el contador c = c + 1
        double a = 0.0; // Variable para el acumulador a = a + valor
        String salida = "   Información de la Venta\n"+
                "<html><table border=0 cellspacing=0 cellpadding=2>"+
                    "<tr>"+
                        "<td>Nro. Venta</td>"+
                        "<td>" + venta.getNroVenta() + "</td>"+
                    "</tr>"+  
                    "<tr>"+
                        "<td>Cliente</td>"+
                        "<td>" + venta.getCliente()+ "</td>"+
                    "</tr>"+
                    "<tr>"+
                        "<td>Fecha</td>"+
                        "<td>" + Converciones.fechaDelSistema(venta.getFechaVenta()) +  "</td>"+ //Llamamos a Converciones
                    "</tr>"+
                    "<tr>"+
                        "<td>Estado</td>"+
                        "<td>" + venta.getEstado() + "</td>"+
                    "</tr>"+
                "</table>";

       salida += "<table border=1 cellspacing=0 cellpadding=2>"+
                    "<tr>"+
                        "<td>Item</td>"+
                        "<td>Producto</td>"+
                        "<td>Cantidad</td>"+
                        "<td>Total</td>"+
                    "</tr>";
        for (int i = 0; i <= detallVentCrud.obtenerDetallesRegistrados(); i++) {
            
            //Obtenemos todos los detalle de venta que pertecen a la venta que se esta realizando
            if (detallVentCrud.obtenerDetalleVenta()[i].getNroVenta() == venta.getNroVenta() ) {

            detalleVenta = detallVentCrud.obtenerDetalleVenta()[i];
           
            Producto prod = prodCrud.buscarProducto(venta.getVectorDetalleVenta()[i].getCodigoProducto());

             c = c + 1; //Contador para enumerar los productos asignador a la compra
            salida += "<tr>"+
                        "<td>" + c + "</td>"+
                        "<td>" + prod.getNombre() + "</td>"+
                        "<td>" + detalleVenta.getCantidad() + "</td>"+
                        "<td>" + prod.getPrecioCompra() * detalleVenta.getCantidad() + "</td>"+
                        
                    "</tr>";
            //Acumulador que permitira almacena la multiplicación del precio de compra X cantidad
             a = a + prod.getPrecioCompra() * detalleVenta.getCantidad();
            }

        }
        salida += "</table>";   
        
        salida += "<table border=0 cellspacing=0 cellpadding=2>"+
                     "<tr>"+
                        "<td> Total a pagar: </td>"+
                        "<td>" + a +  "</td>"+
                    "</tr>"+
                    "</table>"+
                    "</html>";
     
        JOptionPane.showMessageDialog(null, salida);
    }
    
}
