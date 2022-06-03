package modelos;

import java.util.Date;

public class Banco {

    private Integer idBanco;
    private String nombre;
    private Date fechaInicio;

    public Banco(){}

    public Banco(Integer idBanco, String nombre, Date fechaInicio) {
        this.idBanco = idBanco;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

}
