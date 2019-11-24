/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooctubre;

/**
 *
 * @author toshiba
 */
public class DetalleVenta {
    int nroVenta;
    String codigoProducto;
    int cantidad;

    public DetalleVenta() {
    }

    public DetalleVenta(int nroVenta, String codigoProducto, int cantidad) {
        this.nroVenta = nroVenta;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public int getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(int nroVenta) {
        this.nroVenta = nroVenta;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "nroVenta=" + nroVenta + ", codigoProducto=" + codigoProducto + ", cantidad=" + cantidad + '}';
    }

    
    
}
