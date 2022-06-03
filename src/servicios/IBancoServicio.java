package servicios;

/**
 * Esta clase es la encargada de manipular los datos de la Base de datos de Banco y los datos
 * que llegan del main
 * @author Franco Gomez
 */
public interface IBancoServicio {

    /**
     * Este metodo me informa si es que existe el id de banco en la BD
     * @param aValidar id del banco a verificar si existe
     * @return un true si existe, caso contrario false
     */
    boolean existeIdBancos(Integer aValidar);

    /**
     * Este metodo me retorna un String con todos los banco de la BD
     * @return String con todos los bancos enlistados
     */
    String listarBancos();
}
