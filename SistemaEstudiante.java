 
package Taller_01;

import java.util.ArrayList;

 
public class SistemaEstudiante {
    private ArrayList<Estudiante> estudiantes;

    public SistemaEstudiante() {
        estudiantes = new ArrayList<>();
    }

    // Registrar estudiante
   public void registrarEstudiante(int codigo, String nombre) {

    if (buscarEstudiante(codigo) != null) {
        throw new IllegalArgumentException(
            "El codigo del estudiante ya existe."
        );
    }

    Estudiante nuevo = new Estudiante(codigo, nombre);
    estudiantes.add(nuevo);
}


    // Buscar estudiante por código
    public Estudiante buscarEstudiante(int codigo) {

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getCodigo() == codigo) {
                return estudiante;
            }
        }

        return null;
    }

    // Listar estudiantes
    public void listarEstudiantes() {

        if (estudiantes.size() == 0) {
         System.out.println("No existen estudiantes registrados.");
        return;
        }


        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    // Registrar calificación
    public void registrarCalificacion(int codigo, double calificacion) {

    Estudiante estudiante = buscarEstudiante(codigo);

    if (estudiante == null) {
        throw new IllegalArgumentException(
                "El estudiante no existe."
        );
    }

    estudiante.registrarCalificacion(calificacion);
}


    // Mostrar promedio
    public void mostrarPromedio(int codigo) {

        Estudiante estudiante = buscarEstudiante(codigo);

        if (estudiante == null) {
            System.out.println("El estudiante no existe.");
            return;
        }

        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Promedio: " + estudiante.calcularPromedio());
    }
}
