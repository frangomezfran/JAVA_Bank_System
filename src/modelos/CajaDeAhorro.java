package modelos;

public class CajaDeAhorro extends Cuenta{

    private Double balanceDolares;

    public CajaDeAhorro(){
        super();
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
