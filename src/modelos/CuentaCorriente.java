package modelos;

public class CuentaCorriente extends Cuenta{

    private Double saldoDeudor;
    private Double salarioPorMes;

    public CuentaCorriente(){
        super();
    }

    public CuentaCorriente(Integer nroCuenta, Cliente duenio, Long cbu, String clave, Double balancePesos, Double saldoDeudor, Double salarioPorMes) {
        super(nroCuenta, duenio, cbu, clave, balancePesos);
        this.saldoDeudor = saldoDeudor;
        this.salarioPorMes = salarioPorMes;
    }

    public Double getSaldoDeudor() {
        return saldoDeudor;
    }

    public void setSaldoDeudor(Double saldoDeudor) {
        this.saldoDeudor = saldoDeudor;
    }

    public Double getSalarioPorMes() {
        return salarioPorMes;
    }

    public void setSalarioPorMes(Double salarioPorMes) {
        this.salarioPorMes = salarioPorMes;
    }
}
