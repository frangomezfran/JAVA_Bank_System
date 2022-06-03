package servicios;

import dao.IEmpleadoDAO;
import dao.EmpleadoDAO;

public class EmpleadoServicio implements IEmpleadoServicio {

    private IEmpleadoDAO EmpleadoDAO;

    public EmpleadoServicio(){
        this.EmpleadoDAO = new EmpleadoDAO();
    }

    public void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva){

        this.EmpleadoDAO.actualizaIdSucursal(idSucursalVieja,idSucursalNueva);
    }
}
