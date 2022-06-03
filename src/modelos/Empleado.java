package modelos;

public class Empleado extends Persona{

    private Double salario;

    public Empleado(){
        super();
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
