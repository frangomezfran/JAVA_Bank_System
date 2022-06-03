package modelos;

public class Empleado extends Persona{

    private Double salario;

    public Empleado(){
        super();
    }

    public Empleado(String nombre, String apellido, Long dni, String domicilio, String telefono, Integer cuil, Integer idSucursal, Double salario) {
        super(nombre, apellido, dni, domicilio, telefono, cuil, idSucursal);
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
