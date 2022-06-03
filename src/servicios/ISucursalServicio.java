package servicios;

public interface ISucursalServicio {

    String listarSucursalesPorIdBanco(Integer idBanco);

    boolean existeIdSucursalPorBanco(Integer eleccionBanco,Integer eleccionSucursal);

    String listaSucursalesQueSePuedenBorrar();

    boolean existeIdSucursalABorrar(Integer eleccionSucursal);

    Integer dameIdSucursalAmiga(Integer sucursalABorrar);

    void eliminarSucursal(Integer idSucursalABorrar);
}
