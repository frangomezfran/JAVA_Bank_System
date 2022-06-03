package dao;

import modelos.Banco;

import java.util.List;

/**
 * Esta clase es la encargada de traerme los datos de Banco de mi Base de datos
 * @author Franco Gomez
 */
public interface IBancoDAO {

    /**
     * Este metodo me retorna en una lista todos los bancos que existen en mi BD
     * @return Lista de todos los bancos de mi BD
     */
    List<Banco> dameTodosLosBancos();

}
