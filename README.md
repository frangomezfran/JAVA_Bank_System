
# Proyecto Aplicación de un Sistema Bancario

## Consigna

**Tomando como punto de partida el diagrama de Clases del sistema de Gestión Bancaria construya una aplicación que
permita realizar las siguientes operaciones:**

**MENU PRINCIPAL**
1) Agregar Cliente
2) Agregar cuenta a Cliente
3) Listar Clientes por sucursal
4) Listar Clientes de una sucursal
5) Extraer dinero
6) Consultar Saldo
7) Realizar Deposito
8) Realizar transferencias
9) Eliminar una sucursal

**MENU CLIENTE-CUENTA**
1) Alta de Caja de Ahorro en Pesos
2) Alta de Caja de Ahorro en dólares
3) Alta de Cuenta Corriente en Pesos
4) Alta de Cuenta Corriente en dólares

**PAUTAS:**
1) El alta de un cliente comprende también:
   a. Dar de alta una cuenta o más de una.
2) El agregar cuenta a Cliente implica dar de alta una cuenta nueva solicitada por el cliente.
3) El banco debe tener al menos una sucursal, que deben estar predefinidas antes de iniciar la ejecución de su programa.
4) Para poder eliminar una sucursal, el banco debe tener al menos dos sucursales de tal forma que la cartera de
   clientes y empleados de la sucursal a eliminar se pase a la otra sucursal.
5) Las transferencias pueden ser entre cuentas del mismo cliente o a cuentas de terceros.
6) Las transacciones monetarias se realizan sobre las cuentas del cliente.

**-------------------------------------------------------------------------------------------------------------------------**
## Aclaración

**Este proyecto es un ejercicio principalmente para ejercitar la programación en capas en Java y conectar una Base de
datos al mismo por lo tanto en el progreso del sistema, me surgen diferentes conflictos que se pueden generar a
futuro y quiero enlistarlos**

En este momento estoy haciendo el DER y el UML
- Según los tipos de bancos que existen las cuentas que ofrecen tienen diferentes tipos
de características, en este caso, todos los bancos brindan los mismos servicios a los clientes
- En los bancos los tipos de personas que tienen cuentas bancarias no solo son personas físicas o
en este caso solo clientes (no empleados)
- las operaciones que realiza las cuentas no quedan registradas ya sea extracción, deposito
o una transferencia
- El saldo negativo tope de una cuenta corriente es la mitad del saldo por mes
- En este contexto los empleadores solo pagan a sus empleados por medio de una cuenta corriente
- En el ejercicio es obligatorio separar la cuenta de ahorro y la cuenta corriente en dos diferentes clases,
por lo tanto debo buscar atributos para cada una, en este caso voy a hacer que la cuenta de ahorro
se pueda tener un balance en dólares
- Por un tema de prolijidad en vez de que el empleado tenga legajo, lo llame nroEmpleado
- Iba a hacer una entidad Domicilio pero no, porque me lleva mas tiempo
- En algún momento necesitaré listar las cuentas del banco, para eso, necesito algún registro en la BD
la idea es que a partir de una cuenta, miro el cliente, luego la sucursal de donde pertenece este cliente
y luego sabiendo la sucursal sé el banco a cual pertenece esa cuenta. En el modelado de clases, dudo que
atributo poner o si el banco como objeto o el idBanco, creo q esta ultima opción es la mejor, ya que por
ahora no creo q necesite los datos del banco desde la sucursal en Java
- El area del empleado tranquilamente también puede ser una entidad en la BD
- La creación del CBU de las cuentas se hacen mirando todas las cuentas existentes de la BD, para que
sean únicas
- En este caso mi programa no crea nuevos bancos, lo hago directamente en el script de la BD, si lo hago en mi programa
 debo hacer que no existan nombres repetidos
- En la lista de Clientes y luego de Empleados de las sucursales, podría tener una lista de Personas y luego saber q
 tipo de persona es cada una con métodos

### Cosas pendientes
- Ver los cierres de la conexión con la BD
- Modularizar existeIdSucursalPorBanco en SucursalServicio, para que haya un solo método
- Mi librería no tiene la carpeta .cj, es la que utilizo para el Driver de la BD
