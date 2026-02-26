/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author laboratorio
 */
import logica.ServicioUsuario;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ServicioUsuario servicio = new ServicioUsuario();
        int opcion = 0;

        do {
            System.out.println("\n--- MENU DEL SISTEMA  ---");
            System.out.println("1. REGISTRAR UN USUARIO");
            System.out.println("2. LISTAR LOS USUARIO");
            System.out.println("3. SALIR");
            System.out.print("SELECCIONE UNA OPCIÓN");
            System.out.println("\n-----------------------");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Correo: ");
                        String correo = sc.nextLine();

                        servicio.registrarUsuario(nombre, correo);
                        break;

                    case 2:
                        servicio.mostrarUsuarios();
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida ):");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido ):");
            }

        } while (opcion != 3);

        sc.close();
    }
}
