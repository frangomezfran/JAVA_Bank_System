package servicios;

import dao.CajaDeAhorroDAO;
import dao.ICajaDeAhorroDAO;
import modelos.CajaDeAhorro;

public class CajaDeAhorroServicio implements ICajaDeAhorroServicio{

    private ICajaDeAhorroDAO cajaDeAhorroDao;

    public CajaDeAhorroServicio(){
        this.cajaDeAhorroDao = new CajaDeAhorroDAO();
    }

    public String generaCajaDeAhorro(CajaDeAhorro cajaDeAhorroNueva, Integer idCliente){

        CuentaServicio cuentaServicio = new CuentaServicio();
        cajaDeAhorroNueva.setCbu(cuentaServicio.generaNuevoCbu());

        if(this.cajaDeAhorroDao.agregarCajaDeAhorro(cajaDeAhorroNueva,idCliente))
            return "\nCBU generado: "+cajaDeAhorroNueva.getCbu()+"\nLa cuenta fue exitosamente cargada";
        else
            return "Hubo un Error al cargar la cuenta";

    }

    public String imprimeCuenta(CajaDeAhorro cuentaAImprimir){

        String cuenta = "";

        cuenta += "Caja de Ahorros de "+cuentaAImprimir.getDuenio().getNombre()+" "
                +cuentaAImprimir.getDuenio().getApellido()+"\n"+
                "Cbu : "+cuentaAImprimir.getCbu()+"\n"+
                "Balance Pesos : "+cuentaAImprimir.getBalancePesos()+" $\n"+
                "Balance Dolares : "+cuentaAImprimir.getBalanceDolares()+" $\n";

        return cuenta;

    }

    public boolean extraerDinero(CajaDeAhorro cuentaParaExtraer, String moneda, Double aExtraer ){

        if(moneda.equalsIgnoreCase("dolares")
        && cuentaParaExtraer.getBalanceDolares() >= aExtraer){

            cuentaParaExtraer.extraerDolares(aExtraer);
            this.cajaDeAhorroDao.actualizarCuenta(cuentaParaExtraer);
            return true;

        }else if (moneda.equalsIgnoreCase("pesos")
                && cuentaParaExtraer.getBalancePesos() >= aExtraer){

            cuentaParaExtraer.extraer(aExtraer);
            this.cajaDeAhorroDao.actualizarCuenta(cuentaParaExtraer);
            return true;
        }

        return false;

    }

    public void depositarDinero(CajaDeAhorro cuentaADepositar, String moneda, Double aDepositar){

        if(moneda.equalsIgnoreCase("dolares")){

            cuentaADepositar.depositarDolares(aDepositar);
            this.cajaDeAhorroDao.actualizarCuenta(cuentaADepositar);

        }else if (moneda.equalsIgnoreCase("pesos")){

            cuentaADepositar.depositar(aDepositar);
            this.cajaDeAhorroDao.actualizarCuenta(cuentaADepositar);

        }

    }

}
