package modelo;

public class Medico extends Empleado{
    private String especialidad;
    private int numeroPacientesAtentidos;
    private double valorConsulta;

    public Medico(String cedula, String nombre, int edad, String telefono, String correo, String especialidad, int numeroPacientesAtentidos, double valorConsulta) {
        super(cedula, nombre, edad, telefono, correo);
        this.especialidad = especialidad;
        this.numeroPacientesAtentidos = numeroPacientesAtentidos;
        this.valorConsulta = valorConsulta;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getNumeroPacientesAtentidos() {
        return numeroPacientesAtentidos;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setNumeroPacientesAtentidos(int numeroPacientesAtentidos) {
        this.numeroPacientesAtentidos = numeroPacientesAtentidos;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }



    @Override
    public double calcularPago() {
        return numeroPacientesAtentidos*valorConsulta;
    }
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Pacientes atendidos: " + getNumeroPacientesAtentidos();
        System.out.println("Valor consulta: " + valorConsulta);
        System.out.println("Pago: " + calcularPago());
        System.out.println("-----------------------------");
    }
}
