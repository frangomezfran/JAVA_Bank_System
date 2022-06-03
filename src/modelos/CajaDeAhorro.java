package modelos;

public class CajaDeAhorro extends Cuenta{

    private Double balanceDolares;

    public CajaDeAhorro(){
        super();
    }

    public CajaDeAhorro(Integer nroCuenta, Cliente duenio, Long cbu, String clave, Double balancePesos, Double balanceDolares) {
        super(nroCuenta, duenio, cbu, clave, balancePesos);
        this.balanceDolares = balanceDolares;
    }

    public Double getBalanceDolares() {
        return balanceDolares;
    }

    public void setBalanceDolares(Double balanceDolares) {
        this.balanceDolares = balanceDolares;
    }

    public void extraerDolares(Double aExtraer){
        this.balanceDolares -= aExtraer;
    }

    public void depositarDolares(Double aDepositar){
        this.balanceDolares += aDepositar;
    }
}
