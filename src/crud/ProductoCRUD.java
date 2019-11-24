
package crud;

import java.io.Serializable;
import javax.swing.JOptionPane;
import proyectooctubre.Producto;

public class ProductoCRUD implements Serializable {
    int tamanioVector;
    int numProd = -1;
    Producto [] vectorProductos;
    Producto prod;
    
    public ProductoCRUD(){
        tamanioVector = 100;
        vectorProductos = new Producto [tamanioVector];
//        numProd = -1;
    }
    
    public void registrarProducto (Producto prod){
        numProd++;
        vectorProductos[numProd] = prod;
    }
    
    private int posicion (Producto prod){
        int pos = -1;
        for (int i = 0; i <= numProd; i++) {
            if(prod.getCodigo().compareTo(vectorProductos[i].getCodigo())==0){
                pos = i;
            }
        }
        return pos;
    }
    
    private int posicion(String cod){
        int pos = -1;
        for (int i = 0; i <= numProd; i++) {
            if(cod.compareTo(vectorProductos[i].getCodigo())==0){
                pos = i;
            }
        }
        return pos;
    }
    
    public Producto buscarProducto(String codigo){
        prod = new Producto();
        for (int i = 0; i <= numProd; i++) {
            if (codigo.compareTo(vectorProductos[i].getCodigo())==0) {
                prod  = vectorProductos[i];
            }
        }
        return prod;
    }
    
    public Producto buscarProducto(Producto prod){
        for (int i = 0; i <= numProd; i++) {
            if (prod.getCodigo().compareTo(vectorProductos[i].getCodigo())==0) {
                prod  = vectorProductos[i];
            }
        }
        return prod;
    }
    
    public void eliminarProducto(String codigo){
        int pos  = posicion(codigo);
        System.out.println("VAlor: " + pos);
        if(pos != -1){
            for (int i = 0; i <= numProd; i++) {
                vectorProductos[i] = vectorProductos[i+1];
            }
            numProd--;
            JOptionPane.showMessageDialog(null,"Producto eliminado satisfactoreamente");
        }else{
            JOptionPane.showMessageDialog(null, "Este producto no se encuentra registrado");
        }
    }
    
    public void listarProductos(){
        String salida = "    Listado de Productos\n"+
                "<html><table border=1 cellspacing=0 cellpadding=2>"+
                    "<tr>"+
                        "<td>Código</td>"+
                        "<td>Nombre</td>"+
                        "<td>Precio compra</td>"+
                        "<td>Precio venta</td>"+
                        "<td>Estado</td>"+
                    "</tr>";
        for (int i = 0; i <= numProd; i++) {
            Producto producto = vectorProductos[i];
            salida += "<tr>"+
                        "<td>" + producto.getCodigo() + "</td>"+
                        "<td>" + producto.getNombre() + "</td>"+
                        "<td>" + producto.getPrecioCompra() + "</td>"+
                        "<td>" + producto.getPrecioVenta() + "</td>"+
                        "<td>" + producto.getEstado() + "</td>"+
                    "</tr>";
        }
        salida += "</table></html>";
        JOptionPane.showMessageDialog(null, salida);
    }
    
    
}
