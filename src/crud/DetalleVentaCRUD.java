
package crud;

import javax.swing.JOptionPane;
import proyectooctubre.DetalleVenta;
import proyectooctubre.Producto;

public class DetalleVentaCRUD {
    int tamanioVector;
    int numDetallVentas;
    DetalleVenta[] vectorDetalleVenta;
    DetalleVenta detalleVenta;
    
    Producto producto = new Producto();
    ProductoCRUD prodCrud = new ProductoCRUD();
    
    public DetalleVentaCRUD(){
        tamanioVector = 100; 
        vectorDetalleVenta = new DetalleVenta [tamanioVector];
        numDetallVentas = -1;
    }
    
    public void registrarDetalleVenta (DetalleVenta detalleVenta){
        numDetallVentas++;
        vectorDetalleVenta[numDetallVentas] = detalleVenta;
    }
     
    public DetalleVenta[] obtenerDetalleVenta(){
      return vectorDetalleVenta;
    }
 
    //Permite devolver el número de registros que hay en vectorDetalleVenta
    public int obtenerDetallesRegistrados (){
        return numDetallVentas;
    }
}
