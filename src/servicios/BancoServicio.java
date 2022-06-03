package servicios;

import dao.BancoDAO;
import dao.IBancoDAO;
import modelos.Banco;

import java.util.List;

public class BancoServicio implements IBancoServicio {

    private IBancoDAO bancoDAO;

    public BancoServicio(){

        this.bancoDAO = new BancoDAO();
    }

    public boolean existeIdBancos(Integer aValidar){

        List<Banco> listaBancos = this.bancoDAO.dameTodosLosBancos();

        for(Banco bancoAux: listaBancos){
            if(bancoAux.getIdBanco().equals(aValidar))
                return true;
        }
        return false;
    }

    public String listarBancos(){

        List<Banco> listaBancos = this.bancoDAO.dameTodosLosBancos();

        String bancos = "";

        for (Banco bancoAux:listaBancos){
            bancos += bancoAux.getIdBanco()+") Nombre : "+bancoAux.getNombre()+"\nFecha inicio : "+ bancoAux.getFechaInicio() + "\n\n";
        }

        return bancos;

    }

}
