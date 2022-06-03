package main;

import main.excepciones.*;
import modelos.CajaDeAhorro;
import modelos.Cliente;
import modelos.Cuenta;
import modelos.CuentaCorriente;
import servicios.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaBancario {

    private IBancoServicio bancoServicio;
    private IClienteServicio clienteServicio;
    private ISucursalServicio sucursalServicio;
    private ICuentaServicio cuentaServicio;
    private ICajaDeAhorroServicio cajaDeAhorroServicio;
    private ICuentaCorrienteServicio cuentaCorrienteServicio;
    private IEmpleadoServicio empleadoServicio;

    public SistemaBancario(){
        this.bancoServicio = new BancoServicio();
        this.clienteServicio = new ClienteServicio();
        this.cajaDeAhorroServicio = new CajaDeAhorroServicio();
        this.sucursalServicio = new SucursalServicio();
        this.cuentaServicio = new CuentaServicio();
        this.cuentaCorrienteServicio = new CuentaCorrienteServicio();
        this.empleadoServicio = new EmpleadoServicio();
    }

    public static void main(String[] args) {

        SistemaBancario sistemaBancario = new SistemaBancario();

        while(true) {
            limpiaConsola();
            sistemaBancario.menuPrincipal();
        }

    }

    public static int pideNumeroEnteroConRango(int primerNumero, int ultimoNumero){

        Scanner input = new Scanner(System.in);
        int num = 0;
        boolean repeat;

        do {
            repeat = false;
            try {
                System.out.print("\nIngrese un numero entero desde "+primerNumero+" al "+ultimoNumero+": ");
                num = input.nextInt();
                if(num == 0){
                    throw new CeroNumberException();
                }else if(num < primerNumero || num > ultimoNumero){
                    throw new RangeNumberException();
                }
            } catch (InputMismatchException | CeroNumberException | RangeNumberException e) {
                repeat = true;
            }
            input.nextLine();
        }while(repeat);

        return num;
    }

    public static double pideNumeroDouble(String mensaje){

        Scanner input = new Scanner(System.in);
        double num = 0d;
        boolean repeat;

        do {
            repeat = false;
            try {
                System.out.print(mensaje);
                num = input.nextDouble();

            } catch (InputMismatchException e) {
                repeat = true;
            }
            input.nextLine();
        }while(repeat);

        return num;
    }

    public static double pideNumeroDoublePositivo(String mensaje){

        Scanner input = new Scanner(System.in);
        double num = 0d;
        boolean repeat;

        do {
            repeat = false;
            try {
                System.out.print(mensaje);
                num = input.nextDouble();
                if(num == 0){
                    throw new CeroNumberException();
                }else if(num < 0){
                    throw new RangeNumberException();
                }

            } catch (InputMismatchException | CeroNumberException |  RangeNumberException e) {
                repeat = true;
            }
            input.nextLine();
        }while(repeat);

        return num;
    }

    public static int pideNumeroEntero(String mensaje){

        Scanner input = new Scanner(System.in);
        int num = 0;
        boolean repeat;

        do {
            repeat = false;
            try {
                System.out.print(mensaje);
                num = input.nextInt();
                if(num == 0){
                    throw new CeroNumberException();
                }
            } catch (InputMismatchException | CeroNumberException e) {
                repeat = true;
            }
            input.nextLine();
        }while(repeat);

        return num;
    }

    public static String pideString(String mensaje){

        Scanner input = new Scanner(System.in);
        String aRetornar = "";
        boolean repeat;

        do {
            repeat = false;
            try {
                System.out.print(mensaje);
                aRetornar = input.nextLine();
            } catch (InputMismatchException e) {
                repeat = true;
            }
            //input.nextLine();
        }while(repeat);

        return aRetornar;
    }

    public static Long pideLong (String mensaje){

        Scanner input = new Scanner(System.in);
        Long aValidar = 0L ;
        boolean repeat;

        do {
            repeat = false;
            try {
                System.out.print(mensaje);
                aValidar = input.nextLong();
                if(aValidar.equals(0L)){
                    throw new CeroNumberException();
                }
            } catch (InputMismatchException | CeroNumberException e) {
                repeat = true;
            }
            input.nextLine();
        }while(repeat);

        return aValidar;
    }

    public Cliente crearCliente(Integer nroSucursal){

        Cliente clienteNuevo = new Cliente();

        clienteNuevo.setNombre(pideString("Ingrese Nombre : "));
        clienteNuevo.setApellido(pideString("Ingrese Apellido : "));
        clienteNuevo.setDni(pideLong("Ingrese DNI : "));
        clienteNuevo.setDomicilio(pideString("Ingrese Domicilio : "));
        clienteNuevo.setTelefono(pideString("Ingrese Telefono : "));
        clienteNuevo.setCuil(pideNumeroEntero("Ingrese Cuil : "));
        clienteNuevo.setIdSucursal(nroSucursal);

        return clienteNuevo;
    }

    public static void limpiaConsola(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSistema Bancario [Franco Gomez]\n");
    }

    public static void presioneParaContinuar(){
        Scanner input = new Scanner (System.in);
        System.out.print("\nPresione Enter para continuar ");
        input.nextLine();
    }

    public void agregarCliente(){

        //Listo los bancos
        limpiaConsola();
        System.out.print("\nElija el banco : \n"+this.bancoServicio.listarBancos());

        //Elegimos el banco
        Integer eleccionBanco;
        do {
            eleccionBanco = pideNumeroEntero("Ingrese el ID del banco : ");
        }while (!this.bancoServicio.existeIdBancos(eleccionBanco));

        //Listo las sucursales del banco elegido
        limpiaConsola();
        System.out.print("\nElija la sucursal :\n"+this.sucursalServicio.listarSucursalesPorIdBanco(eleccionBanco));

        //Elegimos la sucursal
        Integer eleccionSucursal;
        do {
            eleccionSucursal = pideNumeroEntero("Ingrese el ID de la sucursal : ");
        }while (!this.sucursalServicio.existeIdSucursalPorBanco(eleccionBanco,eleccionSucursal));

        //Creamos el nuevo Cliente y lo agregamos a la sucursal
        limpiaConsola();
        System.out.println(this.clienteServicio.agregarCliente(this.crearCliente(eleccionSucursal)));

    }

    public CajaDeAhorro creaCajaDeAhorro(Cliente duenio){

        CajaDeAhorro cajaDeAhorroNueva = new CajaDeAhorro();
        cajaDeAhorroNueva.setDuenio(duenio);
        cajaDeAhorroNueva.setClave(pideString("Ingrese una clave para su CA : "));
        cajaDeAhorroNueva.setBalancePesos(0d);
        cajaDeAhorroNueva.setBalanceDolares(0d);
        return cajaDeAhorroNueva;
    }

    public CuentaCorriente creaCuentaCorriente(Cliente duenio){

        CuentaCorriente cuentaCorrienteNueva = new CuentaCorriente();
        cuentaCorrienteNueva.setDuenio(duenio);
        cuentaCorrienteNueva.setClave(pideString("Ingrese una clave para su CC : "));
        cuentaCorrienteNueva.setBalancePesos(0d);
        cuentaCorrienteNueva.setSaldoDeudor(0d);
        cuentaCorrienteNueva.setSalarioPorMes(pideNumeroDouble("Ingrese el salario por mes : "));
        return cuentaCorrienteNueva;

    }

    public void agregarCuentaCliente(){

        limpiaConsola();
        Integer dniCliente = pideNumeroEntero("Ingrese el DNI del cliente : ");

        limpiaConsola();
        Cliente clienteNuevaCuenta = this.clienteServicio.dameClientePorDni(dniCliente);

        if(clienteNuevaCuenta == null){
            System.out.println("El cliente no existe");
            presioneParaContinuar();
        }else{

            System.out.println("Nombre Cliente [ "+clienteNuevaCuenta.getNombre()+" "+clienteNuevaCuenta.getApellido()+" ]");
            System.out.println("\nQue tipo de cuenta desea crear ? \n1) Cuenta Corriente\n2) Caja de Ahorro");
            switch (pideNumeroEnteroConRango(1,2)) {
                case (1)://Nueva Cuenta Corriente
                    limpiaConsola();
                    System.out.println(this.cuentaCorrienteServicio.generaCuentaCorriente(this.creaCuentaCorriente(clienteNuevaCuenta),clienteNuevaCuenta.getNroCliente()));
                    presioneParaContinuar();
                    break;

                case(2)://Nueva Caja de Ahorro
                    limpiaConsola();
                    System.out.println(this.cajaDeAhorroServicio.generaCajaDeAhorro(this.creaCajaDeAhorro(clienteNuevaCuenta),clienteNuevaCuenta.getNroCliente()));
                    presioneParaContinuar();
                    break;
            }
        }




    /**
     * - Buscar cliente por DNI
     * - Elegir si va a ser una CuentaAhorro o CajaDeAhorro
     * - Creale un CBU unico mirando todas las cuentas existentes en la BD
     * - Poner una clave, verificada en la capa de Servicios (3 digitos Enteros)
     * - Setear el salarioPorMes: en algun debe estar esta condicion de que el salarioDeudor
     * debe ser menor a la mitad al salarioPorMes,(Capa Servicios) y que cuando se haga un
     * deposito primero se cargue esto, luego se carga el balancePesos
     */
    }

    public void listaClientesPorSucursal(){

        limpiaConsola();
        System.out.print(this.clienteServicio.listarClientesPorSucursal());
        presioneParaContinuar();

    }

    public void listarClientesDeUnaSucursal(){

        //Listo los bancos
        limpiaConsola();
        System.out.print("\nElija el banco : \n"+this.bancoServicio.listarBancos());

        //Elegimos el banco
        Integer eleccionBanco;
        do {
            eleccionBanco = pideNumeroEntero("Ingrese el ID del banco : ");
        }while (!this.bancoServicio.existeIdBancos(eleccionBanco));

        //Listo las sucursales del banco elegido
        limpiaConsola();
        System.out.print("\nElija la sucursal :\n"+this.sucursalServicio.listarSucursalesPorIdBanco(eleccionBanco));

        //Elegimos la sucursal
        Integer eleccionSucursal;
        do {
            eleccionSucursal = pideNumeroEntero("Ingrese el ID de la sucursal : ");
        }while (!this.sucursalServicio.existeIdSucursalPorBanco(eleccionBanco,eleccionSucursal));

        limpiaConsola();
        System.out.print(this.clienteServicio.listarClientesPorNroSucursal(eleccionSucursal));
        presioneParaContinuar();

    }

    public Cuenta entrandoEnCuenta(){

        limpiaConsola();
        Cuenta cuentaAIngresar = this.cuentaServicio.entrandoACuenta(pideLong("Ingrese Cbu de su cuenta : ")
                ,pideString("Ingrese Clave de su cuenta : ")) ;

        if(cuentaAIngresar != null){

            cuentaAIngresar.setDuenio(this.clienteServicio.dameClientePorNro(cuentaAIngresar.getDuenio().getNroCliente()));
            return cuentaAIngresar;

        }else {

            return null;
        }

    }

    public String eleccionMoneda(){

        System.out.println("Elija el tipo de moneda : \n1) Pesos\n2) Dolares");
        switch (pideNumeroEnteroConRango(1,2)){
            case 1:
                return "pesos";
            case 2:
                return "dolares";
        }
        return "";

    }

    public void extraerDinero(){

        Cuenta cuentaAEntrar = this.entrandoEnCuenta();

        if(cuentaAEntrar == null){

            System.out.println("\nError al iniciar Sesion");

        }else if(cuentaAEntrar instanceof CuentaCorriente){

            limpiaConsola();
            System.out.println(this.cuentaCorrienteServicio.imprimeCuenta((CuentaCorriente)cuentaAEntrar));

            if(this.cuentaCorrienteServicio.extraerDinero((CuentaCorriente)cuentaAEntrar,
                    pideNumeroDoublePositivo("Ingrese la cantidad de dinero a Extraer : "))){

                System.out.println("\nUsted retiró exitosamente su dinero !!");

            }else {

                System.out.println("\nUsted no tiene esa cantidad de dinero para extraer");

            }

        }else if(cuentaAEntrar instanceof CajaDeAhorro) {

            limpiaConsola();
            System.out.println(this.cajaDeAhorroServicio.imprimeCuenta((CajaDeAhorro) cuentaAEntrar));
            if (this.cajaDeAhorroServicio.extraerDinero((CajaDeAhorro) cuentaAEntrar,
                    this.eleccionMoneda(), pideNumeroDoublePositivo("Ingrese la cantidad a extraer : "))) {

                System.out.println("Usted retiró exitosamente su dinero");

            } else {

                System.out.println("Usted no tiene esa cantidad de dinero para extraer");

            }
        }

        presioneParaContinuar();

    }

    public void consultarSaldo(){

        Cuenta cuentaAEntrar = this.entrandoEnCuenta();

        if(cuentaAEntrar == null){

            System.out.println("\nError al iniciar Sesion");

        }else if(cuentaAEntrar instanceof CuentaCorriente){

            limpiaConsola();
            System.out.print(this.cuentaCorrienteServicio.imprimeCuenta((CuentaCorriente)cuentaAEntrar));

        }else if(cuentaAEntrar instanceof CajaDeAhorro) {

            limpiaConsola();
            System.out.print(this.cajaDeAhorroServicio.imprimeCuenta((CajaDeAhorro) cuentaAEntrar));

        }

        presioneParaContinuar();

    }

    public void depositarDinero(){

        Cuenta cuentaAEntrar = this.entrandoEnCuenta();

        if(cuentaAEntrar == null){

            System.out.println("\nError al iniciar Sesion");

        }else if(cuentaAEntrar instanceof CuentaCorriente){

            limpiaConsola();
            System.out.println(this.cuentaCorrienteServicio.imprimeCuenta((CuentaCorriente)cuentaAEntrar));
            this.cuentaCorrienteServicio.depositarDinero((CuentaCorriente) cuentaAEntrar,pideNumeroDoublePositivo("Ingrese el dinero a depositar : "));
            System.out.println("\nEl deposito fue exitoso !");

        }else if(cuentaAEntrar instanceof CajaDeAhorro) {

            limpiaConsola();
            System.out.println(this.cajaDeAhorroServicio.imprimeCuenta((CajaDeAhorro) cuentaAEntrar));
            this.cajaDeAhorroServicio.depositarDinero((CajaDeAhorro) cuentaAEntrar, this.eleccionMoneda(), pideNumeroDoublePositivo("Ingrese el dinero a depositar : "));
            System.out.println("\nEl deposito fue exitoso !");

        }

        presioneParaContinuar();

    }

    public void transferirDinero(){

        Cuenta cuentaAEntrar = this.entrandoEnCuenta();

        if(cuentaAEntrar == null){

            System.out.println("\nError al iniciar Sesion");

        }else if(cuentaAEntrar instanceof CuentaCorriente){

            limpiaConsola();
            System.out.println(this.cuentaCorrienteServicio.imprimeCuenta((CuentaCorriente) cuentaAEntrar));
            if(this.cuentaServicio.transferirDinero(cuentaAEntrar,pideLong("Ingrese el CBU de la cuenta a transferir : "),
                    "pesos",pideNumeroDouble("Ingrese la cantidad de pesos a transferir : "))){

                System.out.println("\n La transferencia fue un exito !");
            }else{
                System.out.println("\n Error en la transferencia ");
            }


        }else if(cuentaAEntrar instanceof CajaDeAhorro){

            limpiaConsola();
            System.out.println(this.cajaDeAhorroServicio.imprimeCuenta((CajaDeAhorro) cuentaAEntrar));
            if(this.cuentaServicio.transferirDinero(cuentaAEntrar,pideLong("Ingrese el cbu de la cuenta a transferir : "),
                    this.eleccionMoneda(),pideNumeroDouble("Ingrese la cantidad de dinero a transferir : "))){

                System.out.println("\n La transferencia fue un exito !");
            }else{
                System.out.println("\n Error en la transferencia ");
            }

        }
        presioneParaContinuar();

    }

    public void eliminarSucursal(){

        limpiaConsola();
        System.out.println(this.sucursalServicio.listaSucursalesQueSePuedenBorrar());
        Integer idSucursalABorrar = 0;
        do{
            idSucursalABorrar = pideNumeroEntero("Ingrese el id de la sucursal a Borrar : ");
        }while (!this.sucursalServicio.existeIdSucursalABorrar(idSucursalABorrar));

        Integer idSucursalAmiga = this.sucursalServicio.dameIdSucursalAmiga(idSucursalABorrar);

        //actualizar clientes
        this.clienteServicio.actualizaIdSucursal(idSucursalABorrar,idSucursalAmiga);
        //actualizar empleados
        this.empleadoServicio.actualizaIdSucursal(idSucursalABorrar,idSucursalAmiga);
        //eliminar sucursalVieja
        this.sucursalServicio.eliminarSucursal(idSucursalABorrar);

        System.out.println("\nSe elimino la sucursal");
        presioneParaContinuar();

    }

    public void menuPrincipal() {

        System.out.print("**********MENU PRINCIPAL**********" +
                "\n\n1) Agregar Cliente" +
                "\n2) Agregar cuenta a Cliente" +
                "\n3) Listar Clientes por sucursal" +
                "\n4) Listar Clientes de una sucursal" +
                "\n5) Extraer dinero" +
                "\n6) Consultar Saldo" +
                "\n7) Realizar Deposito" +
                "\n8) Realizar transferencias" +
                "\n9) Eliminar una sucursal\n");

        switch (pideNumeroEnteroConRango(1, 9))
        {
            case 1:
                this.agregarCliente();
                break;

            case 2:
                this.agregarCuentaCliente();
                break;

            case 3:
                this.listaClientesPorSucursal();
                break;

            case 4:
                this.listarClientesDeUnaSucursal();
                break;

            case 5:
                this.extraerDinero();
                break;

            case 6:
                this.consultarSaldo();
                break;

            case 7:
                this.depositarDinero();
                break;

            case 8:
                this.transferirDinero();
                break;

            case 9:
                this.eliminarSucursal();
                break;
        }

    }
}
