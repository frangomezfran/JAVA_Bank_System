package modelos;

public class Cliente extends Persona{

    private Integer nroCliente;

    public Cliente(){
        super();
    }

    public Cliente(String nombre, String apellido, Long dni, String domicilio, String telefono, Integer cuil, Integer idSucursal, Integer nroCliente) {
        super(nombre, apellido, dni, domicilio, telefono, cuil, idSucursal);
        this.nroCliente = nroCliente;
    }

    public Integer getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(Integer nroCliente) {
        this.nroCliente = nroCliente;
    }

}
