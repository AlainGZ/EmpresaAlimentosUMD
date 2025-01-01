
package com.mycompany.empresaalimentosumd.TransaccionesDistribuidas;

import java.util.Date;


public class Venta extends Transaccion{
    private int idProducto;
    private int cantidad;
    private double precioUnitario;

    public Venta(int idProducto, int cantidad, double precioUnitario, int idTransaccion, Date fechaHora, int idSucursal) {
        super(idTransaccion, fechaHora, idSucursal);
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
    
}
