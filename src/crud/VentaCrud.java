
package crud;

import javax.swing.JOptionPane;
import proyectooctubre.Converciones;
import proyectooctubre.Venta;


public class VentaCrud {
    int tamanioVector;
    int numVentas=0;
    private Venta[] vectorVenta;
  
        
    public VentaCrud(){
        tamanioVector = 100;
        vectorVenta = new Venta [tamanioVector];
        numVentas = 0;
    }
    
    public void registrarVenta (Venta vent){
        vectorVenta[numVentas] = vent;
        numVentas++;
    }

    
    public void listarVentas(){
        String salida = "    Listado de Ventas\n"+
                "<html><table border=1 cellspacing=0 cellpadding=2>"+
                    "<tr>"+
                        "<td>Nro. Venta</td>"+
                        "<td>Cliente</td>"+
                        "<td>Fecha</td>"+
                        
                        "<td>Estado</td>"+
                    "</tr>";
        for (int i = 0; i < numVentas; i++) {
            salida += "<tr>"+
                        "<td>" + vectorVenta[i].getNroVenta() + "</td>"+
                        "<td>" + vectorVenta[i].getCliente() + "</td>"+
                        "<td>" + Converciones.fechaDelSistema(vectorVenta[i].getFechaVenta()) + "</td>"+
                        "<td>" + vectorVenta[i].getEstado() + "</td>"+
                        
                    "</tr>";
        }
        salida += "</table></html>";
        JOptionPane.showMessageDialog(null, salida);
    }
    
    //Método que permite Generar el número de venta
    public int generarNumeroVenta(){
        int nroVenta = numVentas + 1;
        return nroVenta;
    }

    
}
