package modelos;

import java.util.List;

public class Sucursal {

    private Integer idSucursal;
    private Integer idBanco;
    private String domicilio;

    public Sucursal(){}

    public Sucursal(Integer idSucursal, Integer idBanco, String domicilio, List<Empleado> listaEmpleados, List<Cliente> listaClientes) {
        this.idSucursal = idSucursal;
        this.idBanco = idBanco;
        this.domicilio = domicilio;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}
