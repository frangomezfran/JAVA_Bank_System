package dao;

import modelos.Sucursal;

import java.util.List;

public interface ISucursalDAO {

    List<Sucursal> dameListaSucursalesPorBanco(Integer idBanco);

    List<Sucursal> sucursalesQueSePuedenBorrar();

    Integer dameIdBancoDeUnaSucursal(Integer idSucursal);

    Integer dameIdSucursalAmiga(Integer idSucursal);

    void eliminarSucursal(Integer idSucursalABorrar);
}
