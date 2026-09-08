package Taller_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class principal {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        SistemaEstudiante sistema
                = new SistemaEstudiante();

        // ESTUDIANTES DE EJEMPLO
        sistema.registrarEstudiante(1, "Ana");
        sistema.registrarEstudiante(2, "Carlos");
        sistema.registrarEstudiante(3, "Maria");
        sistema.registrarEstudiante(4, "Luis");
        sistema.registrarEstudiante(5, "Pedro");

        // CALIFICACIONES DE EJEMPLO
        sistema.registrarCalificacion(1, 15);
        sistema.registrarCalificacion(1, 18);
        sistema.registrarCalificacion(1, 17);

        sistema.registrarCalificacion(2, 14);
        sistema.registrarCalificacion(2, 16);
        sistema.registrarCalificacion(2, 18);

        sistema.registrarCalificacion(3, 19);
        sistema.registrarCalificacion(3, 17);

        sistema.registrarCalificacion(4, 13);
        sistema.registrarCalificacion(4, 15);

        sistema.registrarCalificacion(5, 18);
        sistema.registrarCalificacion(5, 20);
        sistema.registrarCalificacion(5, 19);

        // 1. REGISTRAR ESTUDIANTE
        try {

            System.out.println(
                    "===== REGISTRO DE ESTUDIANTES ====="
            );

            System.out.println(
                    "Ingrese codigo del estudiante:"
            );

            int codigo = leer.nextInt();

            validarCodigo(codigo);

            // Verificar si el codigo ya existe
            Estudiante estudiante
                    = sistema.buscarEstudiante(codigo);

            if (estudiante != null) {

                throw new IllegalArgumentException(
                        "El codigo del estudiante ya existe."
                );
            }

            // Solo pide el nombre si el codigo es nuevo
            System.out.println(
                    "Ingrese nombre del estudiante:"
            );

            String nombre = leer.next();

            validarNombre(nombre);

            sistema.registrarEstudiante(
                    codigo,
                    nombre
            );

            System.out.println(
                "Estudiante registrado correctamente en el sistema."
            );

        } catch (InputMismatchException e) {

            System.out.println(
                    "el dato ingresado no es correcto."
            );

            leer.close();
            return;

        } catch (IllegalArgumentException e) {

            System.out.println(
                    e.getMessage()
            );

            leer.close();
            return;
        }

        // 2. REGISTRAR CALIFICACION
        try {

            System.out.println(
                    "\n===== REGISTRO DE CALIFICACION ====="
            );

            System.out.println(
                    "Ingrese codigo del estudiante:"
            );

            int codigoCalificacion
                    = leer.nextInt();

            // Verificar si el estudiante existe
            Estudiante estudiante
                    = sistema.buscarEstudiante(
                            codigoCalificacion
                    );

            if (estudiante == null) {

                throw new IllegalArgumentException(
                        "El estudiante no existe."
                );
            }

            // Solo pide la calificacion si el estudiante existe
            System.out.println(
                    "Ingrese calificacion (0 - 20):"
            );

            double calificacion
                    = leer.nextDouble();

            validarCalificacion(
                    calificacion
            );

            sistema.registrarCalificacion(
                    codigoCalificacion,
                    calificacion
            );

            System.out.println(
                    "Calificacion registrada correctamente."
            );

        } catch (InputMismatchException e) {

            System.out.println(
                    "Tipo de dato ingresado no es correcto."
            );

            leer.close();
            return;

        } catch (IllegalArgumentException e) {

            System.out.println(
                    e.getMessage()
            );

            leer.close();
            return;
        }

        // 3. CALCULAR PROMEDIO
        try {

            System.out.println(
                    "\n===== CALCULAR PROMEDIO ====="
            );

            System.out.println(
                    "Ingrese codigo del estudiante:"
            );

            int codigoPromedio
                    = leer.nextInt();

            Estudiante estudiante
                    = sistema.buscarEstudiante(
                            codigoPromedio
                    );

            if (estudiante == null) {

                throw new IllegalArgumentException(
                        "El estudiante no existe."
                );
            }

            sistema.mostrarPromedio(
                    codigoPromedio
            );

        } catch (InputMismatchException e) {

            System.out.println(
                    "Tipo de dato ingresado no es correcto."
            );

            leer.close();
            return;

        } catch (IllegalArgumentException e) {

            System.out.println(
                    e.getMessage()
            );

            leer.close();
            return;
        }

        // 4. BUSCAR ESTUDIANTE
        try {

            System.out.println(
                    "\n===== BUSCAR ESTUDIANTE ====="
            );

            System.out.println(
                    "Ingrese codigo para buscar:"
            );

            int codigoBuscar
                    = leer.nextInt();

            Estudiante estudiante
                    = sistema.buscarEstudiante(
                            codigoBuscar
                    );

            if (estudiante == null) {

                throw new IllegalArgumentException(
                        "El estudiante no existe."
                );
            }

            System.out.println(
                    "Estudiante encontrado:"
            );

            System.out.println(
                    estudiante
            );

        } catch (InputMismatchException e) {

            System.out.println(
                    "Tipo de dato ingresado no es correcto."
            );

            leer.close();
            return;

        } catch (IllegalArgumentException e) {

            System.out.println(
                    e.getMessage()
            );

            leer.close();
            return;
        }

        // 5. LISTAR ESTUDIANTES
        System.out.println(
                "\n¿Desea listar los estudiantes? (si/no):"
        );

        String respuesta = leer.next();

        if (respuesta.equals("si")) {

            System.out.println(
                    "\n===== LISTA DE ESTUDIANTES ====="
            );

            sistema.listarEstudiantes();

        } else if (respuesta.equals("no")) {

            System.out.println(
                    "\nEl programa continúa..."
            );
        } else {

            System.out.println(
                    "\nRespuesta no valida."
            );

            System.out.println(
                    "El programa continúa..."
            );
        }

        leer.close();
    }

    // --VALIDAMOS--
    // Validar codigo
    public static void validarCodigo(int codigo) {

        if (codigo <= 0) {

            throw new IllegalArgumentException(
                    "El codigo debe ser mayor que cero."
            );
        }
    }

    // Validar nombre
    public static void validarNombre(String nombre) {

        if (nombre.length() == 0) {

            throw new IllegalArgumentException(
                    "El nombre no puede estar vacio."
            );
        }
    }

    // Validar calificacion
    public static void validarCalificacion(
            double calificacion) {

        if (calificacion < 0
                || calificacion > 20) {

            throw new IllegalArgumentException(
                    "La calificacion debe estar entre 0 y 20."
            );
        }
    }

}

