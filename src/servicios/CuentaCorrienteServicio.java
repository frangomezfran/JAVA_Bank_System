package servicios;

import dao.CuentaCorrienteDAO;
import dao.ICuentaCorrienteDAO;
import modelos.CuentaCorriente;

public class CuentaCorrienteServicio implements ICuentaCorrienteServicio {

    private ICuentaCorrienteDAO cuentaCorrienteDAO;

    public CuentaCorrienteServicio(){
        this.cuentaCorrienteDAO = new CuentaCorrienteDAO();
    }

    public String generaCuentaCorriente(CuentaCorriente cuentaCorrienteNueva, Integer idCliente){

        CuentaServicio cuentaServicio = new CuentaServicio();
        cuentaCorrienteNueva.setCbu(cuentaServicio.generaNuevoCbu());

        if(this.cuentaCorrienteDAO.agregarCuentaCorriente(cuentaCorrienteNueva,idCliente))
            return "\nCBU generado: "+cuentaCorrienteNueva.getCbu()+"\nLa cuenta fue exitosamente cargada";
        else
            return "Hubo un Error al cargar la cuenta";

    }

    public String imprimeCuenta(CuentaCorriente cuentaAImprimir){

        String cuenta = "";

        cuenta += "Cuenta Corriente de "+cuentaAImprimir.getDuenio().getNombre()+" "
                +cuentaAImprimir.getDuenio().getApellido()+"\n"+
                "Cbu : "+cuentaAImprimir.getCbu()+"\n"+
                "Balance Pesos : "+cuentaAImprimir.getBalancePesos()+" $\n"+
                "Saldo Deudor : "+cuentaAImprimir.getSaldoDeudor()+" $\n"+
                "Salario Por Mes : "+cuentaAImprimir.getSalarioPorMes()+" $\n";

        return cuenta;

    }

    public boolean extraerDinero(CuentaCorriente cuentaParaExtraer,Double aExtraer){

        Double maxParaExtraer = (cuentaParaExtraer.getBalancePesos()) + ( (cuentaParaExtraer.getSalarioPorMes()/2) + cuentaParaExtraer.getSaldoDeudor() ) ;

        if(maxParaExtraer>=aExtraer) {

            cuentaParaExtraer.extraer(aExtraer);

            if(cuentaParaExtraer.getBalancePesos()<0) {
                cuentaParaExtraer.setSaldoDeudor(cuentaParaExtraer.getSaldoDeudor() + cuentaParaExtraer.getBalancePesos());
                cuentaParaExtraer.setBalancePesos(0d);
            }

            this.cuentaCorrienteDAO.actualizarCuenta(cuentaParaExtraer);

            return true;

        }

        return false;

    }

    public void depositarDinero(CuentaCorriente cuentaADepositar, Double aDepositar){

        if(cuentaADepositar.getSaldoDeudor() < 0){
            cuentaADepositar.setSaldoDeudor(cuentaADepositar.getSaldoDeudor()+aDepositar);
            if(cuentaADepositar.getSaldoDeudor() > 0){
                cuentaADepositar.setBalancePesos(cuentaADepositar.getSaldoDeudor());
                cuentaADepositar.setSaldoDeudor(0d);
            }
        }else{
            cuentaADepositar.setBalancePesos(cuentaADepositar.getBalancePesos()+aDepositar);
        }

        this.cuentaCorrienteDAO.actualizarCuenta(cuentaADepositar);

    }

}
