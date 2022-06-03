package dao;

import modelos.CuentaCorriente;

public interface ICuentaCorrienteDAO {

    boolean agregarCuentaCorriente(CuentaCorriente cuentaNueva, Integer idCliente);

    Long ultimoCbuGeneradoCuentaCorriente();

    CuentaCorriente dameCuentaCorrientePorCbu(Long cbu);

    void actualizarCuenta (CuentaCorriente cuentaCorriente);


}
