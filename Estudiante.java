 
package Taller_01;
 
import java.util.ArrayList;

public class Estudiante {

    private int codigo;
    private String nombre;
    private ArrayList<Double> calificaciones;

    public Estudiante(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void registrarCalificacion(double calificacion) {
        calificaciones.add(calificacion);
    }

    public double calcularPromedio() {

        if (calificaciones.size() == 0) {
     return 0;
    }


        double suma = 0;

        for (double calificacion : calificaciones) {
            suma = suma + calificacion;
        }

        return suma / calificaciones.size();
    }

    @Override
    public String toString() {

        return "Código: " + codigo + ", Nombre: " + nombre + ", Calificaciones: " + calificaciones + ", Promedio: " + calcularPromedio();
    }
}
