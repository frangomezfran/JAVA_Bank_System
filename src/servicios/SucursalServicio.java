package servicios;

import dao.ISucursalDAO;
import dao.SucursalDAO;
import modelos.Sucursal;

import java.util.List;

public class SucursalServicio implements ISucursalServicio {

    private ISucursalDAO sucursalDAO;

    public SucursalServicio(){
        this.sucursalDAO = new SucursalDAO();
    }

    public String listarSucursalesPorIdBanco(Integer idBanco){
        List<Sucursal> listaSucursal = this.sucursalDAO.dameListaSucursalesPorBanco(idBanco);

        String sucursales = "";

        for (Sucursal sucursalAux:listaSucursal){
            sucursales += sucursalAux.getIdSucursal()+") Domicilio : "+sucursalAux.getDomicilio()+"\n\n";
        }

        return sucursales;
    }

    public boolean existeIdSucursalPorBanco(Integer eleccionBanco,Integer eleccionSucursal){

        List<Sucursal> listaSucursales = this.sucursalDAO.dameListaSucursalesPorBanco(eleccionBanco);

        for (Sucursal sucursalAux : listaSucursales){
            if(sucursalAux.getIdSucursal().equals(eleccionSucursal))
                return true;
        }

        return false;
    }

    public String listaSucursalesQueSePuedenBorrar(){

        List<Sucursal> listaSucursales = this.sucursalDAO.sucursalesQueSePuedenBorrar();

        String sucursalesQueSePuedenBorrar = "\n";

        if(listaSucursales != null){

            for(Sucursal sucursalABorrar : listaSucursales){
                sucursalesQueSePuedenBorrar += sucursalABorrar.getIdSucursal()+") Domicilio : "+sucursalABorrar.getDomicilio()+"\n\n";
            }

        }

        return sucursalesQueSePuedenBorrar;

    }

    public boolean existeIdSucursalABorrar(Integer eleccionSucursal){

        List<Sucursal> listaSucursales = this.sucursalDAO.sucursalesQueSePuedenBorrar();

        for (Sucursal sucursalAux : listaSucursales){
            if(sucursalAux.getIdSucursal().equals(eleccionSucursal))
                return true;
        }

        return false;
    }

    public Integer dameIdSucursalAmiga(Integer sucursalABorrar){

        return this.sucursalDAO.dameIdSucursalAmiga(sucursalABorrar);

    }

    public void eliminarSucursal(Integer idSucursalABorrar){

        this.sucursalDAO.eliminarSucursal(idSucursalABorrar);
    }
}
