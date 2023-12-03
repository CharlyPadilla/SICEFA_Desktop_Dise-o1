package org.utl.dsm.sicefa.desktop.dsm406_sicefa.Controller;

public class Venta {
    public int idVenta;
    public String fechaHora;
    public int estatusVenta;
    public int idCliente;
    public String nombreCliente;
    public int idEmpleado;
    public String nombreEmpleado;
    public int idSucursal;
    public String nombreSucursal;

    public Venta(int idVenta, String fechaHora, int estatusVenta, int idCliente, String nombreCliente, int idEmpleado, String nombreEmpleado, int idSucursal, String nombreSucursal) {
        this.idVenta = idVenta;
        this.fechaHora = fechaHora;
        this.estatusVenta = estatusVenta;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getEstatusVenta() {
        return estatusVenta;
    }

    public void setEstatusVenta(int estatusVenta) {
        this.estatusVenta = estatusVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
}
