
package com.mycompany.empresaalimentosumd.TransaccionesDistribuidas;

import java.util.Date;

public class Transaccion {
    private int idTransaccion;
    private Date fechaHora;
    private int idSucursal;

    public Transaccion(int idTransaccion, Date fechaHora, int idSucursal) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
        this.idSucursal = idSucursal;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    
    
    
}
