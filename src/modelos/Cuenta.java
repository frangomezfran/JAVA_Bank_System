package modelos;

public abstract class Cuenta {

    private Integer nroCuenta;
    private Cliente duenio;
    private Long cbu;
    private String clave;
    private Double balancePesos;

    public Cuenta(){}

    public Cuenta(Integer nroCuenta, Cliente duenio, Long cbu, String clave, Double balancePesos) {
        this.nroCuenta = nroCuenta;
        this.duenio = duenio;
        this.cbu = cbu;
        this.clave = clave;
        this.balancePesos = balancePesos;
    }

    public Integer getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(Integer nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Cliente getDuenio() {
        return duenio;
    }

    public void setDuenio(Cliente duenio) {
        this.duenio = duenio;
    }

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Double getBalancePesos() {
        return balancePesos;
    }

    public void setBalancePesos(Double balancePesos) {
        this.balancePesos = balancePesos;
    }

    public void extraer(Double aExtraer){
        this.balancePesos-= aExtraer;
    }

    public void setNroCliente(Integer nroCliente){
        this.setDuenio(new Cliente());
        this.duenio.setNroCliente(nroCliente);
    }

    public void depositar(Double aDepositar){
        this.balancePesos+=aDepositar;
    }
}
