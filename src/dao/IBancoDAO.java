package dao;

import modelos.Banco;


import java.util.List;

public interface IBancoDAO {

    /**
     * Este metodo me retorna un banco por el ID pasado por parametro
     * @param idBanco id del banco a buscar
     * @return
     */
    Banco dameBancoPorId(Integer idBanco);

    /**
     * Este metodo me retorna en una lista todos los bancos que existen en mi BD
     * @return Lista de todos los bancos de mi BD
     */
    List<Banco> dameTodosLosBancos();

}
