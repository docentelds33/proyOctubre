/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooctubre;

import java.util.Date;

/**
 *
 * @author toshiba
 */
public class Venta {
    int nroVenta;
    String cliente;
    Date fechaVenta;
    DetalleVenta [] vectorDetalleVenta;
    double totalPagar;
    String estado;

    public Venta() {
    }

    public Venta(int nroVenta, String cliente, Date fechaVenta, DetalleVenta[] vectorDetalleVenta, double totalPagar, String estado) {
        this.nroVenta = nroVenta;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.vectorDetalleVenta = vectorDetalleVenta;
        this.totalPagar = totalPagar;
        this.estado = estado;
    }

    public int getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(int nroVenta) {
        this.nroVenta = nroVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public DetalleVenta[] getVectorDetalleVenta() {
        return vectorDetalleVenta;
    }

    public void setVectorDetalleVenta(DetalleVenta[] vectorDetalleVenta) {
        this.vectorDetalleVenta = vectorDetalleVenta;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" + "nroVenta=" + nroVenta + ", cliente=" + cliente + ", fechaVenta=" + fechaVenta + ", vectorDetalleVenta=" + vectorDetalleVenta + ", totalPagar=" + totalPagar + ", estado=" + estado + '}';
    }
    
    
    
    
}
