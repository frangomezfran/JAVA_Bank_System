package servicios;

import dao.CajaDeAhorroDAO;
import dao.CuentaCorrienteDAO;
import dao.CuentaDAO;
import modelos.CajaDeAhorro;
import modelos.Cuenta;
import modelos.CuentaCorriente;

public class CuentaServicio implements ICuentaServicio {

    private CajaDeAhorroDAO cajaDeAhorroDAO;
    private CuentaCorrienteDAO cuentaCorrienteDAO;
    private CuentaDAO cuentaDAO;
    private CuentaCorrienteServicio cuentaCorrienteServicio;
    private CajaDeAhorroServicio cajaDeAhorroServicio;

    public CuentaServicio(){
        this.cajaDeAhorroDAO= new CajaDeAhorroDAO();
        this.cuentaCorrienteDAO = new CuentaCorrienteDAO();
        this.cuentaDAO = new CuentaDAO();
        this.cuentaCorrienteServicio = new CuentaCorrienteServicio();
        this.cajaDeAhorroServicio = new CajaDeAhorroServicio();
    }

    public Long generaNuevoCbu(){

        Long ultimoCbuCC = this.cuentaCorrienteDAO.ultimoCbuGeneradoCuentaCorriente();
        Long ultimoCbuCA = this.cajaDeAhorroDAO.ultimoCbuGeneradoCajaDeAhorro();

        if(ultimoCbuCA > ultimoCbuCC )
            return ( ultimoCbuCA + 1 );
        else
            return ( ultimoCbuCC + 1 );

    }

    public Cuenta entrandoACuenta(Long cbu, String clave){

        CuentaCorriente cuentaCorriente = this.cuentaCorrienteDAO.dameCuentaCorrientePorCbu(cbu);
        if(cuentaCorriente!=null && cuentaCorriente.getClave().equals(clave))
            return cuentaCorriente;

        CajaDeAhorro cajaDeAhorro = this.cajaDeAhorroDAO.dameCajaDeAhorroPorCbu(cbu);
        if(cajaDeAhorro!=null && cajaDeAhorro.getClave().equals(clave))
            return cajaDeAhorro;

        return null;

    }

    public boolean transferirDinero(Cuenta cuentaEmisora, Long cbuRecibidor, String moneda, Double aTransferir){

       String tipoDeCuentaReceptora = this.cuentaDAO.queTipoDeCuentaEs(cbuRecibidor);

        Cuenta cuentaReceptora = null;

        if( tipoDeCuentaReceptora != null && !cuentaEmisora.getCbu().equals(cbuRecibidor) ) {
            // La cuenta Receptora existe

            if(tipoDeCuentaReceptora.equals("CC"))
                cuentaReceptora = (CuentaCorriente) this.cuentaCorrienteDAO.dameCuentaCorrientePorCbu(cbuRecibidor);
            else
                cuentaReceptora = (CajaDeAhorro) this.cajaDeAhorroDAO.dameCajaDeAhorroPorCbu(cbuRecibidor);


            if (cuentaEmisora instanceof CuentaCorriente) {
                //La cuenta emisora es CC

                if (moneda.equalsIgnoreCase("pesos")){

                    if(this.cuentaCorrienteServicio.extraerDinero((CuentaCorriente) cuentaEmisora, aTransferir)){

                        if(tipoDeCuentaReceptora.equals("CC"))
                            this.cuentaCorrienteServicio.depositarDinero((CuentaCorriente) cuentaReceptora, aTransferir);
                        else
                            this.cajaDeAhorroServicio.depositarDinero((CajaDeAhorro) cuentaReceptora,"pesos", aTransferir);


                        return true;//La transferencia fue un exito

                    }else{

                        return false;//El emisor no tiene dinero suficiente
                    }

                } else {
                    return false;//No se puede mandar dolares desde una CC
                }


            } else {
                //La cuenta emisora es CA

                if (moneda.equalsIgnoreCase("pesos")) {

                    if(this.cajaDeAhorroServicio.extraerDinero((CajaDeAhorro) cuentaEmisora, moneda, aTransferir)){

                        if(tipoDeCuentaReceptora.equals("CC"))
                            this.cuentaCorrienteServicio.depositarDinero((CuentaCorriente) cuentaReceptora, aTransferir);
                        else
                            this.cajaDeAhorroServicio.depositarDinero((CajaDeAhorro) cuentaReceptora, moneda, aTransferir);

                        return true;//La transferencia fue un exito

                    }else{

                        return false;//El emisor no tiene dinero suficiente
                    }

                }else{
                    //La moneda es Dolares

                    if(this.cajaDeAhorroServicio.extraerDinero((CajaDeAhorro) cuentaEmisora, moneda, aTransferir)){

                        if(tipoDeCuentaReceptora.equals("CA"))
                            this.cajaDeAhorroServicio.depositarDinero((CajaDeAhorro)cuentaReceptora, moneda, aTransferir);
                        else
                            return false;//No se puede transferir dolares a una CC

                        return true;//La transferencia fue un exito

                    }else{

                        return false;//El emisor no tiene dinero suficiente
                    }

                }
            }

        }else{
            return false; //La cuenta receptora no existe
        }

    }
}
