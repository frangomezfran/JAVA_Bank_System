package dao;

import modelos.CajaDeAhorro;

public interface ICajaDeAhorroDAO {

    Long ultimoCbuGeneradoCajaDeAhorro();

    boolean agregarCajaDeAhorro(CajaDeAhorro cuentaNueva, Integer idCliente);

    CajaDeAhorro dameCajaDeAhorroPorCbu(Long cbu);

    void actualizarCuenta (CajaDeAhorro cajaDeAhorro);
}
